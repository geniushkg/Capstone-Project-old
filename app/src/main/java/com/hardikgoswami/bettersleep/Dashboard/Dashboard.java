package com.hardikgoswami.bettersleep.Dashboard;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.hardikgoswami.bettersleep.R;

public class Dashboard extends AppCompatActivity {
public static final String TAG ="BETTERSLEEP";
    ViewPagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_act);

        // setup  toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        // setup viewpager
        ViewPager viewPager = (ViewPager) findViewById(R.id.vpPager);
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        Log.d(TAG,"Dashboard activity");
    }

}
