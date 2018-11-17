package com.huawei.cse.houseapp.common;

/**
 * Created by Administrator on 2018/11/17.
 */
public class ApiResponse {
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private int code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    private String reason;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private String data;
}
