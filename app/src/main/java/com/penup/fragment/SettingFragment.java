package com.penup.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.penup.R;
import com.penup.databinding.FragmentSettingBinding;


public class SettingFragment extends Fragment implements View.OnClickListener {
    FragmentSettingBinding binding;
    Fragment fragment;
    NavController navController;
     private static final int RESULT_PICK_CONTACT =1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting, container, false);

        inIt();

        return binding.getRoot();
    }

    private void inIt() {
        //navController = Navigation.findNavController(binding.getRoot());
        binding.layoutBuisiness.setOnClickListener(this);
        binding.layoutAccount.setOnClickListener(this);
        binding.layoutChat.setOnClickListener(this);
        binding.layoutNotification.setOnClickListener(this);
        binding.layoutStorage.setOnClickListener(this);
        binding.layoutHelp.setOnClickListener(this);
        binding.layoutInvite.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layoutBuisiness:
                fragment = new BusinessToolsFragment();
                loadFragment(fragment);
                // navController.navigate(R.id.action_nav_settings_to_setting_navigation);
                break;
            case R.id.layoutAccount:
                fragment = new AccountFragment();
                loadFragment(fragment);
                break;
            case R.id.layoutChat:
                fragment = new ChatsSettingFragment();
                loadFragment(fragment);
                break;
            case R.id.layoutNotification:
                fragment = new NotificationFragment();
                loadFragment(fragment);
                break;
            case R.id.layoutStorage:
                fragment = new StorageAndDataFragment();
                loadFragment(fragment);
                break;
            case R.id.layoutHelp:
                fragment = new HelpFragment();
                loadFragment(fragment);
                break;
            case R.id.layoutInvite:

                fragment=new InviteFriendFragment();
                loadFragment(fragment);
//                Intent in = new Intent (Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
//               startActivityForResult (in, RESULT_PICK_CONTACT);
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


//    void myNavigationHandler(myArguments) {
//        Navigation.findNavController(binding.root)
//                .navigate(MyFragmentDirections.actionMyAction(myArguments))
//    }
}