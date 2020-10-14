package com.nobel.dhar.butfirst.models;

import java.util.ArrayList;
import java.util.List;

public class Chapter extends Item {

    public ArrayList<Item> chapter_item = new ArrayList<>();
    private boolean expanded = false;

    public ArrayList<Item> getChapter_item() {
        return chapter_item;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public void setChapter_item(ArrayList<Item> chapter_item) {
        this.chapter_item = chapter_item;
    }

    public Chapter(String itemTitle) {
        super(itemTitle);
    }
}
