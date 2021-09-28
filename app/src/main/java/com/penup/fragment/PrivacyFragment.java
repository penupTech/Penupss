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

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivBack:
                getActivity().onBackPressed();
                break;
            case R.id.layoutLastseen:
                myDialog = PopUpDialog.dialog(getActivity());
                PopUpDialog.status.setText("Last Seen");
                myDialog.show();
                break;
            case R.id.layoutProfile:
                myDialog = PopUpDialog.dialog(getActivity());
                PopUpDialog.status.setText("Profile Photo");
                myDialog.show();

                break;
            case R.id.layoutAbout:
                myDialog = PopUpDialog.dialog(getActivity());
                PopUpDialog.status.setText("About");
                myDialog.show();
                break;
            case R.id.layoutDocument:
                showStatusPrivacy();
                break;
            case R.id.layoutGroup:
                showStatusPrivacy();
                group.setText("Who can add me to groups");
                admins.setText("Admins who can't add you to a group will have the option of inviting you privately instead.");
                break;
            case R.id.layoutLocation:
                showLocation();
                break;
        }

    }



    public void showStatusPrivacy() {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setAttributes(layoutParams);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().setGravity(Gravity.CENTER_HORIZONTAL);
        dialog.setContentView(R.layout.popup_status);
        admins = dialog.findViewById(R.id.tvChange);
        group = dialog.findViewById(R.id.tvGroup);


        dialog.show();

    }

    public void showLocation() {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setAttributes(layoutParams);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().setGravity(Gravity.CENTER_HORIZONTAL);
        dialog.setContentView(R.layout.popup_location);


        dialog.show();

    }

}