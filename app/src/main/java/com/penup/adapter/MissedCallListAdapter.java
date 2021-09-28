package com.penup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.penup.R;
import com.penup.databinding.AllListItemViewBinding;
import com.penup.databinding.MissedcallListItemViewBinding;

public class MissedCallListAdapter extends RecyclerView.Adapter<MissedCallListAdapter.ViewHolder> {

    private String[] mData;
    private Context context;
    private LayoutInflater layoutInflater;
    MissedcallListItemViewBinding binding;


    public MissedCallListAdapter(String[] mData, Context context) {
        this.mData = mData;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.missedcall_list_item_view, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.tvTime10.setText(mData[position]);

//        holder.binding.ivBank.setImageResource(mData[position]);
//        Picasso.with(context)
//                .load(mData[position]).
//                into(holder.binding.ivBank);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private MissedcallListItemViewBinding binding;

        public ViewHolder(MissedcallListItemViewBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


}
