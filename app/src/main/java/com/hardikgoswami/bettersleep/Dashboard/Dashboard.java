package com.hardikgoswami.bettersleep.Dashboard;

import android.os.Handler;
import android.support.v4.app.LoaderManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.hardikgoswami.bettersleep.Data.Source.SleepDataRepository;
import com.hardikgoswami.bettersleep.R;
import com.hardikgoswami.bettersleep.SleepPunch.SleepPunchContract;
import com.hardikgoswami.bettersleep.SleepPunch.SleepPunchPresenter;

public class Dashboard extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    public static final String TAG = "BETTERSLEEP";
    private Boolean exit = false;
    ViewPagerAdapter pagerAdapter;
    LoaderManager loaderManager;
    SleepDataRepository dataRepository;
    SleepPunchContract.Presenter presenter;

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
        viewPager.setOnPageChangeListener(this);
        PagerSlidingTabStrip pagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        pagerSlidingTabStrip.setViewPager(viewPager);
        Log.d(TAG, "Dashboard activity");
        // setup loadermanager
        loaderManager = getSupportLoaderManager();
        // setup SleepData Repository
        dataRepository = new SleepDataRepository(this);
        // TODO: Setup Presenter for sleeppunch
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

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Toast.makeText(this,"pos is :"+position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
