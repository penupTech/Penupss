package com.penup.fragment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.penup.R;
import com.penup.adapter.BottomSheetAdapter;
import com.penup.adapter.ChatListAdapter;
import com.penup.databinding.FragmentBottomSheetBinding;


public class BottomSheetFragment extends BottomSheetDialogFragment {
    FragmentBottomSheetBinding binding;
    BottomSheetAdapter bottomSheetAdapter;
    String[] data = {"Arjun", "Sagar", "Manish", "Amit", "Aanurag", "Raj", "Shubham", "Ram", "Singh", "Max", "Min", "XYZ", "Manish", "Amit", "Aanurag", "Raj", "Shubham", "Ram", "Manish", "Amit", "Aanurag", "Raj", "Shubham", "Ram",};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bottom_sheet, container, false);
        binding.getRoot().setBackgroundResource(R.drawable.bottomdialog);
        bottomSheetAdapter = new BottomSheetAdapter(data, getActivity());
        binding.bottomRecy.setAdapter(bottomSheetAdapter);


        return binding.getRoot();
    }

    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new BottomSheetDialog(requireContext(), android.R.style.Theme_Translucent_NoTitleBar); // To have transparent dialog window background.
    }
}