#codeing=utf-8
 
 
import wx
import wx.html2
 
class MyBrowser(wx.Dialog):
    def __init__(self, *args, **kwds):
        wx.Dialog.__init__(self, *args, **kwds)
        sizer = wx.BoxSizer(wx.VERTICAL)
        self.browser = wx.html2.WebView.New(self)
        sizer.Add(self.browser, 1, wx.EXPAND, 10)
        self.SetSizer(sizer)
        self.SetSize((700, 700))
 
if __name__ == '__main__':
    app = wx.App()
    dialog = MyBrowser(None, -1)
    #加载页面。如果是加载html字符串应该使用  dialog.browser.SetPage(html_string,"")
    dialog.browser.LoadURL("https://leetcode-cn.com/problemset/all/") 
    dialog.Show()
    app.MainLoop()