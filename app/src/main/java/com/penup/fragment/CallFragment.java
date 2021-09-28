package com.penup.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.penup.R;
import com.penup.adapter.AllListAdapter;
import com.penup.adapter.ChatListAdapter;
import com.penup.adapter.MissedCallListAdapter;
import com.penup.databinding.FragmentCallBinding;


public class CallFragment extends Fragment implements View.OnClickListener {
    FragmentCallBinding binding;
    String[] data = {"Arjun", "Sagar", "Manish", "Amit", "Aanurag", "Raj", "Shubham", "Ram", "Singh", "Max", "Min", "XYZ", "Manish", "Amit", "Aanurag", "Raj", "Shubham", "Ram", "Manish", "Amit", "Aanurag", "Raj", "Shubham", "Ram",};
AllListAdapter allListAdapter;
MissedCallListAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_call, container, false);
        inIt();
        return binding.getRoot();
    }

    private void inIt() {
        binding.tvAll.setOnClickListener(this::onClick);
        binding.tvMissed.setOnClickListener(this::onClick);
        binding.tvAll.setBackgroundResource(R.drawable.showone);
        binding.tvMissed.setBackgroundResource(R.drawable.showtow);
        binding.male.setOnClickListener(this::onClick);
        binding.dmale.setOnClickListener(this::onClick);
        binding.female.setOnClickListener(this::onClick);
        binding.dfemale.setOnClickListener(this::onClick);
        allListAdapter = new AllListAdapter(data, getActivity());
        binding.recyChatListAll.setAdapter(allListAdapter);
        adapter = new MissedCallListAdapter(data, getActivity());
        binding.recyChatListMissed.setAdapter(adapter);

////        binding.layout.setOnClickListener(this::onClick);
//        layoutDfemale.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                str_gender = "F";
//                layoutMale.setVisibility(View.GONE);
//                layoutDmale.setVisibility(View.VISIBLE);
//                layoutDfemale.setVisibility(View.GONE);
//                layoutFemale.setVisibility(View.VISIBLE);
//
//
//            }
//        });
//        layoutDmale.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                str_gender = "M";
//                layoutMale.setVisibility(View.VISIBLE);
//                layoutDmale.setVisibility(View.GONE);
//                layoutDfemale.setVisibility(View.VISIBLE);
//                layoutFemale.setVisibility(View.GONE);
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.tvAll:
//                binding.tvAll.setBackgroundResource(R.drawable.showone);
//                binding.tvAll.setTextColor(getResources().getColor(R.color.white));
//                binding.tvMissed.setTextColor(getResources().getColor(R.color.missed));
//                binding.tvMissed.setBackgroundResource(R.drawable.showtow);
//                binding.layoutAll.setVisibility(View.VISIBLE);
//                binding.layoutMissed.setVisibility(View.GONE);
//                break;
//            case R.id.tvMissed:
//                binding.tvAll.setBackgroundResource(R.drawable.show_m_two);
//                binding.tvMissed.setBackgroundResource(R.drawable.show_m_one);
//                binding.tvAll.setTextColor(getResources().getColor(R.color.missed));
//                binding.tvMissed.setTextColor(getResources().getColor(R.color.white));
//                binding.layoutAll.setVisibility(View.GONE);
//                binding.layoutMissed.setVisibility(View.VISIBLE);
//                break;
            case R.id.dfemale:
//                layoutMale.setVisibility(View.GONE);
//                layoutDmale.setVisibility(View.VISIBLE);
//                layoutDfemale.setVisibility(View.GONE);
//                layoutFemale.setVisibility(View.VISIBLE);
//
                binding.male.setVisibility(View.GONE);
                binding.dmale.setVisibility(View.VISIBLE);
                binding.dfemale.setVisibility(View.GONE);
                binding.female.setVisibility(View.VISIBLE);
                binding.layoutAll.setVisibility(View.GONE);
                binding.layoutMissed.setVisibility(View.VISIBLE);

                break;
            case R.id.dmale:
                binding.male.setVisibility(View.VISIBLE);
                binding.dmale.setVisibility(View.GONE);
                binding.dfemale.setVisibility(View.VISIBLE);
                binding.female.setVisibility(View.GONE);
                binding.layoutAll.setVisibility(View.VISIBLE);
                binding.layoutMissed.setVisibility(View.GONE);
//                layoutMale.setVisibility(View.VISIBLE);
//                layoutDmale.setVisibility(View.GONE);
//                layoutDfemale.setVisibility(View.VISIBLE);
//                layoutFemale.setVisibility(View.GONE);
                break;
        }


    }
}