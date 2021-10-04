package com.penup.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.penup.R;
import com.penup.activity.LargerMediaActivity;
import com.penup.activity.PersonalChatMediaActivity;
import com.penup.adapter.ChatListAdapter;
import com.penup.adapter.LargerDataPersonAdapter;
import com.penup.databinding.ContactDataUsesPersonListViewBinding;
import com.penup.databinding.FragmentManageStorageBinding;


public class ManageStorageFragment extends Fragment implements View.OnClickListener {
    FragmentManageStorageBinding binding;
    LargerDataPersonAdapter largerDataPersonAdapte;
    String[] data = {"Arjun", "Sagar", "Manish", "Amit", "Aanurag", "Raj", "Shubham", "Ram", "Singh", "Max", "Min", "XYZ", "Manish", "Amit", "Aanurag", "Raj", "Shubham", "Ram", "Manish", "Amit", "Aanurag", "Raj", "Shubham", "Ram",};
    Fragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_manage_storage, container, false);

        inIt();
        return binding.getRoot();


    }

    private void inIt() {
        largerDataPersonAdapte = new LargerDataPersonAdapter(data, getActivity());
        binding.recyPerson.setHasFixedSize(true);
        binding.recyPerson.setAdapter(largerDataPersonAdapte);
        binding.recyPerson.setNestedScrollingEnabled(false);
        binding.ivBack.setOnClickListener(this::onClick);
        binding.layout.setOnClickListener(this::onClick);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivBack:
                getActivity().onBackPressed();
                break;
            case R.id.layout:
                startActivity(new Intent(getActivity(), LargerMediaActivity.class));
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