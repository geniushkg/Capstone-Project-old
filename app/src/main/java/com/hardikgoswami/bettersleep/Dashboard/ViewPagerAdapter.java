package com.hardikgoswami.bettersleep.Dashboard;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hardikgoswami.bettersleep.SleepPattern.SleepPatternFragment;
import com.hardikgoswami.bettersleep.SleepPunch.SleepPunchFragment;
import com.hardikgoswami.bettersleep.Yognidra.YognidraFragment;

/**
 * Created by geniushkg on 9/21/2016.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return SleepPunchFragment.newInstance(0, "Page # 1");
            case 1:
                return YognidraFragment.newInstance(1, "Page # 2");
            case 2:
                return SleepPatternFragment.newInstance(2, "Page # 3");
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;

    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page : " + position;
    }


}
