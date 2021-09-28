package com.penup.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.penup.R;

public class PopUpDialog {


    public static TextView status, group, admins;


    public static Dialog dialog(Context context) {
     Dialog dialog = new Dialog(context);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().setAttributes(layoutParams);
        dialog.getWindow().setGravity(Gravity.CENTER_HORIZONTAL);
        dialog.setContentView(R.layout.popup_lastseen);
        status = dialog.findViewById(R.id.tvText);
        dialog.show();
        return dialog;

    }

//    public void showStatusPrivacy() {
//        final Dialog dialog = new Dialog();
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setCancelable(true);
//        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
//        layoutParams.copyFrom(dialog.getWindow().getAttributes());
//        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
//        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
//        dialog.getWindow().setAttributes(layoutParams);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//        dialog.getWindow().setGravity(Gravity.CENTER_HORIZONTAL);
//        dialog.setContentView(R.layout.popup_status);
//        admins = dialog.findViewById(R.id.tvChange);
//        group = dialog.findViewById(R.id.tvGroup);
//
//
//        dialog.show();
//
//    }
//
//    public void showLocation() {
//        final Dialog dialog = new Dialog();
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setCancelable(true);
//        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
//        layoutParams.copyFrom(dialog.getWindow().getAttributes());
//        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
//        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
//        dialog.getWindow().setAttributes(layoutParams);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//        dialog.getWindow().setGravity(Gravity.CENTER_HORIZONTAL);
//        dialog.setContentView(R.layout.popup_location);
//
//
//        dialog.show();
//
//    }
}
