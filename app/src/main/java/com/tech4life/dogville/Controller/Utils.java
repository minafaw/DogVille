package com.tech4life.dogville.Controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import com.tech4life.dogville.R;

/**
 * Created by karma on 17/03/2015.
 */
public class Utils {


    public static ProgressDialog dialog;
    private static AlertDialog.Builder builder;
    private static AlertDialog alert;

    public static void showLoader(Activity activity) {
        if (dialog == null) {
            dialog = new ProgressDialog(activity);
            dialog.setMessage(activity.getResources().getString(R.string.loading));
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);

        }
        dialog.show();
    }


    public static void hideLoader() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            dialog = null;
        }
    }

    public static void showOKMessageandBack(String message, final Context activity, final Class activityClass) {
        builder = new AlertDialog.Builder(activity);
        if (message.length() <= 0)
            builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                alert.hide();
                hideLoader();
                Intent intent = new Intent(activity, activityClass);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                activity.startActivity(intent);
            }
        });
        alert = builder.create();
        alert.show();
    }


    public static void showAlertDialog(final Context context , String title , String message  ){

        final AlertDialog alertDialog = new AlertDialog.Builder(context).create();

        // setting Dialog title
        alertDialog.setTitle(title);

        // setting Dialog message
        alertDialog.setMessage(message);

        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });

        alertDialog.show();

    }
}

