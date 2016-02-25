package com.android.app.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.app.smartdiscovery.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * Created by gkamara on 2/23/2016.
 */
public class LoginFragment extends Fragment {

    CallbackManager callbackManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        LoginButton loginButton;

        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.fragment_login, null);

        loginButton = (LoginButton) view.findViewById(R.id.facebook_login);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.e("LoginFragment", loginResult.getAccessToken().getUserId() + " --Check-- " + loginResult.getAccessToken().getToken());
            }

            @Override
            public void onCancel() {
                Log.e("LoginFragment", "Login attempt cancelled");
            }

            @Override
            public void onError(FacebookException error) {
                Log.e("LoginFragment", "Login attempt failed");
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        Log.e("LoginFragment", "Check here");
    }
}
