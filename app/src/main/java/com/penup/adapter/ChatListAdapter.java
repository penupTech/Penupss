package com.penup.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.penup.R;
import com.penup.activity.ChatIndividualActivity;
import com.penup.activity.NewBroadcastActivity;
import com.penup.databinding.ChatListItemViewBinding;

import java.util.ArrayList;

//public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ViewHolder> {
//
//    //private String[] mData;
//    private ArrayList<String> mData;
//    private Context context;
//    private LayoutInflater layoutInflater;
//    ChatListItemViewBinding binding;
//
//
//    public ChatListAdapter(ArrayList<String> mData, Context context) {
//        this.mData = mData;
//        this.context = context;
//    }
//
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
//                R.layout.chat_list_item_view, parent, false);
//        return new ViewHolder(binding);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//       // holder.binding.tvName.setText(mData[position]);
//        holder.binding.tvName.setText(mData.get(position));
//        holder.binding.cvCard1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context,ChatIndividualActivity.class);
//                //intent.putExtra("Key", "FABSAVE");
//                intent.putExtra("Key", "Chat");
//                context.startActivity(intent);
//              //  context.startActivity(new Intent(context, ChatIndividualActivity.class));
//
//            }
//        });
//
////        holder.binding.ivBank.setImageResource(mData[position]);
////        Picasso.with(context)
////                .load(mData[position]).
////                into(holder.binding.ivBank);
//    }
//
//    @Override
//    public int getItemCount() {
//
//        return mData.size();
//    }
//
//    public void removeItem(int position) {
//        mData.remove(position);
//        notifyItemRemoved(position);
//    }
//
//    public void restoreItem(String item, int position) {
//        mData.add(position, item);
//        notifyItemInserted(position);
//    }
//
//    public ArrayList<String> getData() {
//        return mData;
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        private ChatListItemViewBinding binding;
//
//        public ViewHolder(ChatListItemViewBinding itemBinding) {
//            super(itemBinding.getRoot());
//            this.binding = itemBinding;
//        }
//    }
//
//
//}

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.MyViewHolder> {

    private ArrayList<String> data;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitle;
        CardView relativeLayout;

        public MyViewHolder(View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.tvName);
        }
    }

    public ChatListAdapter(ArrayList<String> data) {
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_list_item_view, parent, false);
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

