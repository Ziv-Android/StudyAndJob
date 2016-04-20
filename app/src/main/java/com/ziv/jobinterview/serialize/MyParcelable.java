package com.ziv.jobinterview.serialize;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义Parcelable具体实现
 * Created by Ziv on 2016/4/20.
 */
public class MyParcelable implements Parcelable {

    private int mData;
    private String mStr;
    // 如果元素是list读取时需要先new一个ArrayList传入，否则空指针
    private List<String> list = new ArrayList<>();

    /**
     * 读取数据时进行数据恢复
     * read数据时如果误将前面的int数据当作long读出，会引起后面的顺序错乱，
     * 异常信息 Caused by: java.lang.RuntimeException: Parcel
     * android.os.Parcel@4126ed60: Unmarshalling unknown type code 3014773 at offset 164
     * @param in Parcel流
     */
    protected MyParcelable(Parcel in) {
        mData = in.readInt();
        mStr = in.readString();
        in.readStringList(list);
    }

    /**
     * 用来创建自定义的Parcelable的对象
     */
    public static final Creator<MyParcelable> CREATOR = new Creator<MyParcelable>() {
        @Override
        public MyParcelable createFromParcel(Parcel in) {
            return new MyParcelable(in);
        }

        @Override
        public MyParcelable[] newArray(int size) {
            return new MyParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * 写数据进行保存
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mData);
        dest.writeString(mStr);
        dest.writeStringList(list);
    }


}
