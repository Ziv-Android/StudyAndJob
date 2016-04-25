###目前Android支持的尺寸单位，px(像素) in(英寸) mm(毫米) pt(一个物理点，1/72英寸) dp sp
XML布局文件根节点<FrameLayout>可以使用<merge>占位减少标签嵌套

###反编译XML布局文件，使用AXMLPrinter2工具
java -jar D:\lib\AXMLPrinter2.jar %1 > %2
axml.cmd main.xml output.xml

###富文本信息
TextView富文本标签，<font>字体和颜色， <b>粗体， <img>图像
    注意：先Html.fromHtml转换为CharSequence对象，然后TextView.setText
    使用<img>标签显示图像需要实现ImageGetter接口
使用WebView组件显示HTML页面
继承View类或其子类，覆盖onDraw方法
使用ImageSpan封装Bitmap对象，通过SpannableString封装ImageSpan对象，然后TextView.setText

###列表组件中的增删改查
列表组件采用的是MVC模式，
adapter.notifyDataSetInvalidated

###GridView显示文件缩略图
##使用任务队列技术
1 将getView方法显示某个图像的任务添加到数组或List对象建立任务队列和数据缓冲中
2 使用另外一个线程扫描任务队列，并处理未完成的任务
3 处理完任务后，调用adapter.notifyDataSetChanged刷新GridView显示

###容器组件
无限轮播实现技巧：Adapter.getCount返回Integer.MAX_VALUE; Adapter.getView的int newPosition = position % n;
##自定义组件
#静态引用——与主程序一起封装在编译后的目标文件中
VC中的lib文件、Delphi中的VCL组件
另一个Eclipse Java工程
注：Android中的NDK Library(.so文件)为静态引用
#动态引用——与主程序分离，组件可单独升级和卸载
Windows中的dll、Linux中的.so文件
Android未安装的apk文件；包含classes.dex文件的jar文件、JavaScript脚本、Activity、Service、BroadcastReceiver和ContentProvider

###自定义可视组件
1 扩展现有的组件
2 组合多种组件
3 直接从View继承
定义attrs.xml配置declare-styleable
xmlns:你自己定义的名称="http://schemas.android.com/apk/res/你程序的package包名"
使用完切记调用recycle();//回收资源

###NDK方法的命名规则
Java开头，后面更调用NDK方法的Java类全名(package + class)，最后才是实际的方法名
前两个参数类型必须是当前NDK环境的对象指针JNIEnv* 和调用当前NDK方法的Java对象jobject

###Activity之间的传值方式
1 Intent对象
2 静态变量
3 剪切板
4 全局对象

###拦截手机屏幕休眠与唤醒的广播注意点
只能在代码中动态注册，不能在AndroidManifest.xml中注册
休眠状态：Intent.ACTION_SCREEN_ON
唤醒状态：Intent.ACTION_SCREEN_OFF

###Service生命周期
onCreate和onStart平级，onCreate方法调用不可控，stopServer方法调用onDestroy，再启动Service不一定调用onCreate

###AIDL服务（进程间通信）
##AIDL支持的数据类型：
1 Java的简单类型(int、char、boolean等)。不需要导入(import)
2 String和CharSequence。不需要导入(import)
3 List和Map。但要注意，List和Map对象的元素类型必须是AIDL服务支持的数据类型。不需要导入(import)
4 AIDL自动生成的接口。需要导入(import)
5 实现android.os.Parcelable接口的类。需要导入(import)

###ContentProvider URI的组成
content://authority/path/param

###自定义ContentProvider
1 编写一个类，继承自ContentProvider，并实现ContentProvider类中的所有抽象方法
2 定义ContentProvider的URI。URI的形式为content://authority/path/param
3 在static块中使用UriMatcher对象映射Uri和返回码
4 根据实际的需要，使用UriMatcher.match方法将URI映射成与URI对应的代码，实现具体相应的方法
5 在AndroidManifest.xml文件中使用<provider>标签注册ContentProvider，可自定义读取与访问权限

###Windows控制台中查看Android系统中列出的所有权限——必须连接Android设备
adb <-d><-s emulator-5554> shell pm list permissions
注：<> 中参数可略
    <-d> 列出USB Android设备中的权限列表
    <-s emulator-5554> 列出指定Android设备中的权限列表

###Toast相关
Android系统内部使用队列管理多个Toast，show方法将toast加入队列。
(需反射)Toast.TN.show和Toast.TN.hide直接显示与关闭Toast信息框

###自定义Notification
支持布局FrameLayout、LinearLayout、RelativeLayout
组件AnalogClock、Button、Chronometer(天文台计时)、ImageButton、ImageView、ProgressBar、TextView

###菜单Menu
与菜单Item关联Activity，但若菜单项的点击事件返回true，则关联失效






###内存泄漏
##常见原因
1 查询数据库后没有关闭游标cursor
2 构造Adapter时，没有使用convertView重用
3 Bitmap对象不在使用时调用recycle()释放内存
4 对象被生命周期长的对象引用，如activity被静态集合引用导致activity不能释放
##发现方法
通过DDMS中的heap工具
使用LeakCanary
##如何解决
通过内存分析工具MAT(Memory Analyzer Tool)找到内存泄漏对象

#WebView内存泄漏解决方法
建议启动一个进程专门运行WebView，WebView用完之后就立刻把进程杀死，即使泄露也无碍