package com.highschool.football.entity;

public class CommonReponse<T> {

    public static final int SUCCESS_CODE = 0;
    public static final String SUCCESS_MSG = "success";

    public static final int NULL_CODE = -1;
    public static final String NULL_MSG = "no data";

    public static final int FAIL_CODE = -2;
    public static final String FAIL_MSG = "fail";

    public static final int LOGIN_FAIL_CODE = -3;
    public static final String LOGIN_FAIL_MSG = "登录超时";

    public static final int DUPLICATE_APPOINT_CODE = -4;
    public static final String DUPLICATE_APPOINT_MSG = "重复加入";

    public static final int ACCOUNT_FILL_CODE = -5;
    public static final String ACCOUNT_FILL_MSG = "人数已满";

    private int code;
    private String msg;
    private T data;

    public CommonReponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

//    public CommonReponse(boolean isSuccess, T... data){
//        if (isSuccess){
//            this.code = SUCCESS_CODE;
//            this.msg = SUCCESS_MSG;
//        }
//        if (data !=null && data.length > 0){
//            this.data = data[0];
//        }
//    }

    public CommonReponse(boolean dataIsPresent, T... data) {
        if (!dataIsPresent) {
            this.code = NULL_CODE;
            this.msg = NULL_MSG;
        } else {
            this.code = SUCCESS_CODE;
            this.msg = SUCCESS_MSG;
            if (data != null && data.length>=1) {
                this.data = data[0];
            }
        }
    }

    public CommonReponse() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
