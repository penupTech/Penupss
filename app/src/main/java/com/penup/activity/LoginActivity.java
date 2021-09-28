package com.penup.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.penup.R;
import com.penup.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity  implements View.OnClickListener {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(LoginActivity.this, R.layout.activity_login);
   inIt();
    }

    private void inIt() {
        binding.tvDone.setOnClickListener(this::onClick);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvDone:
                startActivity(new Intent(this,ProfileActivity.class));
                break;
        }

    }
}