package com.tech4life.dogville.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.tech4life.dogville.Controller.Utils;
import com.tech4life.dogville.Interfaces.VolleyResponeCallBack;
import com.tech4life.dogville.Model.UsersModel;
import com.tech4life.dogville.R;
import com.tech4life.dogville.webservice.MySingleton;
import com.tech4life.dogville.webservice.VolleyRequestHandler;
import com.tech4life.dogville.webservice.data.RegistrationResponse;
import com.tech4life.dogville.Controller.Constants.AppConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by karma on 18/05/2015.
 */
public class SignUpActivity extends Activity implements VolleyResponeCallBack {

    private TextView signup_TV;
    private TextView signupnow_TV;
    private EditText username_ET;
    private EditText email_ET;
    private EditText phoneNumber_ET;
    private EditText password_ET;
    public static Handler operationHandler;
    private ImageButton arrowBack;
    private VolleyRequestHandler _VolleyRequestHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        _VolleyRequestHandler = new VolleyRequestHandler(this);
        initialize();
        setHandlerAction();

    }


    private void initialize() {

        signup_TV = (TextView) findViewById(R.id.title_tv);
        signupnow_TV = (TextView) findViewById(R.id.signUp_tv);
        username_ET = (EditText) findViewById(R.id.username_et);
        email_ET = (EditText) findViewById(R.id.email_et);
        phoneNumber_ET = (EditText) findViewById(R.id.phonenumber_et);
        password_ET = (EditText) findViewById(R.id.password_et);
        arrowBack = (ImageButton) findViewById(R.id.nav_back);
        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }


    private void setHandlerAction() {
        operationHandler = new Handler() {
            public void handleMessage(Message msg) {
                Utils.hideLoader();
                RegistrationResponse response = (RegistrationResponse) msg.obj;
                if (response.getIsSuccessful()) {
                    Toast.makeText(getBaseContext(), response.getResultString(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getBaseContext(), response.getResultString(), Toast.LENGTH_SHORT).show();
                }
            }
        };

    }


    public void signUpMe_ActionHandler(View v) {

        String userName = username_ET.getText().toString();
        String password = password_ET.getText().toString();
        String phone = phoneNumber_ET.getText().toString();
        String email = email_ET.getText().toString();

        if (isValid()) {

            Utils.showLoader(SignUpActivity.this);
            UsersModel user = new UsersModel(userName, password, phone, email);

            register_user(user);
//            Intent intent = new Intent(SignUpActivity.this, RegistrationService.class);
//            intent.putExtra(AppConstants.USERNAME, userName);
//            intent.putExtra(AppConstants.PASSWORD, password);
//            intent.putExtra(AppConstants.REGISTRATION_EMAIL, email);
//            intent.putExtra(AppConstants.REGISTRATION_PHONE, phone);
//
//            startService(intent);
        }

    }

    private boolean isValid() {
        boolean valid = true;
        String userName = username_ET.getText().toString();
        String password = password_ET.getText().toString();
        String phone = phoneNumber_ET.getText().toString();
        String email = email_ET.getText().toString();

        if (userName.isEmpty()) {
            username_ET.setError(AppConstants.EMPTY_FIELD);
            valid = false;
        } else {
            username_ET.setError(null);
        }

        if (password.isEmpty()) {
            password_ET.setError(AppConstants.EMPTY_FIELD);
            valid = false;
        } else {
            password_ET.setError(null);
        }

        if (phone.isEmpty()) {
            phoneNumber_ET.setError(AppConstants.EMPTY_FIELD);
            valid = false;
        } else {
            phoneNumber_ET.setError(null);
        }

        if (email.isEmpty()) {
            email_ET.setError(AppConstants.EMPTY_FIELD);
            valid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            email_ET.setError(AppConstants.INVALID_EMAIL);
            valid = false;
        } else {
            email_ET.setError(null);
        }
        return valid;
    }


    private void register_user(UsersModel usersModel) {
        Map<String, String> params = new HashMap<>();
        params.put(AppConstants.USERNAME, usersModel.getUsername());
        params.put(AppConstants.PASSWORD, usersModel.getPassword());
        params.put(AppConstants.REGISTRATION_EMAIL, usersModel.getEmail());
        params.put(AppConstants.REGISTRATION_PHONE, usersModel.getPhone());

        _VolleyRequestHandler.HandleRequests(VolleyRequestHandler.SINGUP_INT, params, this);

    }

    @Override
    public void RequestSuccess(Object response) {
        Utils.hideLoader();
        Toast.makeText(this, "response " + response, Toast.LENGTH_LONG).show();
    }

    @Override
    public void RequestFailed(String error) {
        Utils.hideLoader();
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}
