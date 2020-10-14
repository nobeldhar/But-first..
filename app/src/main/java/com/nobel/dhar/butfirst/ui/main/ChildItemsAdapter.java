package com.nobel.dhar.butfirst.ui.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.nobel.dhar.butfirst.BR;
import com.nobel.dhar.butfirst.R;
import com.nobel.dhar.butfirst.databinding.ParentItemRowBinding;
import com.nobel.dhar.butfirst.models.Audio;
import com.nobel.dhar.butfirst.models.Document;
import com.nobel.dhar.butfirst.models.Item;
import com.nobel.dhar.butfirst.models.Video;

import java.util.List;

public class ChildItemsAdapter
        extends RecyclerView.Adapter<ChildItemsAdapter.MyChildViewHolder>
        implements CustomClickListener {

    private List<Item> itemList;
    private CustomClickListener listener;

    public ChildItemsAdapter(List<Item> itemList, CustomClickListener listener) {
        this.itemList = itemList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ParentItemRowBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.parent_item_row, parent, false);

        return new MyChildViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyChildViewHolder holder, int position) {
        Item item = itemList.get(position);
        if (item instanceof Audio) {
            item.setImageResource(R.drawable.ic_audiotrack_black_24dp);
        } else if (item instanceof Video) {
            item.setImageResource(R.drawable.ic_videocam_black_24dp);
        } else if (item instanceof Document) {
            item.setImageResource(R.drawable.ic_content_paste_black_24dp);
        } else {
            item.setImageResource(R.drawable.ic_content_paste_black_24dp);
        }

        holder.bind(item);
        holder.getItemRowBinding().setItemClickListener(this);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public void cardClicked(Item item) {
        listener.cardClicked(item);
    }

    public static class MyChildViewHolder extends RecyclerView.ViewHolder {

        public ParentItemRowBinding itemRowBinding;

        public MyChildViewHolder(ParentItemRowBinding binding) {
            super(binding.getRoot());
            itemRowBinding = binding;
        }

        public void bind(Object obj) {
            itemRowBinding.setVariable(BR.model, obj);
            itemRowBinding.executePendingBindings();
        }

        public ParentItemRowBinding getItemRowBinding() {
            return itemRowBinding;
        }
    }

}
