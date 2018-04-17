package com.highschool.football.api;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParser;
import com.highschool.football.utils.OKHttpUtil;

public class API {
    public static String APPID = "wx397544318206f249";
    public static String APPSECRET = "c4808cbac9873a0242496475b88bf40e";
    public static String OPEN_ID_URL = "https://api.weixin.qq.com/sns/jscode2session";

    public static String getOpenId(String code) {
        String url = OPEN_ID_URL+"?appid="+APPID+"&secret="+APPSECRET+"&js_code="+code+"&grant_type=authorization_code";
        String result = OKHttpUtil.httpGet(url);
        JSONObject jsonObject = JSONObject.parseObject(result);
        String openid = jsonObject.getString("openid");
        String session_key = jsonObject.getString("session_key");
        return openid;
    }
}
