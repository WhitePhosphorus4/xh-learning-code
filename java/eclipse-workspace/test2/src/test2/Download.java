package test2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Download {

	public static String encoding = "utf-8";
	// 正则表达式
	private static String regex = "^((https:|http:|ftp:|rtsp:|mms:)?//)" // https、http、ftp、rtsp、mms
			+ "(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" // ftp的user@
			+ "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL- 例如：199.194.52.184
			+ "|" // 允许IP和DOMAIN（域名）
			+ "([0-9a-z_!~*'()-]+\\.)*" // 域名- www.
			+ "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名
			+ "[a-z]{2,6})" // first level domain- .com or .museum
			+ "(:[0-9]{1,5})?" // 端口号最大为65535,5位数
			+ "((/?)|" // a slash isn't required if there is no file name
			+ "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
	// 命名规格化
	private static Pattern FilePattern = Pattern.compile("[\\\\/:*?\"<>|]");
	public static String status_cont = "";

	public static String filenameFilter(String str) {
		str = str == null ? null : FilePattern.matcher(str).replaceAll("");
		if (str.length() > 20)
			str = str.substring(0, 20);
		return str;
	}

	// 根据url获得文件名称
	public static String get_filename(String url) {
		String filename = "";
		boolean flag = false;
		try {
			URL myurl = new URL(url);
			URLConnection conn = myurl.openConnection();
			if (conn == null) {
				System.out.println("--- url连接失败 ---\n");
				return null;
			}
			Map<String, List<String>> hf = conn.getHeaderFields();
			if (hf == null) {
				return null;
			}
			Set<String> key = hf.keySet();
			if (key == null) {
				return null;
			}
			for (String skey : key) {
				List<String> values = hf.get(skey);
				for (String value : values) {
					String result;
					try {
						result = new String(value.getBytes("ISO-8859-1"), "GBK");
						int location = result.indexOf("filename");
						if (location >= 0) {
							result = result.substring(location + "filename".length());
							filename = result.substring(result.indexOf("=") + 1);
							flag = true;
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					} // ISO-8859-1 UTF-8 gb2312
				}
				if (flag) {
					break;
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 从路径中获取
		if (filename == null || "".equals(filename)) {
			filename = url.substring(url.lastIndexOf("/") + 1);
		}
		return filenameFilter(filename);
	}

	// 修改父文件里的链接
	private static boolean modify(File file, String oldstr, String newstr) {
		try {
			String path = file.getPath();
			int index = path.lastIndexOf('\\');
			String tmp_path = path.substring(0, index);
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file))); // 创建对目标文件读取流
			File newFile = new File(tmp_path + "\\tmp.txt"); // 创建临时文件
			if (!newFile.exists()) {
				newFile.createNewFile(); // 不存在则创建
			}
			// 创建对临时文件输出流，并追加
			FileOutputStream fos = new FileOutputStream(tmp_path + "\\tmp.txt");
			String tmp = ""; // 存储对目标文件读取的内容
			while ((tmp = br.readLine()) != null) {
				// 判断读取的内容是否包含原字符串
				if (tmp.contains(oldstr)) {
					// 替换读取内容中的原字符串为新字符串
					newstr = "=\"file:\\\\\\" + newstr;
					newstr = newstr.replace("\\\\", "\\\\\\\\");
					tmp = tmp.replaceAll(oldstr, newstr);
				}
				fos.write(tmp.getBytes());
				fos.write("\n".getBytes());
			}
			fos.close();
			br.close(); // 关闭流，对文件进行删除等操作需先关闭文件流操作
			file.delete(); // 删除源文件
			newFile.renameTo(new File(path)); // 将新文件更名为源文件
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	// 判断是否为url
	public static boolean isURL(String str) {
		// 转换为小写
		str = str.toLowerCase();
		return str.matches(regex);
	}

	// 结果集传送定义
	public static class Res_send {
		private int bias = 0;
		private String statuscode = null;
		private String contentType = null;
		private int contentLen = -1;
		private String location = null;

		public int get_bias() {
			return bias;
		}

		public String get_statuscode() {
			return statuscode;
		}

		public String get_contentType() {
			return contentType;
		}

		public int get_contentLen() {
			return contentLen;
		}

		public String get_location() {
			return location;
		}

		public void set_bias(int bias) {
			this.bias = bias;
		}

		public void set_statuscode(String statuscode) {
			this.statuscode = statuscode;
		}

		public void set_contentType(String contentType) {
			this.contentType = contentType;
		}

		public void set_contentLen(int contentLen) {
			this.contentLen = contentLen;
		}

		public void set_location(String location) {
			this.location = location;
		}
	}

	// 结果集传送
	private static Res_send recv_http_h(BufferedReader reader, InputStream is, OutputStream os, Socket socket)
			throws NumberFormatException, IOException {
		Res_send res = new Res_send();
		String line = "";
		System.out.println("--- http包头接收开始 --- \n");
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
			// 判断包头是否发送结束
			if (line.length() == 0) {
				System.out.println("--- http包头接收完毕 ---\n");
				break;
			}
			res.set_bias(res.get_bias() + line.length() + 2); // 记录包头大小
			// 查看包头的 状态码 / 文件类型 / 文件长度
			int sc_idx = line.lastIndexOf("HTTP/1.1 ", 0);
			if (sc_idx != -1) {
				res.set_statuscode(line.substring(sc_idx + 9, sc_idx + 12));
			}
			int ct_idx = line.lastIndexOf("Content-Type: ", 0);
			if (ct_idx != -1) {
				res.set_contentType(line.substring(ct_idx + 14));
			}
			int cl_idx = line.lastIndexOf("Content-Length: ", 0);
			if (cl_idx != -1) {
				res.set_contentLen(Integer.valueOf(line.substring(ct_idx + 16).substring(1)).intValue());
			}
			int l_idx = line.lastIndexOf("Location: ", 0);
			if (l_idx != -1) {
				res.set_location(line.substring(l_idx + 10));
			}
		}
		return res;
	}

	// 根据url下载文件
	private static String url_download(String sourceURL, String domainName, String uri, String destLoc)
			throws IOException {
		// 建立socket连接 输入输出流获取 封装socket输入输出流
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		InetAddress addr;
		try {
			addr = InetAddress.getByName(domainName);
		} catch (UnknownHostException e) {
			return null;
		}
		String ip = addr.getHostAddress();
		// 建立socket连接 输入输出流获取 封装socket输入输出流
		socket = new Socket(ip, 80);
		is = socket.getInputStream();
		os = socket.getOutputStream();
		reader = new BufferedReader(new InputStreamReader(is, encoding));
		writer = new BufferedWriter(new OutputStreamWriter(os, encoding));
		// 通过socket发送http请求头，请求服务器的回复
		soc_request(writer, uri, domainName);
		// 接收http头，用以判断包头大小，分割包头
		Res_send res = recv_http_h(reader, is, os, socket);
		socket.close();
		// 判断请求是否成功
		if (res.get_statuscode() == null)
			return null;
		else if (res.get_statuscode().equals("301") || res.get_statuscode().equals("302")) {
			String new_url = res.get_location();
			if (new_url == null)
				return null;
			else if (status_cont == sourceURL)
				return null;
			else {
				status_cont = new_url;
				String[] tmp = div_url(new_url);
				domainName = tmp[0]; // 域名
				uri = tmp[1]; // 路径
				return url_download(new_url, domainName, uri, destLoc);
			}
		} else if (!res.get_statuscode().equals("200") && !res.get_statuscode().equals("206"))
			return null;
		// 重新建立连接 防止对inputstream的复用 这次只能由字节流读取
		socket = new Socket(ip, 80);
		os = socket.getOutputStream();
		writer = new BufferedWriter(new OutputStreamWriter(os, encoding));
		soc_request(writer, uri, domainName);
		// 文件流写入
		String path = file_write(sourceURL, socket, res.get_bias(), res.get_contentType(), destLoc);
		reader.close();
		writer.close();
		is.close();
		os.close();
		socket.close();
		return path;
	}

	// 找出下载文件中的url
	private static void sec_url(String path, String destLoc) throws IOException {
		File file = new File(path);
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String str = "";
		Vector<String> store = new Vector<String>();
		String temp = null;
		int index = 0;
		int len = -1;
		String[] url_list;
		String domainName = ""; // 域名
		String uri = ""; // 路径
		String child_path = "";
		while ((str = reader.readLine()) != null) {
			index++;
			temp = null;
			Pattern p = Pattern.compile("=\"" + "(https?)?:?//([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?");
			Matcher matcher = p.matcher(str);
			while (matcher.find())
				store.add(matcher.group());
			if (store.isEmpty())
				continue;
			else {
				len = store.size();
				reader.close();
			}
			for (int i = 0; i < len; i++) {
				temp = store.elementAt(i);
				url_list = div_url(temp);
				domainName = url_list[0]; // 域名
				uri = url_list[1]; // 路径
				child_path = url_download(temp, domainName, uri, destLoc);
				if (child_path == null)
					modify(file, temp, "");
				else
					modify(file, temp, child_path);
			}
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			for (int j = 0; j < index; j++)
				reader.readLine();
			store.clear();
		}
		reader.close();
	}

	// 从url中分割出域名和uri
	private static String[] div_url(String sourceURL) {
		String[] tmp = new String[2];
		tmp[0] = "";
		tmp[1] = "";
		tmp[0] = sourceURL.split("/")[2];
		tmp[1] = sourceURL.substring(sourceURL.lastIndexOf(tmp[0]) + tmp[0].length());
		if (tmp[1].length() == 0)
			tmp[1] = "/";
		return tmp;
	}

	// 通过socket发送http请求头，请求服务器的回复
	private static void soc_request(BufferedWriter writer, String uri, String domainName) throws IOException {
		writer.write("GET " + uri + " HTTP/1.1\r\n");
		writer.write("Host: " + domainName + "\r\n");
		writer.write("Connection: close\r\n"); // 记得发送请求关闭包
		writer.write("\r\n");
		writer.flush();
	}

	// 文件流写入
	private static String file_write(String sourceURL, Socket socket, int bias, String contentType, String destLoc)
			throws IOException {
		// System.out.println("--- 文件开始写入 --- \n");
		InputStream is = socket.getInputStream();
		is.skip(bias + 2); // 跳过包头 +2是回车换行
		String extension = "";
		if (contentType != null)
			extension = contentType.split("/")[1].split(";")[0];
		if (destLoc.lastIndexOf('\\') != destLoc.length() - 1)
			destLoc += "\\";
		if (!extension.equals("html")) {
			File file = new File(destLoc + extension);
			// 如果文件夹不存在则创建
			if (!file.exists() && !file.isDirectory()) {
				// System.out.println("--- 此文件夹不存在 --- \n");
				file.mkdir();
			} else {
				// System.out.println("--- 此文件夹已经存在 --- \n");
			}
			destLoc += (extension + "\\");
		}
		String fname = filenameFilter(get_filename(sourceURL)); // 文件名
		String path;
		int len;
		if (fname.contains("." + extension))
			path = destLoc + fname;
		else
			path = destLoc + fname + '.' + extension;
		File file = new File(path);
		// 查询文件是否存在，存在则返回""，否则写新的文件
		if (file.exists()) {
			System.out.println("--- 此文件已经存在 --- \n");
			System.out.println("--- 文件写入结束 --- \n");
			is.close();
			return "";
		} else {
			FileOutputStream fos = new FileOutputStream(path);
			byte[] buf = new byte[4096];
			while ((len = is.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}
			fos.close();
			is.close();
			System.out.println("--- 文件写入结束 --- \n");
			return path;
		}
	}

	// main函数
	public static void main(String[] args) throws IOException {
		// 文件url与本地保存路径
		String sourceURL;
		String destLoc;
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		System.out.println("Please input URL:");
		sourceURL = s.next();
		if (!isURL(sourceURL)) {
			System.out.println("wrong url");
			return;
		}
		System.out.println("Please input destLoc:");
		destLoc = s.next();
		String domainName = "";
		String uri = "";
		// 从url中分割出域名和uri
		String[] tmp = div_url(sourceURL);
		domainName = tmp[0]; // 域名
		uri = tmp[1]; // 路径
		// 根据url下载文件
		String path = url_download(sourceURL, domainName, uri, destLoc);
		// 找出下载文件中的url
		if (path == null) {
			System.out.println("--- 状态码非200或206 ---\n");
			return;
		} else if (path == "")
			return;
		else
			sec_url(path, destLoc);
	}

}
