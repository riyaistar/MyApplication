package com.example.myapplication.customalertdialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import butterknife.BindView;

public class ViewDialog {
    public ImageButton mDialogNo, mDialogOk ;
    public TextView heading, message;
    public void showDialog(final Activity activity) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.activity_custom_alert);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        TextView heading = dialog.findViewById(R.id.heading);
        TextView message = dialog.findViewById(R.id.message);
        ImageButton mDialogNo = dialog.findViewById(R.id.cancel);
        mDialogNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Cancel", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        ImageButton mDialogOk = dialog.findViewById(R.id.ok);
        mDialogOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Okay", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });




        dialog.show();
    }
}