package com.hardikgoswami.bettersleep.Dashboard;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.hardikgoswami.bettersleep.R;

public class Dashboard extends AppCompatActivity {
    public static final String TAG = "BETTERSLEEP";
    private Boolean exit = false;
    ViewPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_act);
        // setup  toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setup viewpager & header strip
        ViewPager viewPager = (ViewPager) findViewById(R.id.vpPager);
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        Log.d(TAG, "Dashboard activity");

    }


    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }

    }

}
