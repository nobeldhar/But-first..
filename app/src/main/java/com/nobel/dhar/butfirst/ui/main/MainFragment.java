package com.nobel.dhar.butfirst.ui.main;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nobel.dhar.butfirst.R;
import com.nobel.dhar.butfirst.databinding.MainFragmentBinding;
import com.nobel.dhar.butfirst.models.Audio;
import com.nobel.dhar.butfirst.models.Document;
import com.nobel.dhar.butfirst.models.Item;
import com.nobel.dhar.butfirst.models.Video;

import java.util.ArrayList;

public class MainFragment extends Fragment implements CustomClickListener {

    private MainViewModel mViewModel;
    private MainFragmentBinding binding;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.main_fragment, container,false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        mViewModel.getListMutableLiveData().observe(getViewLifecycleOwner(), new Observer<ArrayList<Item>>() {
            @Override
            public void onChanged(ArrayList<Item> items) {
                MainItemsAdapter itemsAdapter = new MainItemsAdapter(items, MainFragment.this);
                binding.setMyAdapter(itemsAdapter);
            }
        });

    }

    @Override
    public void cardClicked(Item item) {
        if (item instanceof Audio){
            Toast.makeText(getContext(), "Audio : "+item.getItemTitle(), Toast.LENGTH_SHORT).show();
        } else if(item instanceof Video){
            Toast.makeText(getContext(), "Video : "+item.getItemTitle(), Toast.LENGTH_SHORT).show();
        } else if (item instanceof Document){
            Toast.makeText(getContext(), "Document : "+item.getItemTitle(), Toast.LENGTH_SHORT).show();
        }
    }
}
