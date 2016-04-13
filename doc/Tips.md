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