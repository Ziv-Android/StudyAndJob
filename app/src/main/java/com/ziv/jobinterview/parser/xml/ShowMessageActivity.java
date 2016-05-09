package com.ziv.jobinterview.parser.xml;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Xml;

import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 调用XML解析
 * Created by Ziv on 2016/4/27.
 */
public class ShowMessageActivity extends AppCompatActivity {
    public static final String SDCARD_PATH = Environment.getExternalStorageDirectory().getPath();
    public static final String FILE_NAME = "/products.xml";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            FileInputStream fis = new FileInputStream(SDCARD_PATH+FILE_NAME);
            XmlParser xmlParser = new XmlParser();
            Xml.parse(fis, Xml.Encoding.UTF_8,xmlParser);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
