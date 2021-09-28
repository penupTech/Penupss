package com.penup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.penup.R;
import com.penup.activity.LoginActivity;
import com.penup.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityWelcomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(WelcomeActivity.this, R.layout.activity_welcome);

        inIt();

    }

    private void inIt() {
        binding.tvAgree.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvAgree:
                startActivity(new Intent(this, LoginActivity.class));
        }

    }
}