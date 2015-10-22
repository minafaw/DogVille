package com.tech4life.dogville.Controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NT on 10/15/15.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {


    private List<String> tabTitles = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);


    }

    public void addFrag(Fragment fra, String title) {
        mFragmentList.add(fra);
        tabTitles.add(title);
    }


    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return tabTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);

    }
}
