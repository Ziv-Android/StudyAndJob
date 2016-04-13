package com.ziv.jobinterview.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Java与JavaScript脚本交互
 * Created by Ziv on 2016/4/1.
 */
public class WebViewJS extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView webView = new WebView(this);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        String string = null;
        // string为String类型变量，保存了JavaScript脚本
        webView.loadDataWithBaseURL(null, string, "text/html", "utf-8", null);

        webView.addJavascriptInterface(new Object(){
            // 可以在JavaScript脚本中调用Java方法
            public void move(int x,int y){
                // Java代码
            }
        },"demo");//demo为在JavaScript中可访问的对象，通过该对象调用move方法
    }
}
