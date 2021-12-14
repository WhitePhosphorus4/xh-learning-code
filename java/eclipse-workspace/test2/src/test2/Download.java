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
	// ������ʽ
	private static String regex = "^((https:|http:|ftp:|rtsp:|mms:)?//)" // https��http��ftp��rtsp��mms
			+ "(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" // ftp��user@
			+ "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP��ʽ��URL- ���磺199.194.52.184
			+ "|" // ����IP��DOMAIN��������
			+ "([0-9a-z_!~*'()-]+\\.)*" // ����- www.
			+ "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // ��������
			+ "[a-z]{2,6})" // first level domain- .com or .museum
			+ "(:[0-9]{1,5})?" // �˿ں����Ϊ65535,5λ��
			+ "((/?)|" // a slash isn't required if there is no file name
			+ "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
	// �������
	private static Pattern FilePattern = Pattern.compile("[\\\\/:*?\"<>|]");
	public static String status_cont = "";

	public static String filenameFilter(String str) {
		str = str == null ? null : FilePattern.matcher(str).replaceAll("");
		if (str.length() > 20)
			str = str.substring(0, 20);
		return str;
	}

	// ����url����ļ�����
	public static String get_filename(String url) {
		String filename = "";
		boolean flag = false;
		try {
			URL myurl = new URL(url);
			URLConnection conn = myurl.openConnection();
			if (conn == null) {
				System.out.println("--- url����ʧ�� ---\n");
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
		// ��·���л�ȡ
		if (filename == null || "".equals(filename)) {
			filename = url.substring(url.lastIndexOf("/") + 1);
		}
		return filenameFilter(filename);
	}

	// �޸ĸ��ļ��������
	private static boolean modify(File file, String oldstr, String newstr) {
		try {
			String path = file.getPath();
			int index = path.lastIndexOf('\\');
			String tmp_path = path.substring(0, index);
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file))); // ������Ŀ���ļ���ȡ��
			File newFile = new File(tmp_path + "\\tmp.txt"); // ������ʱ�ļ�
			if (!newFile.exists()) {
				newFile.createNewFile(); // �������򴴽�
			}
			// ��������ʱ�ļ����������׷��
			FileOutputStream fos = new FileOutputStream(tmp_path + "\\tmp.txt");
			String tmp = ""; // �洢��Ŀ���ļ���ȡ������
			while ((tmp = br.readLine()) != null) {
				// �ж϶�ȡ�������Ƿ����ԭ�ַ���
				if (tmp.contains(oldstr)) {
					// �滻��ȡ�����е�ԭ�ַ���Ϊ���ַ���
					newstr = "=\"file:\\\\\\" + newstr;
					newstr = newstr.replace("\\\\", "\\\\\\\\");
					tmp = tmp.replaceAll(oldstr, newstr);
				}
				fos.write(tmp.getBytes());
				fos.write("\n".getBytes());
			}
			fos.close();
			br.close(); // �ر��������ļ�����ɾ���Ȳ������ȹر��ļ�������
			file.delete(); // ɾ��Դ�ļ�
			newFile.renameTo(new File(path)); // �����ļ�����ΪԴ�ļ�
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	// �ж��Ƿ�Ϊurl
	public static boolean isURL(String str) {
		// ת��ΪСд
		str = str.toLowerCase();
		return str.matches(regex);
	}

	// ��������Ͷ���
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

	// ���������
	private static Res_send recv_http_h(BufferedReader reader, InputStream is, OutputStream os, Socket socket)
			throws NumberFormatException, IOException {
		Res_send res = new Res_send();
		String line = "";
		System.out.println("--- http��ͷ���տ�ʼ --- \n");
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
			// �жϰ�ͷ�Ƿ��ͽ���
			if (line.length() == 0) {
				System.out.println("--- http��ͷ������� ---\n");
				break;
			}
			res.set_bias(res.get_bias() + line.length() + 2); // ��¼��ͷ��С
			// �鿴��ͷ�� ״̬�� / �ļ����� / �ļ�����
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

	// ����url�����ļ�
	private static String url_download(String sourceURL, String domainName, String uri, String destLoc)
			throws IOException {
		// ����socket���� �����������ȡ ��װsocket���������
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
		// ����socket���� �����������ȡ ��װsocket���������
		socket = new Socket(ip, 80);
		is = socket.getInputStream();
		os = socket.getOutputStream();
		reader = new BufferedReader(new InputStreamReader(is, encoding));
		writer = new BufferedWriter(new OutputStreamWriter(os, encoding));
		// ͨ��socket����http����ͷ������������Ļظ�
		soc_request(writer, uri, domainName);
		// ����httpͷ�������жϰ�ͷ��С���ָ��ͷ
		Res_send res = recv_http_h(reader, is, os, socket);
		socket.close();
		// �ж������Ƿ�ɹ�
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
				domainName = tmp[0]; // ����
				uri = tmp[1]; // ·��
				return url_download(new_url, domainName, uri, destLoc);
			}
		} else if (!res.get_statuscode().equals("200") && !res.get_statuscode().equals("206"))
			return null;
		// ���½������� ��ֹ��inputstream�ĸ��� ���ֻ�����ֽ�����ȡ
		socket = new Socket(ip, 80);
		os = socket.getOutputStream();
		writer = new BufferedWriter(new OutputStreamWriter(os, encoding));
		soc_request(writer, uri, domainName);
		// �ļ���д��
		String path = file_write(sourceURL, socket, res.get_bias(), res.get_contentType(), destLoc);
		reader.close();
		writer.close();
		is.close();
		os.close();
		socket.close();
		return path;
	}

	// �ҳ������ļ��е�url
	private static void sec_url(String path, String destLoc) throws IOException {
		File file = new File(path);
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String str = "";
		Vector<String> store = new Vector<String>();
		String temp = null;
		int index = 0;
		int len = -1;
		String[] url_list;
		String domainName = ""; // ����
		String uri = ""; // ·��
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
				domainName = url_list[0]; // ����
				uri = url_list[1]; // ·��
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

	// ��url�зָ��������uri
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

	// ͨ��socket����http����ͷ������������Ļظ�
	private static void soc_request(BufferedWriter writer, String uri, String domainName) throws IOException {
		writer.write("GET " + uri + " HTTP/1.1\r\n");
		writer.write("Host: " + domainName + "\r\n");
		writer.write("Connection: close\r\n"); // �ǵ÷�������رհ�
		writer.write("\r\n");
		writer.flush();
	}

	// �ļ���д��
	private static String file_write(String sourceURL, Socket socket, int bias, String contentType, String destLoc)
			throws IOException {
		// System.out.println("--- �ļ���ʼд�� --- \n");
		InputStream is = socket.getInputStream();
		is.skip(bias + 2); // ������ͷ +2�ǻس�����
		String extension = "";
		if (contentType != null)
			extension = contentType.split("/")[1].split(";")[0];
		if (destLoc.lastIndexOf('\\') != destLoc.length() - 1)
			destLoc += "\\";
		if (!extension.equals("html")) {
			File file = new File(destLoc + extension);
			// ����ļ��в������򴴽�
			if (!file.exists() && !file.isDirectory()) {
				// System.out.println("--- ���ļ��в����� --- \n");
				file.mkdir();
			} else {
				// System.out.println("--- ���ļ����Ѿ����� --- \n");
			}
			destLoc += (extension + "\\");
		}
		String fname = filenameFilter(get_filename(sourceURL)); // �ļ���
		String path;
		int len;
		if (fname.contains("." + extension))
			path = destLoc + fname;
		else
			path = destLoc + fname + '.' + extension;
		File file = new File(path);
		// ��ѯ�ļ��Ƿ���ڣ������򷵻�""������д�µ��ļ�
		if (file.exists()) {
			System.out.println("--- ���ļ��Ѿ����� --- \n");
			System.out.println("--- �ļ�д����� --- \n");
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
			System.out.println("--- �ļ�д����� --- \n");
			return path;
		}
	}

	// main����
	public static void main(String[] args) throws IOException {
		// �ļ�url�뱾�ر���·��
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
		// ��url�зָ��������uri
		String[] tmp = div_url(sourceURL);
		domainName = tmp[0]; // ����
		uri = tmp[1]; // ·��
		// ����url�����ļ�
		String path = url_download(sourceURL, domainName, uri, destLoc);
		// �ҳ������ļ��е�url
		if (path == null) {
			System.out.println("--- ״̬���200��206 ---\n");
			return;
		} else if (path == "")
			return;
		else
			sec_url(path, destLoc);
	}

}
