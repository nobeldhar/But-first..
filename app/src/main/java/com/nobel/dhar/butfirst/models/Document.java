package com.nobel.dhar.butfirst.models;

public class Document extends Item {
    public String subTitle;

    public Document(String itemTitle, String subTitle) {
        super(itemTitle);
        super.setItemSubTitle(subTitle);
        this.subTitle = subTitle;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
