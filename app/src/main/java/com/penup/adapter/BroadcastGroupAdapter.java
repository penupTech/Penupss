package com.penup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.penup.R;
import com.penup.databinding.BroadcastItemsListViewBinding;
import com.penup.databinding.ContactItemsListViewBinding;
import com.penup.modle.ContactsInfo;

import java.util.List;

public class BroadcastGroupAdapter extends RecyclerView.Adapter<BroadcastGroupAdapter.ViewHolder>  {

    List<ContactsInfo> data;
    String[]data1;
    private Context context;
    private LayoutInflater layoutInflater;
    private String[] mData;

    public BroadcastGroupAdapter(List<ContactsInfo> data, Context context) {
        this.data = data;
        this.context = context;
    }
    public BroadcastGroupAdapter(String[]data1) {
        this.data1 = data1;

    }
    public BroadcastGroupAdapter(String[] mData, Context context) {
        this.mData = mData;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BroadcastItemsListViewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.broadcast_items_list_view, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder, int position) {

        holder.binding.displayName.setText(mData[position]);
        holder.binding.tvUserMsg.setVisibility(View.VISIBLE);
        holder.binding.ivClear.setVisibility(View.GONE);
        holder.binding.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.binding.ivSelected.setVisibility(View.VISIBLE);

               // Toast.makeText(context,"Wellcome"+reportData.getDisplayName(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

//    @Override
//    public String getSectionTitle(int position) {
//        return getItem(position).substring(0, 1);
//    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private BroadcastItemsListViewBinding binding;

        public ViewHolder(BroadcastItemsListViewBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }
}
