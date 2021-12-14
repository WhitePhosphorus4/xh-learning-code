import wx
class App(wx.App):
   def OnInit(self):
       self.locale = wx.Locale(wx.LANGUAGE_CHINESE)
       return 1

def A(evt):
   print("hello")
   f.Maximize()
def B(evt):
   b.SetBackgroundColour("#FFFFFF")
def C(evt):
   b.SetBackgroundColour("#EFEFEF")

app = App()
f = wx.Frame(None, -1, "Hello", [700, 500])
wx.Button(f, size = [0, 0])
#s = wx.Image("uu.png", wx.BITMAP_TYPE_ANY).ConvertToBitmap()
b = wx.Button(f, -1,'Hello', size = [80, 30], style = wx.BORDER_NONE)
#bb= wx.StaticBitmap(b, -1, wx.Image("uu.png", wx.BITMAP_TYPE_ANY).ConvertToBitmap())
b.SetBackgroundColour("#FEFEFE")
b.Bind(wx.EVT_BUTTON, A)
b.Bind(wx.EVT_ENTER_WINDOW, B)
b.Bind(wx.EVT_LEAVE_WINDOW, C)
f.Show()
app.MainLoop()