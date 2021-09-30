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
import com.penup.databinding.FragmentStorageAndDataBinding;

public class StorageAndDataFragment extends Fragment implements View.OnClickListener {
    FragmentStorageAndDataBinding binding;
Dialog dialog;
Fragment  fragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_storage_and_data, container, false);
        inIt();
   return binding.getRoot();
    }


    private void inIt() {
        binding.ivBack.setOnClickListener(this::onClick);
        binding.layoutPhoto.setOnClickListener(this::onClick);
        binding.layoutAudio.setOnClickListener(this::onClick);
        binding.layoutVideo.setOnClickListener(this::onClick);
        binding.layoutDocument.setOnClickListener(this::onClick);
        binding.layoutUpload.setOnClickListener(this::onClick);
        binding.layoutNetwork.setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivBack:
                getActivity().onBackPressed();
                break;
            case R.id.layoutPhoto:
                dialog= PopUpDialog.storagePopUp(getContext());
                dialog.show();
                break;
            case R.id.layoutAudio:
                dialog= PopUpDialog.storagePopUp(getContext());
                dialog.show();
                break;
            case R.id.layoutVideo:
                dialog= PopUpDialog.storagePopUp(getContext());
                dialog.show();
                break;
            case R.id.layoutDocument:
                dialog= PopUpDialog.storagePopUp(getContext());
                dialog.show();
                break;
            case R.id.layoutUpload:
                dialog= PopUpDialog.mediaPopUp(getContext());
                dialog.show();
                break;
            case R.id.layoutNetwork:
                fragment=new NetworkUsageFragment();
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