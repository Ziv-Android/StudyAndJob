###Parcelable和Serializable的爱恨情仇(10倍差距)

Serizlizaable的作用是为了保存对象的属性到本地文件、数据库、网络流、RMI以方便数据传输，可适用于两个程序之间
Parcelable仅在内存中，程序内部不同组件之间，不同应用之间通过IBinder高效传输数据

##在数据传输方面
Parcelable开销内存更少，读写时是4字节对齐的，性能更好。如果预分配的空间不够时newSize = ((mDataSize+len)*3)/2;会一次多分配50%
Serializable更适合数据持久化保存或通过网络进行的数据传输

##使用上
Serializable只需要实现Serializable接口，并提供一个序列化版本id(serialVersionUID)
Parcelable需要实现writeToParcel、describeContents函数以及静态的CREATOR变量，就是自己定义如何打包盒解包的工作，而序列化的这些操作完全由底层实现

Serializable序列化不保存静态变量，可以使用Transient关键字对部分字段不进行序列化，也可以覆盖writeObject、readObject方法以实现序列化过程自定义
Serializable使用了反射，序列化的过程较慢。在序列化的时候会产生大量的临时变量，从而引起频繁的GC

Parcelable对于普通数据，使用的是mData内存地址，对于IBinder类型的数据以及FileDescriptor使用的是mObjects内存地址。后者是通过flatten_binder()和unflatten_binder()实现的，目的是反序列化时读出的对象就是原对象而不用重新new一个新对象
native方法说明都是使用JNI，具体位置在system/frameworks/base/core/jni/android_util_Binder.cpp 


##参考：
https://greenrobot.me/devpost/android-parcelable-serializable/

http://www.2cto.com/kf/201403/288476.html

