package com.heqing.hq_customview.customer_view;

import android.graphics.Bitmap;

/**
 * Created by 何清 on 2016/6/5 0005.
 *
 * @description
 */
public class ChatItemListViewBean {

    private int type;
    private String text;
    private Bitmap icon;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }
}
