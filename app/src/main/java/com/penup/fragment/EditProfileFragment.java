package com.penup.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.penup.R;
import com.penup.databinding.FragmentEditProfileBinding;

public class EditProfileFragment extends Fragment implements View.OnClickListener {

    FragmentEditProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_profile, container, false);
        inIt();
        return binding.getRoot();
    }

    private void inIt() {
        binding.ivBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivBack:
                getActivity().onBackPressed();
                break;
        }

    }
}