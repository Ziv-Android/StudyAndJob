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

###Service与Thread
Service是系统的四大组件之一，Thread只是一个用来执行后台任务的工具类
Service可以设置独立的进程；Thread不可以，只能存在于进程中。
Service有自己的生命周期。如果是以bind的方式启动，生命周期跟activity相同。如果是以start方式启动，不调用stop会一直运行在后台；Thread运行完了就结束了，启动后跟activity没有关系了，哪怕activity结束了，thread也会在后台运行。
不同的Activity可以调用同一个Service；不同的Activity不能调用同一个Thread。
Service如果是运行在后台的，可以注册接收系统或自定义广播；Thread不能接收广播
不同的应用程序可以共享同一Service，但不能共享同一Thread。
service中可以创建thread，避免ANR。
Thread在后台运行（Activty stop）的优先级低于后台运行的Service，如果执行系统资源紧张，会优先杀死前一种，后台运行的Service一般情况下不会被杀死，如果被杀死，系统空闲时会重新启动service.

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

###SDK支持的文件数据存储技术都有哪些
SharedPreferences                                                    保存Key-Value类型数据      /data/data/<package name>/shared_prefs
openFileOutput/openFileInput或FileInputStream/FileOutputStream       流文件                     /data/data/<package name>/files
Xml                                                                  半结构化存储
Json                                                                 保存数组或对象
数据库                                                               保存结构化数据
第三方面向对象数据库                                                 保存Java对象

###如何确定Java反射需要修改的变量名
首先需要Android SDK源代码，然后通过变量名获取实现的类名的方法
Field field = ContextWrapper.class.getDeclaredField("mBase");
field.setAccessible(true);
// 输出mBase变量的类名
Log.d("ziv","className = " + obj.getClass().getName());

###SQLite基础知识
SQLite官网命令行工具 下载地址 http://www.SQLite.org/download.html
Windows平台下SQLite管理工具 SQLite ExpertProfessional 下载地址 http://www.SQLiteexpert.com

SQLite命令必须以分号(;)结尾，控制台命令必须以实心点(.)开头

增
    insert
删
    delete
改
table1表中如果id=1的记录不存在，则正常插入，若存在则更新name值 
    replace into table1(id, name) value(1,'bill');
查
查询table1表中第20条到第30条记录 
    select * form table1 limit 19,11
复制表最简单方法 
    create table table2 as select * from table1
创建视图(查询表中所有记录)的SQL语句 
    create view if not exists view1 as select * from table1

###SQLite函数
##核心函数
abs(X)——取绝对值
    X：正值和0，返回X本身
    X：负值，返回X的绝对值
    X：NULL，返回NULL
    X：字符串、Blob等不能转为数值的类型，返回0
    超出64为整数范围抛出溢出错误
changes——获取最近依次执行SQL语句所影响的记录条数
    insert into table1 values(1,'bill');
    --返回insert语句影响的记录行数
    select changes();
coalesce——返回一个第1个不为null的字段值
    select coalesce(name,id) as value from table1
ifnull——与coalesce效果类似
    select ifnull(name,id) as value from table1
length(X)
    X：字符串，返回字符串包含的字符数
    X：Blob，返回二进制数据包含的字节数
    X：NULL，返回NULL
    X：数值，会将X转换为字符转处理，返回包含字符数
like子句与like函数
    like(X,Y)函数 与 Y like X 子句 功能完全相同
    select * from table1 where like ('%ziv%',name);
    select * from table1 where name like '%ziv%'
    有3个参数的like语句
    select like ('a%%','%abcd','a')
nullif(X,Y)
    --输出20
    select nullif(20,30);
    --输出NULL
    select nullif(20,20);
substr函数——截取字符串的子字符串
    substr(X,Y);
    substr(X,Y,Z);
typeof函数——获取当前字段的数据类型
    select typeof(field1) from table1
##日期和时间函数
SQLite支持5个日期时间函数：date、time、datetime、julianday、strftime
date函数
    --将2012-11-01，年-1，月+1
    select data ('2012-11-01','-1 years','+1 months')
调节器
    调整时间
        NNN days
        NNN hours
        NNN minutes
        NNN.NNNN seconds
        NNN months
        NNN years
    获取时间
        start of month
        start of year
        start of day
        weekday N
    时间转换
        unixepoch + 时间字符串
        utc格式时间字符串 localtime
        本地时间 utc 
        select datetime('2011-01-01 01:01:01','utc');
        GMT——格林威治标准时间
        UTC——世界协调时
输出当前日期和时间
    select date ('now');
    select time ('now')
    select data('now','start of month','+1 month','-1 day');
格式化日期格式
    strftime(format,timestring,modifier,modifier,...);
    --%s中的s为小写字母，输出当前时间至1970-01-01的秒数
    select strftime('%s','now');
格式置挽符
    %d：两位的日，不足前补0
    %f：形如SS.SSS的秒，后面3个SSS表示毫秒
    %H：24禁止的小时
    %j：一年中的第几天
    %J：朱利安(Julian)日
    %m：两位的月，不足前补0
    %M：两位的分，不足前补0
    %s：从1970-01-01到现在的秒数
    %S：两位的秒，不足前补0
    %w：周，0表示周日
    %W：一年中的第几周
    %Y：年(0000-9999)
    %%：百分号

##聚合函数
avg(X)——计算平均值
    X：NULL，X不参与计算平均值
    X：String或Blob，如果X可以转换成数组，正常计算平均值，如不能，则将不能转换的项当作0处理
    X：所有参与统计的字段值都为NULL，返回NULL
    select avg(name) from table1
group_concat——连接某一列值
    --使用分号(;)分隔符链接name字段的值，输出结果
    select group_concat (name,';') from table1

###网络





###Android进程种类
前台进程(foreground)
可见进程(visible)
桌面进程(home app)
次要任务(secondary server)
后台进程(hidden)
内容提供节点(content provider)
空进程(empty)




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