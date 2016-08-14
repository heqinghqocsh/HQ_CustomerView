package com.heqing.hq_customview.model;

import java.io.Serializable;

/**
 * Created by 何清 on 2016/6/18 0018.
 *
 * @description
 */
public class Group implements Serializable{

    private String title;

    public Group() {
    }

    public Group(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
