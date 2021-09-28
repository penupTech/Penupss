package com.penup.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.penup.R;
import com.penup.databinding.FragmentTwoSetpVarification1stBinding;

public class TwoSetpVarificationFragment_1st extends Fragment implements View.OnClickListener {
    FragmentTwoSetpVarification1stBinding binding;
Fragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_two_setp_varification_1st, container, false);
        inIt();
        return binding.getRoot();
    }

    private void inIt() {
        binding.ivBack.setOnClickListener(this::onClick);
        binding.layoutChangePin.setOnClickListener(this::onClick);
        binding.layoutChangeEmail.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivBack:
                getActivity().onBackPressed();
                break;
            case R.id.layoutChangePin:
                fragment = new TwoStepcVarificationFragment_2nd();
                loadFragment(fragment);
                break;
            case R.id.layoutChangeEmail:
                fragment = new TwoStedpVarificationFragment_3rd();
                loadFragment(fragment);
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