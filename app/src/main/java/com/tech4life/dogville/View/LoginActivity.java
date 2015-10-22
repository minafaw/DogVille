package com.tech4life.dogville.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.tech4life.dogville.Controller.MainControl;
import com.tech4life.dogville.Controller.Utils;
import com.tech4life.dogville.Interfaces.VolleyResponeCallBack;
import com.tech4life.dogville.R;
import com.tech4life.dogville.webservice.VolleyRequestHandler;
import com.tech4life.dogville.webservice.data.LoginResponse;
import com.tech4life.dogville.webservice.data.RegistrationRequest;
import com.tech4life.dogville.Controller.Constants.AppConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by karma on 18/05/2015.
 */

public class LoginActivity extends MainControl implements VolleyResponeCallBack {

    // login views
    private EditText usernameET;
    private EditText passwordET;
    private LoginButton loginButton;

    public static Handler operationHandler;
    private LoginResponse loginResponse;
    private RegistrationRequest registrationRequest = new RegistrationRequest();

    // facebook login variables
    private AccessTokenTracker accessTokenTracker;
    private ProfileTracker profileTracker;
    private CallbackManager callbackManager;

    private VolleyRequestHandler _VolleyRequestHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // facebook methods
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                updateWithToken(currentAccessToken);
            }
        };


        setContentView(R.layout.activity_sign_in);
       _VolleyRequestHandler = new VolleyRequestHandler(this);
        initialize();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

    }

    private void updateWithToken(final AccessToken currentAccessToken) {
        //start next activity if user is already logged in
        if (currentAccessToken != null) {
            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
            Utils.hideLoader();
            startActivity(i);
            finish();
        }
    }

    private void initialize() {

        usernameET = (EditText) findViewById(R.id.username_et);
        passwordET = (EditText) findViewById(R.id.password_et);

        loginButton = (LoginButton) findViewById(R.id.facebook_btn);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Profile profile = Profile.getCurrentProfile();
                if (profile != null) {
//                    registrationRequest.setPassword(profile.getId());
//                    registrationRequest.setUserName(profile.getName());
//                    registrationRequest.setEmail(profile.getFirstName());

                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);

                }

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException e) {

            }
        });
        loginButton.setText("");
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.fullview);

        HideKeyboardFromView(relativeLayout);

    }



    public void go_ActionHandler(View v) {

        String sUserName = usernameET.getText().toString();
        String sPassword = passwordET.getText().toString();

        if (sUserName.isEmpty() || sPassword.isEmpty()) {
            Utils.showAlertDialog(this, AppConstants.ALERT, AppConstants.EMPTY_MESSAGE);
        } else {
            Utils.showLoader(LoginActivity.this);
            get_user_data(sUserName , sPassword);
//            Intent intent = new Intent(LoginActivity.this, LoginService.class);
//            intent.putExtra(AppConstants.USERNAME, sUserName);
//            intent.putExtra(AppConstants.PASSWORD, sPassword);
//
//            startService(intent);

        }
    }

    public void forget_ActionHandler(View v) {
        Intent intent = new Intent(LoginActivity.this, ForgetPassword.class);
        startActivity(intent);
    }

    public void signUp_ActionHandler(View v) {
        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(intent);

    }

    public void facebook_ActionHandler(View v) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }

    private void get_user_data(String user_name , String pass){
        Map<String , String> params = new HashMap<>();
        params.put(AppConstants.USERNAME ,user_name );
        params.put(AppConstants.PASSWORD, pass);

        _VolleyRequestHandler.HandleRequests(VolleyRequestHandler.LOGIN_INT, params, this);
    }


    @Override
    public void RequestSuccess(Object response) {
        Utils.hideLoader();
        Toast.makeText(this, "response is " + response ,Toast.LENGTH_LONG).show();
        navigateToHome();

    }

    @Override
    public void RequestFailed(String error) {
        Utils.hideLoader();
        Toast.makeText(this, error ,Toast.LENGTH_LONG).show();
        navigateToHome();
    }

    private void navigateToHome(){
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
    }


    public void hideSoftKeyboard(View act) {
        InputMethodManager mInputMange = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        mInputMange.hideSoftInputFromWindow(act
                .getWindowToken(), 0);

    }

    public void HideKeyboardFromView(View view) {
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(v);
                    return false;
                }
            });
        }
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                HideKeyboardFromView(innerView);
            }
        }

    }
}
