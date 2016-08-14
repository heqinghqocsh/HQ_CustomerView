package com.heqing.hq_customview.model;

import java.io.Serializable;

/**
 * Created by 何清 on 2016/6/18 0018.
 *
 * @description
 */
public class People implements Serializable{

    private String name;
    private String address;
    private int age;

    public People(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
