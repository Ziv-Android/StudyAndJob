package com.ziv.jobinterview.ui;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;

/**
 * 获取控件的宽度和高度
 * Created by Ziv on 2016/3/18.
 */
public class MeasureTool {
    public int[] size;

    /**
     * 如果组件的宽度或者高度设为fill_parent或match_parent，
     * 当组件中包含其他子组件时，所获得的实际值是这些组件所占的最小宽度和最小高度
     */
    public int[] widgetSize(Activity activity, int layoutID, int widgetID) {
        if (size != null) {
            size = new int[2];
        }
        View view = activity.getLayoutInflater().inflate(layoutID, null);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(widgetID);
        // measure方法的参数值都设为0即可
        linearLayout.measure(0, 0);
        // 获取组件的宽度 width
        size[0] = linearLayout.getMeasuredWidth();
        // 获取组件的高度 height
        size[1] = linearLayout.getMeasuredHeight();
        return size;
    }
}
