package com.penup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.penup.R;
import com.penup.databinding.AllListItemViewBinding;
import com.penup.databinding.ChatListItemViewBinding;

import java.util.ArrayList;

//public class AllListAdapter extends RecyclerView.Adapter<AllListAdapter.ViewHolder> {
//
//    private String[] mData;
//    private Context context;
//    private LayoutInflater layoutInflater;
//    AllListItemViewBinding binding;
//
//
//    public AllListAdapter(String[] mData, Context context) {
//        this.mData = mData;
//        this.context = context;
//    }
//
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
//                R.layout.all_list_item_view, parent, false);
//        return new ViewHolder(binding);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.binding.tvUserName10.setText(mData[position]);
//
////        holder.binding.ivBank.setImageResource(mData[position]);
////        Picasso.with(context)
////                .load(mData[position]).
////                into(holder.binding.ivBank);
//    }
//
//    @Override
//    public int getItemCount() {
//        return mData.length;
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        private AllListItemViewBinding binding;
//
//        public ViewHolder(AllListItemViewBinding itemBinding) {
//            super(itemBinding.getRoot());
//            this.binding = itemBinding;
//        }
//    }
//
//
//}
public class AllListAdapter extends RecyclerView.Adapter<AllListAdapter.MyViewHolder> {

    private ArrayList<String> data;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitle;
        CardView relativeLayout;

        public MyViewHolder(View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.tvUserName10);
        }
    }

    public AllListAdapter(ArrayList<String> data) {
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_list_item_view, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTitle.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void removeItem(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }
    public void restoreItem(String item, int position) {
        data.add(position, item);
        notifyItemInserted(position);
    }
    public ArrayList<String> getData() {
        return data;
    }
}