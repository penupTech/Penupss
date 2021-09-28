package com.penup.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.penup.R;
import com.penup.databinding.ActivityContactsInfoBinding;

public class ContactsInfoActivity extends AppCompatActivity implements View.OnClickListener {
ActivityContactsInfoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(ContactsInfoActivity.this,R.layout.activity_contacts_info);

        inIt();


    }

    private void inIt() {
binding.ivBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivBack:
                finish();
                break;
        }
    }
}