package com.penup.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.penup.R;
import com.penup.adapter.BroadcastGroupAdapter;
import com.penup.adapter.BroadcastGroupNewAdapter;
import com.penup.adapter.ContactAdapter;
import com.penup.databinding.ActivityNewBroadcastBinding;

public class NewBroadcastActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityNewBroadcastBinding binding;
    String[] data = {"Arjun", "Sagar", "Manish", "Amit", "Aanurag", "Raj", "Shubham", "Ram", "Singh", "Max", "Min", "XYZ", "Manish", "Amit", "Aanurag", "Raj", "Shubham", "Ram", "Manish", "Amit", "Aanurag", "Raj", "Shubham", "Ram",};
    BroadcastGroupAdapter broadcastGroupAdapter;
    BroadcastGroupNewAdapter broadcastGroupNewAdapter;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(NewBroadcastActivity.this, R.layout.activity_new_broadcast);
        inIt();
    }

    private void inIt() {
        broadcastGroupAdapter = new BroadcastGroupAdapter(data, this);
        binding.recyPersonList.setAdapter(broadcastGroupAdapter);
        binding.ivBack.setOnClickListener(this);
        broadcastGroupNewAdapter = new BroadcastGroupNewAdapter(data, this);
        binding.recyAddList.setAdapter(broadcastGroupNewAdapter);
        binding.fbSave.setOnClickListener(this::onClick);
        bundle=new Bundle();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivBack:
                finish();
                break;
            case R.id.fbSave:
                Intent intent = new Intent(NewBroadcastActivity.this,ChatIndividualActivity.class);
                intent.putExtra("Key", "FABSAVE");
                startActivity(intent);
              //  bundle.putString("Key","FABSAVE");
              //  startActivity(new Intent(NewBroadcastActivity.this,ChatIndividualActivity.class));
                break;
        }
    }
}