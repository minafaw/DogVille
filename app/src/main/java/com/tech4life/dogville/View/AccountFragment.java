package com.tech4life.dogville.View;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tech4life.dogville.R;

/**
 * Created by karma on 18/05/2015.
 */
public class AccountFragment extends Fragment {

public AccountFragment(){

}
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_account,null);
        return rootView;

    }
}