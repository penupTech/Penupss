package com.penup.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.penup.R;
import com.penup.activity.MainActivity;
import com.penup.common.PopUpDialog;
import com.penup.databinding.FragmentPrivacyBinding;

public class PrivacyFragment extends Fragment implements View.OnClickListener {
    FragmentPrivacyBinding binding;
    TextView status, group, admins;
    Dialog myDialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_privacy, container, false);
        inIt();
        return binding.getRoot();
    }

    private void inIt() {
        binding.ivBack.setOnClickListener(this::onClick);
        binding.layoutLastseen.setOnClickListener(this::onClick);
        binding.layoutAbout.setOnClickListener(this::onClick);
        binding.layoutProfile.setOnClickListener(this::onClick);
        binding.layoutDocument.setOnClickListener(this::onClick);
        binding.layoutGroup.setOnClickListener(this::onClick);
        binding.layoutLocation.setOnClickListener(this::onClick);
        binding.layoutFinger.setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivBack:
                getActivity().onBackPressed();
                break;
            case R.id.layoutLastseen:
                myDialog = PopUpDialog.lastSeenPopUp(getActivity());
                PopUpDialog.status.setText("Last Seen");
                myDialog.show();
                break;
            case R.id.layoutProfile:
                myDialog = PopUpDialog.lastSeenPopUp(getActivity());
                PopUpDialog.status.setText("Profile Photo");
                myDialog.show();

                break;
            case R.id.layoutAbout:
                myDialog = PopUpDialog.lastSeenPopUp(getActivity());
                PopUpDialog.status.setText("About");
                myDialog.show();
                break;
            case R.id.layoutDocument:
                myDialog = PopUpDialog.statusPopUp(getActivity());
                myDialog.show();
                break;
            case R.id.layoutGroup:
                myDialog = PopUpDialog.statusPopUp(getActivity());
                myDialog.show();
                PopUpDialog.group.setText("Who can add me to groups");
                PopUpDialog.admins.setText("Admins who can't add you to a group will have the option of inviting you privately instead.");
                break;
            case R.id.layoutLocation:
                myDialog = PopUpDialog.locationPopUp(getContext());
                myDialog.show();
                break;
            case R.id.layoutFinger:
                myDialog = PopUpDialog.fingerprintPopUp(getContext());
                myDialog.show();
                break;
        }

    }




}