package com.penup.fragment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.penup.R;
import com.penup.adapter.ChatListAdapter;
import com.penup.databinding.FragmentChatsBinding;

public class ChatsFragment extends Fragment implements View.OnClickListener {
    FragmentChatsBinding binding;
    String[] data = {"Arjun", "Sagar", "Manish", "Amit", "Aanurag", "Raj", "Shubham", "Ram", "Singh", "Max", "Min", "XYZ", "Manish", "Amit", "Aanurag", "Raj", "Shubham", "Ram", "Manish", "Amit", "Aanurag", "Raj", "Shubham", "Ram",};
    ChatListAdapter chatListAdapter;
    Fragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chats, container, false);
        inIt();
        return binding.getRoot();
    }


    private void inIt() {
        chatListAdapter = new ChatListAdapter(data, getActivity());
        binding.recyChatList.setAdapter(chatListAdapter);
        binding.ivEdit.setOnClickListener(this::onClick);
      //  binding.ivU.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivEdit:
                fragment = new EditProfileFragment();
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