package com.penup.fragment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.penup.R;
import com.penup.common.PopUpDialog;
import com.penup.databinding.FragmentChatsSettingBinding;


public class ChatsSettingFragment extends Fragment implements View.OnClickListener {
    FragmentChatsSettingBinding binding;
    Fragment fragment;
    Dialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chats_setting, container, false);
        inIt();
        return binding.getRoot();
    }

    private void inIt() {
        binding.ivBack.setOnClickListener(this::onClick);
        binding.layoutHistory.setOnClickListener(this::onClick);
        binding.layoutBackup.setOnClickListener(this::onClick);
        binding.layoutThemes.setOnClickListener(this::onClick);
        binding.layoutLanguage.setOnClickListener(this::onClick);
        binding.layoutFont.setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivBack:
                getActivity().onBackPressed();
            case R.id.layoutHistory:
                fragment = new ChatHistoryFragment();
                loadFragment(fragment);
                break;
            case R.id.layoutBackup:
                fragment = new ChatBackupFragment();
                loadFragment(fragment);
                break;
            case R.id.layoutThemes:
                dialog = PopUpDialog.themePopUp(getActivity());
                dialog.show();
                break;
            case R.id.layoutLanguage:
                dialog = PopUpDialog.languagePopUp(getActivity());
                dialog.show();
                break;
            case R.id.layoutFont:
                dialog = PopUpDialog.fontPopUp(getActivity());
                dialog.show();
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