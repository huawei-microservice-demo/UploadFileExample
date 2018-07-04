package com.huawei.cse.houseapp.common;

import java.util.Date;

/**
 * Created by j00347529 on 2018/6/28.
 */
public class HelloTime {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private String name;

    private int number;

    private Date date;
}
