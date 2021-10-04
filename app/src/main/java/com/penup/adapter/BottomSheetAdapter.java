package com.penup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.penup.R;
import com.penup.databinding.BottomSheetItemListBinding;
import com.penup.databinding.ContactDataUsesPersonListViewBinding;

public class BottomSheetAdapter extends RecyclerView.Adapter<BottomSheetAdapter.ViewHolder> {

    private String[] mData;
    private Context context;
    private LayoutInflater layoutInflater;
    BottomSheetItemListBinding binding;


    public BottomSheetAdapter(String[] mData, Context context) {
        this.mData = mData;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.bottom_sheet_item_list, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.tvName.setText(mData[position]);
//        holder.binding.cvCard1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                context.startActivity(new Intent(context, ChatIndividualActivity.class));
//            }
//        });

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
        private BottomSheetItemListBinding binding;

        public ViewHolder(BottomSheetItemListBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;

        }
    }


}
