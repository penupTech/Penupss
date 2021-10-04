package com.penup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.futuremind.recyclerviewfastscroll.SectionTitleProvider;
import com.penup.R;
import com.penup.databinding.ContactItemsListViewBinding;
import com.penup.modle.ContactsInfo;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>  {

    List<ContactsInfo> data;
    private Context context;
    private LayoutInflater layoutInflater;
    private String[] mData;

    public ContactAdapter(List<ContactsInfo> data, Context context) {
        this.data = data;
        this.context = context;
    }
    public ContactAdapter(String[] mData, Context context) {
        this.mData = mData;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ContactItemsListViewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.contact_items_list_view, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder, int position) {
        //ContactsInfo reportData = mData.get(position);
//        holder.binding.tvSrNo.setText(reportData.getSr_No());
//        holder.binding.tvCType.setText(reportData.getClient_Type());
//        holder.binding.tvCName.setText(reportData.getcC_Name());
//        holder.binding.tvName.setText(reportData.getName());
//        holder.binding.tvShopName.setText(reportData.getShop_Name());
//        holder.binding.tvAddress.setText(reportData.getAddress());
//        holder.binding.tvStatus.setText(reportData.getStatus());
//        holder.binding.tvRemark.setText(reportData.getRemarks());
        holder.binding.displayName.setText(mData[position]);
       // holder.binding.displayName.setText(reportData.getDisplayName());
       // holder.binding.phoneNumber.setText(reportData.getPhoneNumber());

        holder.binding.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        private ContactItemsListViewBinding binding;

        public ViewHolder(ContactItemsListViewBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }
}
