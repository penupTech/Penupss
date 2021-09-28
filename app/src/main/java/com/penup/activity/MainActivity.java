package com.penup.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.penup.R;
import com.penup.databinding.ActivityMainBinding;
import com.penup.fragment.CallFragment;
import com.penup.fragment.CameraFragment;
import com.penup.fragment.ChatsFragment;
import com.penup.fragment.SettingFragment;
import com.penup.fragment.StatusFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding;

    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        inIt();
    }

    private void inIt() {
        loadFragment(new ChatsFragment());
        binding.bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        binding.bottomNavigation.getMenu().findItem(R.id.nav_chats).setChecked(true);
//        NavHostFragment navHostFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
//        NavController navController = navHostFragment.getNavController();
//        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
//        NavigationUI.setupWithNavController(bottomNav, navController);


    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.nav_status:
                    //  binding.xyz.setBackground(getDrawable(R.color.xyz));
                    fragment = new StatusFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_call:
                    //binding.xyz.setBackground(getDrawable(R.color.white));
                    fragment = new CallFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_camera:
                    //binding.xyz.setBackground(getDrawable(R.color.white));
                    fragment = new CameraFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_chats:
                    //binding.xyz.setBackground(getDrawable(R.color.white));
                    fragment = new ChatsFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_settings:
                    //binding.xyz.setBackground(getDrawable(R.color.white));
                    fragment = new SettingFragment();
                    loadFragment(fragment);
                    return true;

            }

            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {

    }
}