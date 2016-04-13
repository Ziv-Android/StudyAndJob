package com.ziv.jobinterview.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.ziv.jobinterview.R;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

/**
 * 使用BaseAdapter的ListView
 * Created by Ziv on 2016/3/30.
 */
public class BaseAdapterListView {
    private ListView listView;
    private List<Object> list = new LinkedList<>();
    private GridView gridView;
    public void setListView(ListView listView) {
        this.listView = listView;
        //gridView.setSelector();
        // 设置item点击背景效果
        listView.setSelector(R.mipmap.ic_launcher);
        // 显示列表快速划块
        listView.setFastScrollEnabled(true);
    }

    public void setData() {
        // 对数据直接进行增删改查，然后调用BaseAdapter.notifyDataSetInvalidated更新数据
        BaseAdapter adapter = new BaseAdapter() {
            /**
             * @return 返回列表数据总数
             */
            @Override
            public int getCount() {
                return list.size();
            }

            /**
             * @return 返回Object对象
             */
            @Override
            public Object getItem(int position) {
                if (list == null) {
                    return null;
                }
                return list.get(position);
            }

            /**
             * @return 返回long类型的ItemId
             */
            @Override
            public long getItemId(int position) {
                return position;
            }

            /**
             * @return 加载布局View
             */
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    // TODO: 2016/3/30 通过layoutInflate.inflate加载布局
                }
                return convertView;
            }
        };
        listView.setAdapter(adapter);
        adapter.notifyDataSetInvalidated();//更新监听对象
        adapter.notifyDataSetChanged();//通知adapter数据发生改变
    }

    /**
     * 通过反射技术修改快速滑块的图像
     */
    public void fastScrollBlock(Context context) {
        try {
            // FastScroller.mThumbDrawable变量保存了快速划块图像
            // 首相要通过AbsListView.mFastScroller变量获取FastScroller对象
            Field field = AbsListView.class.getDeclaredField("mFastScroller");
            field.setAccessible(true);
            Object obj = field.get(listView);
            // 获取FastScroller.mThumbDrawable变量的Field对象
            field = field.getType().getDeclaredField("mThumbDrawable");
            field.setAccessible(true);
            // 获取FastScroller.mThumbDrawable变量的值
            Drawable drawable = (Drawable) field.get(obj);
            // 重新装载快速滑块的图像
            // drawable = context.getResources().getDrawable();
            // 重新设置滑块图案
            field.set(obj, drawable);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
