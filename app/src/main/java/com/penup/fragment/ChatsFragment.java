package com.penup.fragment;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.penup.R;
import com.penup.activity.NewBroadcastActivity;
import com.penup.adapter.ChatListAdapter;
import com.penup.common.SwipeHelper;
import com.penup.databinding.FragmentChatsBinding;

import java.util.ArrayList;
import java.util.List;

public class ChatsFragment extends Fragment implements View.OnClickListener {
    FragmentChatsBinding binding;
    ArrayList<String> stringArrayList = new ArrayList<>();
    // String[] data = {"Arjun", "Sagar", "Manish", "Amit", "Aanurag", "Raj", "Shubham", "Ram", "Singh", "Max", "Min", "XYZ", "Manish", "Amit", "Aanurag", "Raj", "Shubham", "Ram", "Manish", "Amit", "Aanurag", "Raj", "Shubham", "Ram",};
    ChatListAdapter chatListAdapter;
    Fragment fragment;
    CoordinatorLayout constraintLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chats, container, false);
        inIt();
        return binding.getRoot();
    }


    private void inIt() {

        binding.ivEdit.setOnClickListener(this::onClick);
        binding.tvBroadcastingList.setOnClickListener(this::onClick);
        populateRecyclerView();
        //  enableSwipeToDeleteAndUndo();
//        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
//        itemTouchHelper.attachToRecyclerView( binding.recyChatList);
    }

    private void populateRecyclerView() {
        stringArrayList.add("Arjun");
        stringArrayList.add("Sagar");
        stringArrayList.add("Manish");
        stringArrayList.add("Amit");
        stringArrayList.add("Aanurag");
        stringArrayList.add("Arjun");
        stringArrayList.add("Sagar");
        stringArrayList.add("Manish");
        stringArrayList.add("Amit");
        stringArrayList.add("Aanurag");
        stringArrayList.add("Arjun");
        stringArrayList.add("Sagar");
        stringArrayList.add("Manish");
        stringArrayList.add("Amit");
        stringArrayList.add("Aanurag");
//        mAdapter = new RecyclerViewAdapter(stringArrayList);
//        recyclerView.setAdapter(mAdapter);
        chatListAdapter = new ChatListAdapter(stringArrayList);
        binding.recyChatList.setAdapter(chatListAdapter);

        helo();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivEdit:
                fragment = new EditProfileFragment();
                loadFragment(fragment);
                break;
            case R.id.tvBroadcastingList:
                startActivity(new Intent(getContext(), NewBroadcastActivity.class));
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

    public void helo() {

        SwipeHelper swipeHelper = new SwipeHelper(getContext()) {
            @Override
            public void instantiateUnderlayButton(RecyclerView.ViewHolder viewHolder, List<UnderlayButton> underlayButtons) {
//                underlayButtons.add(new SwipeHelper.UnderlayButton(
//                        "Delete",
//                        0,
//                        Color.parseColor("#FF3C30"),
//                        new SwipeHelper.UnderlayButtonClickListener() {
//                            @Override
//                            public void onClick(final int pos) {
//                                final String item = chatListAdapter.getData().get(pos);
//                                chatListAdapter.removeItem(pos);
//
//                                Snackbar snackbar = Snackbar.make(binding.cons, "Item was removed from the list.", Snackbar.LENGTH_LONG);
//                                snackbar.setAction("UNDO", new View.OnClickListener() {
//                                    @Override
//                                    public void onClick(View view) {
//                                        chatListAdapter.restoreItem(item, pos);
//                                        binding.recyChatList.scrollToPosition(pos);
//                                    }
//                                });
//
//                                snackbar.setActionTextColor(Color.YELLOW);
//                                snackbar.show();
//                            }
//                        }
//                ));
                underlayButtons.add(new SwipeHelper.UnderlayButton(
                        "Archived",
                        0,
                        Color.parseColor("#FF3C30"),
                        new SwipeHelper.UnderlayButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                Toast.makeText(getContext(), "You clicked like on item position " + pos, Toast.LENGTH_LONG).show();
                            }
                        }
                ));
                underlayButtons.add(new SwipeHelper.UnderlayButton(
                        "More",
                        0,
                        Color.parseColor("#FF9502"),
                        new SwipeHelper.UnderlayButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                Toast.makeText(getContext(), "You clicked share on item position " + pos, Toast.LENGTH_LONG).show();
                            }
                        }
                ));
            }
        };
        swipeHelper.attachToRecyclerView(binding.recyChatList);
    }


}