package com.penup.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.penup.R;
import com.penup.databinding.FragmentChangeNumberNextBinding;


public class ChangeNumberFragment_Next extends Fragment implements View.OnClickListener {
    FragmentChangeNumberNextBinding binding;
    Fragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_change_number__next, container, false);
        inIt();
        return binding.getRoot();
    }

    private void inIt() {
        binding.btnSubmit.setOnClickListener(this);
        binding.ivBack.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSubmit:
                fragment = new ChangeNumberNotifyFragment();
                loadFragment(fragment);
                break;
            case R.id.ivBack:
                getActivity().onBackPressed();
                break;
        }
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}