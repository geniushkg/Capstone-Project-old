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
        switch (position){
            case 0:
                return SleepPunchFragment.newInstance();
            case 1:
                return YognidraFragment.newInstance();
            case 2:
                return SleepPatternFragment.newInstance();
            default:
                return  null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
