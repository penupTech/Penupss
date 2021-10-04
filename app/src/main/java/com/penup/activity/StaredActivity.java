package com.penup.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.penup.R;
import com.penup.databinding.ActivityStaredBinding;

public class StaredActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityStaredBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(StaredActivity.this, R.layout.activity_stared);

        inIt();
    }

    private void inIt() {
        binding.ivBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivBack:
                finish();
                break;
        }
    }
}