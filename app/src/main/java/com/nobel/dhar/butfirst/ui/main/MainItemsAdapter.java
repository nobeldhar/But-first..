package com.nobel.dhar.butfirst.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.nobel.dhar.butfirst.BR;
import com.nobel.dhar.butfirst.R;
import com.nobel.dhar.butfirst.databinding.ParentItemRowBinding;
import com.nobel.dhar.butfirst.models.Audio;
import com.nobel.dhar.butfirst.models.Chapter;
import com.nobel.dhar.butfirst.models.Document;
import com.nobel.dhar.butfirst.models.Item;
import com.nobel.dhar.butfirst.models.Video;

import java.util.List;

public class MainItemsAdapter
        extends RecyclerView.Adapter<MainItemsAdapter.MyViewHolder>
        {

    private List<Item> itemList;
    private CustomClickListener listener;

    public MainItemsAdapter(List<Item> itemList, CustomClickListener listener) {
        this.itemList = itemList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ParentItemRowBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.parent_item_row, parent, false);
        
        return new MyViewHolder(binding, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = itemList.get(position);
        if (item instanceof Audio){
            item.setImageResource(R.drawable.ic_audiotrack_black_24dp);
        } else if(item instanceof Video){
            item.setImageResource(R.drawable.ic_videocam_black_24dp);
        } else if (item instanceof Document){
            item.setImageResource(R.drawable.ic_content_paste_black_24dp);
        } else {
            Chapter chapter = (Chapter)item;
            if (chapter.getChapter_item() != null){
                ChildItemsAdapter childItemsAdapter = new ChildItemsAdapter(chapter.getChapter_item(),listener);
                holder.getItemRowBinding().setChildItemAdapter(childItemsAdapter);
            }
            item.setImageResource(R.drawable.ic_content_paste_black_24dp);
        }

        holder.bind(item);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class MyViewHolder
            extends RecyclerView.ViewHolder
            implements CustomClickListener {

        public ParentItemRowBinding itemRowBinding;
        private CustomClickListener listener;

        public MyViewHolder(ParentItemRowBinding binding, CustomClickListener listener) {
            super(binding.getRoot());
            itemRowBinding = binding;
            itemRowBinding.setItemClickListener(this);
            this.listener = listener;
        }

        public void bind(Object obj) {
            itemRowBinding.setVariable(BR.model, obj);
            itemRowBinding.executePendingBindings();
        }

        public ParentItemRowBinding getItemRowBinding() {
            return itemRowBinding;
        }

        @Override
        public void cardClicked(Item item) {

            if (item instanceof Chapter){
                Chapter chapter = (Chapter)item;
                if(chapter.isExpanded()){
                    itemRowBinding.childRecyclerView.setVisibility(View.GONE);
                    chapter.setExpanded(false);
                    bind(chapter);
                }else{
                    itemRowBinding.childRecyclerView.setVisibility(View.VISIBLE);
                    chapter.setExpanded(true);
                    bind(chapter);
                }

            } else
                listener.cardClicked(item);
        }

    }

}
