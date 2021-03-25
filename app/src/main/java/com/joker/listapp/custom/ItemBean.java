package com.joker.listapp.custom;

public class ItemBean {

    private String text ;
    private int imgTrue;
    private int imgFalse;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImgTrue() {
        return imgTrue;
    }

    public void setImgTrue(int imgTrue) {
        this.imgTrue = imgTrue;
    }

    public int getImgFalse() {
        return imgFalse;
    }

    public void setImgFalse(int imgFalse) {
        this.imgFalse = imgFalse;
    }
}