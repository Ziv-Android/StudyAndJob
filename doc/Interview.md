1 简述fragment生命周期
onAttach-->onCreate-->onCreateView-->onActivityCreated-->onStart-->onResume-->onPause-->onStop-->onDestroyView-->onDestroy-->onDetach
参考链接：http://blog.csdn.net/forever_crying/article/details/8238863/

2 Android中px、sp、dip、dp的区别与联系，将60px转换为相应屏幕的dp
px:(pixels 像素)不同设备显示效果相同，一般使用HVGA代表320*480像素
sp:(scaled pixels 放大像素)主要用于字体显示best for textsize
dip(device independent pixels 设备独立像素)与dp一样，与设备硬件有关
px = dip*density/160;
0.75x   1x      1.33x   1.5x    2x      3x      4x
ldpi    mdpi    tvdpi   hdpi    xhdpi   xxhdpi  xxxhdpi
45      60      80      90      120     180     240
参考链接：http://blog.csdn.net/vrix/article/details/7623864

3 Content Provider与AIDL的区别和联系
区别：ContentProvider传递数据，以Cursor对象形式返回
AIDL提供服务，返回Java对象，可执行操作

联系：外加一个Broadcast都可实现跨进程通信

简述静默安装的原理，如何在无需root权限的情况下实现静默安装


简单描述你是如何进行JNI开发的

列举Android中最常用的设计模式，并手动简单实现观察者模式

Android中有哪些类型的动画，用属性动画实现空间的缩放

简述控制反转(Inversion of Control)的应用场景

对比分析Web App、Hybrid App与Native App，列举你所用过的Hybrid App框架

如何在不引用第三方工具的情况下防止应用二次打包？并对应用进行简单加固

假如com.google.gson包中的类不允许混淆，并且项目中所有的Bean不允许混淆，但是由于项目是由多人开发，并不确定Bean所在的包，只知道Bean实现了序列化，请手动配置项目的混淆规则

如何实现资源文件的混淆

什么是65535问题，如何防止或解决65535问题

简述实现Android APK插件化的简单方法

列举常用的Android开源项目及应用场景

手动编写gradle脚本，将libs\arm64-v8a目录下的so库及libs\gson-2.5.jar配置到项目依赖中