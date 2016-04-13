package com.ziv.jobinterview.ui;

import android.view.View;

/**
 * 返回控件View所在位置
 * Created by Ziv on 2016/3/18.
 */
public class ViewLocation {
    public int[] location;
    public int[] getLocation(View view){
        location = new int[2];
        view.getLocationOnScreen(location);
        return location;
    }
}
