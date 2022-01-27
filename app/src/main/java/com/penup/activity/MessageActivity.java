package com.penup.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.penup.R;
import com.penup.databinding.ActivityMessageBinding;

public class MessageActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMessageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(MessageActivity.this, R.layout.activity_message);
        inIt();
    }

    private void inIt() {
        binding.tvCancle.setOnClickListener(this);
        binding.tvOK.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvCancle:
                finish();
                break;
            case R.id.tvOk:
                Toast.makeText(MessageActivity.this, "Message Saved", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }

    }
}