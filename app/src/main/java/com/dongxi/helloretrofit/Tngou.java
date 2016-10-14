package com.dongxi.helloretrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/10/14.
 */

public class Tngou {
    //加上注解
    @SerializedName("status")
    private boolean status;
    @SerializedName("total")
    private int total;
    @SerializedName("tngou")
    private List<AndroidResult> list;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<AndroidResult> getList() {
        return list;
    }

    public void setList(List<AndroidResult> list) {
        this.list = list;
    }
}
