package com.example.godzou;

/**
 * Created by renyangqi on 2018/2/17.
 */

import com.google.gson.Gson;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpUtil {
    public static void sendOkHttpRequest(final String json,final String address,okhttp3.Callback callback){
        MediaType JSON=MediaType.parse("application/json; charset=utf-8");//设置json类型

        //在app/build.gradle里面添加依赖
        // compile'com.squareup.okhttp3:okhttp:3.4.1'
        // compile 'com.google.code.gson:gson:2.8.1'
        OkHttpClient client=new OkHttpClient();//创建一个okhttp对象
        String json_KaiGuan=json;
        RequestBody requestBody= FormBody.create(JSON,json_KaiGuan);
        Request request=new Request.Builder()
                .url(address)//地址
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(callback);//异步执行


    }
}
