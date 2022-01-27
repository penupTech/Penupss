package com.penup.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.penup.R;
import com.penup.databinding.ActivityAwayMsgBinding;

public class AwayMsgActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityAwayMsgBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(AwayMsgActivity.this, R.layout.activity_away_msg);
        inIt();
    }

    private void inIt() {
        binding.ivBack.setOnClickListener(this);
        binding.lay1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivBack:
                onBackPressed();
                break;
            case R.id.lay1:

                startActivity(new Intent(AwayMsgActivity.this, MessageActivity.class));
                break;
        }
    }
}