package com.nobel.dhar.butfirst.repositories;

import androidx.lifecycle.MutableLiveData;

import com.nobel.dhar.butfirst.models.Audio;
import com.nobel.dhar.butfirst.models.Chapter;
import com.nobel.dhar.butfirst.models.Document;
import com.nobel.dhar.butfirst.models.Item;
import com.nobel.dhar.butfirst.models.Video;

import java.util.ArrayList;
import java.util.List;

public class MainRepository {

    private MutableLiveData<ArrayList<Item>> listMutableLiveData = new MutableLiveData<>();

    public void loadData(){
        Chapter chapter1 = new Chapter("Chapter 1");
        Video video1_1 = new Video("Video 1_1");
        Video video1_2 = new Video("Video 1_2");
        Document document1_1 = new Document("Document 1_1", "Rabindranath Tagore");
        ArrayList<Item> chapter1_item = new ArrayList<>();
        chapter1_item.add(video1_1);
        chapter1_item.add(document1_1);
        chapter1_item.add(video1_2);
        chapter1.setChapter_item(chapter1_item);


        Chapter chapter2 = new Chapter("Chapter 2");
        Video video2_1 = new Video("Video 2_1");
        Video video2_2 = new Video("Video 2_2");
        Document document2_1 = new Document("Document 2_1", "Rabindranath Tagore");
        Audio audio2_1 = new Audio("Audio 2_1");
        ArrayList<Item> chapter2_item = new ArrayList<>();
        chapter2_item.add(document2_1);
        chapter2_item.add(video2_1);
        chapter2_item.add(video2_2);
        chapter2_item.add(audio2_1);
        chapter2.setChapter_item(chapter2_item);

        Video video3_1 = new Video("Video 3_1");
        Document document4_1 = new Document("Document 4_1", "Kazi Nazrul Islam");

        List<Item> itemList = new ArrayList<>();
        itemList.add(chapter1);
        itemList.add(chapter2);
        itemList.add(video3_1);
        itemList.add(document4_1);
        listMutableLiveData.setValue((ArrayList<Item>) itemList);
    }

    public MutableLiveData<ArrayList<Item>> getListMutableLiveData() {
        return listMutableLiveData;
    }
}
