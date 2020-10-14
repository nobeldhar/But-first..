package com.nobel.dhar.butfirst.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nobel.dhar.butfirst.models.Item;
import com.nobel.dhar.butfirst.repositories.MainRepository;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    private MainRepository mainRepository = new MainRepository();

    public MainViewModel() {
        mainRepository.loadData();
    }

    public MutableLiveData<ArrayList<Item>> getListMutableLiveData() {
        return mainRepository.getListMutableLiveData();
    }

    public void loadData(){

    }
}
