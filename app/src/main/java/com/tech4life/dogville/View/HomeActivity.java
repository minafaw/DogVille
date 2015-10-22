package com.tech4life.dogville.View;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toolbar;

import com.tech4life.dogville.Controller.ViewPagerAdapter;
import com.tech4life.dogville.R;

/**
 * Created by karma on 19/05/2015.
 */

public class HomeActivity extends AppCompatActivity {

    private TabLayout _tabLayout;
    private ViewPager _ViewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        _ViewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(_ViewPager);

        _tabLayout = (TabLayout) findViewById(R.id.tabs);
        _tabLayout.setupWithViewPager(_ViewPager);


    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new HomeFragment() ,  "Home" );
        adapter.addFrag(new PuppyFragment(), "Puppy" );
        adapter.addFrag(new ProductFragment() , "Product" );
        adapter.addFrag(new TipsFragment() , "Tips" );
        adapter.addFrag(new AccountFragment() , "Account" );

        viewPager.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    public void addProduct_ActionHandler(View v) {
        DetailsFragment.addProduct_ActionHandler();
    }


    private void setTabLayout() {


    }
}
