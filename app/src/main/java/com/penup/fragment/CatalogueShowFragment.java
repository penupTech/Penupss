package com.penup.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.penup.R;
import com.penup.databinding.FragmentCatalogueShowBinding;

public class CatalogueShowFragment extends Fragment implements View.OnClickListener {

    FragmentCatalogueShowBinding binding;
    Fragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_catalogue_show, container, false);
inIt();
        return binding.getRoot();
    }

    private void inIt() {

        binding.ivCk.setOnClickListener(this);
        binding.ivAdd.setOnClickListener(this::onClick);
        binding.ivBack.setOnClickListener(this::onClick);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivBack:
                getActivity().onBackPressed();
                break;
            case R.id.ivCk:
                fragment = new CatalogueItemsFragment();
                loadFragment(fragment);
                break;
            case R.id.ivAdd:
                fragment = new CatalogueAddItemsFragment();
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