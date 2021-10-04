package com.penup.fragment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.penup.R;
import com.penup.common.PopUpDialog;
import com.penup.databinding.FragmentNotificationBinding;


public class NotificationFragment extends Fragment implements View.OnClickListener {
    FragmentNotificationBinding binding;
    Dialog dialog;
    ConstraintLayout bottomSheetLayout;
    Bundle bundle;
    BottomSheetFragment bottomSheet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notification, container, false);
        inIt();
        return binding.getRoot();
    }

    private void inIt() {
        binding.ivBack.setOnClickListener(this::onClick);
        binding.layoutVibrate.setOnClickListener(this::onClick);
        binding.layoutVibrate2.setOnClickListener(this::onClick);
        binding.layoutLight.setOnClickListener(this::onClick);
        binding.layoutRingtones.setOnClickListener(this::onClick);
        binding.layoutNotification.setOnClickListener(this::onClick);
        bottomSheetLayout = binding.getRoot().findViewById(R.id.layout_bottom);
        bottomSheet = new BottomSheetFragment();
        bundle = new Bundle();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivBack:
                getActivity().onBackPressed();
                break;
            case R.id.layoutVibrate:
                dialog = PopUpDialog.vibratePopUp(getContext());
                dialog.show();
                break;
            case R.id.layoutVibrate2:
                dialog = PopUpDialog.vibratePopUp(getContext());
                dialog.show();
                break;
            case R.id.layoutLight:
                dialog = PopUpDialog.lightPopUp(getContext());
                dialog.show();
                break;
            case R.id.layoutRingtones:
                bottomSheet.show(getActivity().getSupportFragmentManager(), "");
                break;
            case R.id.layoutNotification:
                //   bundle.putString("key", "data");
                // bottomSheet.setArguments(bundle);
                bottomSheet.show(getActivity().getSupportFragmentManager(), "");
                break;

        }

    }
}