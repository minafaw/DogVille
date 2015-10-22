package com.tech4life.dogville.Controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import com.tech4life.dogville.Controller.Constants.AppConstants;
import com.tech4life.dogville.R;

public class MainControl extends Activity {

    public static  boolean CONNECT = false;

    public void showErrorMessage (String message)
    {
        Intent intent = new Intent(MainControl.this, ErrorHandler.class);
        //intent.putExtra(UIConstants.TYPE , UIConstants.ERROR_NOTIFICATION_DIALOG);
        intent.putExtra(AppConstants.ERROR_LOADING,message);
        //intent.putExtra(UIConstants.ICON, R.drawable.error_icon);
        startActivity(intent);
    }

    public void showOKMessage (Context context,String title , String message)
    {
//			showOKMessage(context,title, message , R.drawable.info_icon2);
    }


    public void showFillFieldsAlert (Context context)
    {

        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setMessage(R.string.fillfields);
        //   builder.setTitle(title);

        builder.setPositiveButton(context.getResources().getString(R.string.OK), new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // Do nothing but close the dialog
                dialog.dismiss();

            }

        });

        AlertDialog alert = builder.create();
        alert.show();
    }


    public void showFillFieldsAlert (Context context,String message)
    {

        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setMessage(message);
        //   builder.setTitle(title);

        builder.setPositiveButton(context.getResources().getString(R.string.OK), new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // Do nothing but close the dialog
                dialog.dismiss();

            }

        });

        AlertDialog alert = builder.create();
        alert.show();

    }


    public void showOKMessage (Context context ,String title , String message , int iconId)
    {

        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setMessage(message);
        //   builder.setTitle(title);

        builder.setPositiveButton(context.getResources().getString(R.string.OK), new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // Do nothing but close the dialog
                Utils.hideLoader();
                dialog.dismiss();

            }

        });

        AlertDialog alert = builder.create();
        alert.show();

    }

}


