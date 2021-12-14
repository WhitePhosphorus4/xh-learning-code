
'''
Created on 2018年11月21日
@author: Administrator
'''
# 第13 章， WxPython 库中的基本组件
#基本组件包括： 文本框， 按钮， 单选框， 复选框， 列表等。 wxPython提供了 Grid , Flex, Box 等布局管理器， 对程序进行美化
import wx 
 
def test_txt():
    class TextFrame(wx.Frame):
        def __init__(self):
            wx.Frame.__init__(self, None, -1, 'Text', size=(300, 300))  # 这里自定义 parent 为  None
            panel = wx.Panel(self, -1)
            
            text = wx.StaticText(panel, -1, 'Hello World', (10, 10), (80, 15), 
                                wx.ALIGN_LEFT) #文本的左上角坐标为 (10,10), 长宽为(80,15)， 左对齐
            text.SetForegroundColour(colour='blue')  # 设置前景色
            text.SetBackgroundColour(colour='white') # 设置背景色
            
            font = wx.Font(12, wx.DEFAULT, wx.ITALIC, wx.NORMAL, True)  #创建字体类型，True 为下划线
            text.SetFont(font)                                          # 设置字体
            
            
    class MyApp(wx.App):
        def OnInit(self):
            self.frame = TextFrame()
            
            self.frame.Show(True)
            return True
    
    app =  MyApp()
    app.MainLoop()
    
# test_txt()
 
# 单行文本框 TextCtrl ， 简单输入系统
def test_TextCtrl():
    class MyFrame(wx.Frame):
        def __init__(self):
            wx.Frame.__init__(self, None, -1, u'文本框', size=(300, 150))  # 这里自定义 parent 为  None
            panel = wx.Panel(self, -1)
            
            label1 = wx.StaticText(panel, -1, u'姓名', pos=(10, 10))
            self.inputText = wx.TextCtrl(panel, -1, '', pos=(60, 10), size=(150, -1))   #文本框对象
            self.inputText.SetInsertionPoint(pos=0)   # 设置光标
            
            label2 = wx.StaticText(panel, -1, u'密码', pos=(10, 50))
            self.pwdText = wx.TextCtrl(panel, -1, '', pos=(60, 50), size=(150, -1), 
                                        style = wx.TE_PASSWORD | wx.TE_PROCESS_ENTER)   #不显示密码，enter处理
            self.pwdText.SetInsertionPoint(pos=0)
            self.Bind(wx.EVT_TEXT_ENTER, self.OnLostFocus, self.pwdText)    #绑定 EVT_TEXT_ENTER， 按下Enter时触发
        
        def OnLostFocus(self, event):
            if self.pwdText.GetValue() == '123':    #假设一个密码
                wx.MessageBox('欢迎您!  '+ '%s'%(self.inputText.GetValue()))   #弹出对话框
            else:
                wx.MessageBox('您好! '+ '%s'%(self.inputText.GetValue()) + ', 密码错误！ ')
            
    class MyApp(wx.App):
        def OnInit(self):
            self.frame = MyFrame()
            
            self.frame.Show(True)
            return True
    
    app =  MyApp()
    app.MainLoop()
    
# test_TextCtrl()
 
#按钮控件 ， button, 点击确定按钮， 在窗口中显示出  'Hello World'
def test_button():
    class MyFrame(wx.Frame):
        def __init__(self):
            wx.Frame.__init__(self, None, -1, u'文本框', size=(300, 150))  # 这里自定义 parent 为  None
            panel = wx.Panel(self, -1)
            
            self.button = wx.Button(panel, -1, u'确定', pos=(10, 10))
            self.Bind(wx.EVT_BUTTON, self.OnClick, self.button)
            self.button.SetDefault()
            self.inputext = wx.TextCtrl(panel, -1, '', pos=(100, 10), size=(150, -1), 
                                       style = wx.TE_READONLY)
        
        def OnClick(self, event):    
            self.inputext.Value='Hello World'
            
    class MyApp(wx.App):
        def OnInit(self):
            self.frame = MyFrame()
            
            self.frame.Show(True)
            return True
    
    app =  MyApp()
    app.MainLoop()
# test_button()
 
#单选框
def test_radiobutton():
    class MyFrame(wx.Frame):
        def __init__(self):
            wx.Frame.__init__(self, None, -1, u'单选框', size=(300, 150))  # 这里自定义 parent 为  None
            panel = wx.Panel(self, -1)
            
            radioRed = wx.RadioButton(panel, -1, u'红', pos=(10, 10))
            radioBlue = wx.RadioButton(panel, -1, u'蓝', pos=(10, 40))
            radioGreen = wx.RadioButton(panel, -1, u'绿', pos=(10, 70))
            
            self.colors = {'红': wx.RED, '蓝': wx.BLUE, '绿': wx.GREEN}
            self.text = wx.TextCtrl(panel, -1, '', pos=(80, 10))
            for i in [radioRed, radioBlue, radioGreen]:
                self.Bind(wx.EVT_RADIOBUTTON, self.OnRadio, i)  #注册 radio 事件
            
        def OnRadio(self, event):
            radioSelected = event.GetEvent()
            str = radioSelected.GetLabel()
            
            self.text.SetBackgroundColour(colour=self.colors[str])  #设置文本的背景色
            self.text.SetFocus()
            
    class MyApp(wx.App):
        def OnInit(self):
            self.frame = MyFrame()
            self.frame.Show(True)
            return True
    
    app =  MyApp()
    app.MainLoop()
# test_radiobutton()