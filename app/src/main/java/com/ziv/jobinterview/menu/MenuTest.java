package com.ziv.jobinterview.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

import com.ziv.jobinterview.MainActivity;
import com.ziv.jobinterview.R;

/**
 * 选项菜单(可显示图像)、上下文菜单、子菜单
 * Created by Ziv on 2016/4/25.
 */
public class MenuTest extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 绑定上下文菜单
        Button button = new Button(this);
        // 长按弹出菜单
        registerForContextMenu(button);
    }

    /**
     * 创建选项菜单
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item = menu.add(1, 1, 1, "OptionsMenu 1组1号");
        // 将Activity与菜单项Item关联
        item.setIntent(new Intent(this, MainActivity.class));
        menu.add(1, 2, 2, "OptionsMenu 1组2号");
        menu.add(2, 1, 3, "OptionsMenu 2组1号");

        // 添加子菜单
        SubMenu fileSubMenu = menu.addSubMenu(3, 1, 1, "文件");
        // 设置在选项菜单中显示的图像
        fileSubMenu.setIcon(R.mipmap.ic_launcher);
        // 设置子菜单头的图像
        fileSubMenu.setHeaderIcon(R.mipmap.ic_launcher);
        MenuItem newMenuItem = fileSubMenu.add(3, 2, 2, "新建");
        // 将第1个子菜单想设置成复选框类型
        newMenuItem.setCheckable(true);
        // 选中复选框
        newMenuItem.setChecked(true);
        MenuItem openMenuItem = fileSubMenu.add(4, 3, 3, "打开");
        MenuItem exitMenuItem = fileSubMenu.add(4, 4, 4, "退出");
        exitMenuItem.setChecked(true);
        // 将groupId = 4 的设置成选项按钮类型
        fileSubMenu.setGroupCheckable(4, true, true);

        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 创建上下文菜单
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(1, 1, 1, "ContextMenu 1组1号");
        menu.add(1, 2, 2, "ContextMenu 1组2号");
        menu.add(2, 1, 3, "ContextMenu 2组1号");
    }

    /**
     * 如果super.onMenuItemSelected(featureId, item)放在Log.d()后面调用
     * 系统执行完onMenuItemSelected方法中的代码后再调用OnOptionsItemSelected方法
     */
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        // super.onMenuItemSelected(featureId, item)方法中调用了onOptionItemSelected方法
        super.onMenuItemSelected(featureId, item);
        Log.d("ziv", "onMenuItemSelected:itemId = " + item.getItemId());
        return true;
    }



    /**
     * 使用PopupWindow对象来模拟选项菜单，创建、显示、关闭
     * PopupWindow对象需要一个View对象(一般从布局文件中装载)
     */
    public int state;
    public PopupWindow pop;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_MENU:
                // 选项菜单已弹出，不再弹出新的窗口
                if (state == 1){
                    return false;
                }
                View layout = getLayoutInflater().inflate(R.layout.activity_dialog, null);
                pop = new PopupWindow(
                        layout,//装载菜单布局
                        getWindowManager().getDefaultDisplay().getWidth(),// 设置菜单宽度
                        getWindowManager().getDefaultDisplay().getHeight());//设置布局高度
                // 设置窗口弹出位置
                pop.showAtLocation(layout, Gravity.BOTTOM,0,0);
                // 弹出选项菜单后，另状态变量 state = 1 ，表示菜单已弹出
                state = 1;
                break;
            case KeyEvent.KEYCODE_BACK:
                if (state == 1){
                    // 如果选项菜单已弹出，则关闭选项菜单
                    pop.dismiss();
                    // 将状态变量设置为选项菜单已关闭
                    state = 2;
                }else if (state == 2){
                    // 如果选项菜单还没有显示，或者已经关闭，则直接关闭当前Activity
                    finish();
                }
                break;
        }
        return false;
    }
}
