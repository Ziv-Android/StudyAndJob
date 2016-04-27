package com.ziv.jobinterview.parser.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * JSON是一种轻量级的数据存储和传输方式，原生解析如下，但不推荐，
 * 据说Jackson比较好用，没有比较过与fastjson的差距
 * Created by Ziv on 2016/4/27.
 */
public class JsonParser {
    public static void parser(String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray test = jsonObject.getJSONArray("test");
        for (int i = 0; i < test.length(); i++) {
            String s = String.valueOf(test.get(i));
            JSONObject object = new JSONObject(s);
            object.get("");
            if (object.has("")){
                object.get("");
            }
        }
    }
}
