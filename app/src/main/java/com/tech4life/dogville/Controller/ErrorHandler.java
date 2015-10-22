package com.tech4life.dogville.Controller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Window;

import com.tech4life.dogville.Controller.Constants.AppConstants;
import com.tech4life.dogville.R;

/**
 * Created by karma on 18/03/2015.
 */
public class ErrorHandler extends MainControl{
    private AlertDialog.Builder builder;
    private AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//         setContentView(R.layout.dialog_notification_message);
//         TextView messaget = (TextView)findViewById(R.id.message);
          String messageText = getIntent()
                .getStringExtra(AppConstants.MESSAGE);

        builder = new AlertDialog.Builder(this);
        builder.setMessage(messageText);
        builder.setPositiveButton(getResources().getString(R.string.OK),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Utils.hideLoader();
                        finish();
                    }
                });
        alert = builder.create();
        alert.show();
    }

}
