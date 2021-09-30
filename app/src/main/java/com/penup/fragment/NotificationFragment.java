package com.penup.fragment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.penup.R;
import com.penup.common.PopUpDialog;
import com.penup.databinding.FragmentNotificationBinding;


public class NotificationFragment extends Fragment implements View.OnClickListener {
    FragmentNotificationBinding binding;
    Dialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notification, container, false);
        inIt();
        return binding.getRoot();
    }
    private void inIt() {
        binding.ivBack.setOnClickListener(this::onClick);
        binding.layoutVibrate.setOnClickListener(this::onClick);
        binding.layoutVibrate2.setOnClickListener(this::onClick);
        binding.layoutLight.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivBack:
                getActivity().onBackPressed();
                break;
            case R.id.layoutVibrate:
                dialog= PopUpDialog.vibratePopUp(getContext());
                dialog.show();
                break;
            case R.id.layoutVibrate2:
                dialog= PopUpDialog.vibratePopUp(getContext());
                dialog.show();
                break;
            case R.id.layoutLight:
                dialog= PopUpDialog.lightPopUp(getContext());
                dialog.show();
                break;
        }

    }
}