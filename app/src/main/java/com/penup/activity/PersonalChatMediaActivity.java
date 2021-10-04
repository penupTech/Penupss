package com.penup.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.penup.R;
import com.penup.adapter.PagerAdapter;
import com.penup.databinding.ActivityPersonalChatMediaBinding;
import com.penup.fragment.DocsFragment;
import com.penup.fragment.LinkFragment;
import com.penup.fragment.MediaFragment;

public class PersonalChatMediaActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityPersonalChatMediaBinding binding;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = DataBindingUtil.setContentView(PersonalChatMediaActivity.this, R.layout.activity_personal_chat_media);

        inIt();
    }

    private void inIt() {
        binding.ivBack.setOnClickListener(this);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new MediaFragment(), "Media");
        pagerAdapter.addFragment(new DocsFragment(), "Docs");
        pagerAdapter.addFragment(new LinkFragment(), "Link");

        binding.viewPager.setAdapter(pagerAdapter);
        binding.tabLayout.setupWithViewPager(binding.viewPager);

//        //setting icons
//        binding.tabLayout.getTabAt(0).setIcon(R.drawable.ic_movie_white_24dp);
//        binding.tabLayout.getTabAt(1).setIcon(R.drawable.ic_movie_white_24dp);
//        binding.tabLayout.getTabAt(2).setIcon(R.drawable.ic_movie_white_24dp);
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