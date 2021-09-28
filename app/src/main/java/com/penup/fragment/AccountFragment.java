package com.penup.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.penup.R;
import com.penup.databinding.FragmentAccountBinding;

public class AccountFragment extends Fragment implements View.OnClickListener {
    FragmentAccountBinding binding;
    Fragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_account, container, false);
        inIt();


        return binding.getRoot();
    }

    private void inIt() {
        binding.layoutSecurity.setOnClickListener(this::onClick);
        binding.ivBack.setOnClickListener(this::onClick);
        binding.layoutPrivacy.setOnClickListener(this::onClick);
        binding.layoutVerification.setOnClickListener(this::onClick);
        binding.layoutChange.setOnClickListener(this::onClick);
        binding.layoutRequestInfo.setOnClickListener(this::onClick);
        binding.layoutDelete.setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layoutSecurity:
                fragment = new SecurityFragment();
                loadFragment(fragment);
                break;
            case R.id.layoutPrivacy:
                fragment = new PrivacyFragment();
                loadFragment(fragment);
                break;
            case R.id.layoutVerification:
                fragment = new TwoSetpVarificationFragment_1st();
                loadFragment(fragment);
                break;
            case R.id.layoutChange:
                fragment = new ChangeNumberFragment();
                loadFragment(fragment);
                break;
            case R.id.layoutRequestInfo:
                fragment = new AccountInfoRequestFragment();
                loadFragment(fragment);
                break;
            case R.id.layoutDelete:
                fragment = new AccountDeleteFragment();
                loadFragment(fragment);
                break;
            case R.id.ivBack:
                getActivity().onBackPressed();
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