package com.highschool.football.utils;

import okhttp3.*;

import java.io.IOException;

public class OKHttpUtil {
    /**
     * 发起get请求
     *
     * @param url
     * @return
     */
    public static String httpGet(String url) {
        String result = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            result = response.body().string();
            System.out.println("------httpGet-------");
            System.out.print(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 发送httppost请求
     *
     * @param url
     * @return
     */
    public static String httpPost(String url, RequestBody formBody) {
        String result = null;
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .post(formBody)
                .build();
        try {
            Response response = httpClient.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
