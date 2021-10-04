package com.penup.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.penup.R;
import com.penup.adapter.LargerDataPersonAdapter;
import com.penup.adapter.LargerMediaListAdapter;
import com.penup.databinding.ActivityLargerMediaBinding;

public class LargerMediaActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityLargerMediaBinding binding;
    String[] data = {"Media1", "Media2", "Media3", "Media4", "Media5", "Media6", "Media7", "Media8", "Media9", "Media10"};
    LargerMediaListAdapter largerMediaListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(LargerMediaActivity.this, R.layout.activity_larger_media);


        inIt();
    }

    private void inIt() {

        binding.ivBack.setOnClickListener(this::onClick);
        largerMediaListAdapter = new LargerMediaListAdapter(data, LargerMediaActivity.this);
        binding.recyMedia.setHasFixedSize(true);
        binding.recyMedia.setAdapter(largerMediaListAdapter);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivBack:
                onBackPressed();
                break;

        }
    }
}