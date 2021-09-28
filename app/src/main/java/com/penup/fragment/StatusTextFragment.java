package com.penup.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.penup.R;
import com.penup.databinding.FragmentStatusTextBinding;


public class StatusTextFragment extends Fragment implements View.OnClickListener {
FragmentStatusTextBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       binding= DataBindingUtil.inflate(inflater,R.layout.fragment_status_text, container, false);
   inIt();
       return binding.getRoot();
    }

    private void inIt() {
        binding.ivBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivBack:
                getActivity().onBackPressed();
                break;
        }
    }
}