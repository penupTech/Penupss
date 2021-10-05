package com.penup.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.penup.R;
import com.penup.databinding.ActivityContactsInfoBinding;

public class ContactsInfoActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityContactsInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(ContactsInfoActivity.this, R.layout.activity_contacts_info);

        inIt();


    }

    private void inIt() {
       // binding.ivBack.setOnClickListener(this);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back, null));
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.ct);
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.white));
        collapsingToolbar.setCollapsedTitleTextColor(getResources().getColor(R.color.light_purple));

        binding.layoutMedia.setOnClickListener(this::onClick);
        binding.layoutStarMSg.setOnClickListener(this::onClick);
        AppBarLayout mAppBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);

        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    isShow = true;
                    //  showOption(R.id.action_info);
                } else if (isShow) {
                    isShow = false;
                    //(R.id.action_info);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.layoutMedia:
                startActivity(new Intent(ContactsInfoActivity.this,PersonalChatMediaActivity.class));
       break;

            case R.id.layoutStarMSg:
                startActivity(new Intent(ContactsInfoActivity.this,StaredActivity.class));
                break;
        }
    }
}