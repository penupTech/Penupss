package com.penup.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.penup.R;
import com.penup.databinding.FragmentBottomSheetNotificationBinding;


public class BottomSheetNotificationFragment extends BottomSheetDialogFragment {
    FragmentBottomSheetNotificationBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bottom_sheet_notification, container, false);


        return binding.getRoot();
    }
}