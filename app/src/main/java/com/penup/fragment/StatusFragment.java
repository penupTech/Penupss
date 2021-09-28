package com.penup.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.penup.R;
import com.penup.databinding.FragmentStatusBinding;


public class StatusFragment extends Fragment implements View.OnClickListener {

    FragmentStatusBinding binding;
    Fragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_status, container, false);
        inIt();
        return binding.getRoot();
    }

    private void inIt() {
        binding.ivEdit.setOnClickListener(this::onClick);
        binding.tvPrivacy.setOnClickListener(this::onClick);
    }


    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivEdit:

                fragment = new StatusTextFragment();
                loadFragment(fragment);
                break;
            case R.id.tvPrivacy:
                fragment = new PrivacyFragment();
                loadFragment(fragment);
        }
    }
}