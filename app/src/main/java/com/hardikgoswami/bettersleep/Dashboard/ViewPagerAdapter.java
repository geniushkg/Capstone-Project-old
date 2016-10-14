package com.hardikgoswami.bettersleep.Dashboard;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import com.hardikgoswami.bettersleep.SleepPattern.SleepPatternFragment;
import com.hardikgoswami.bettersleep.SleepPunch.SleepPunchFragment;
import com.hardikgoswami.bettersleep.Yognidra.YognidraFragment;


/**
 * Created by geniushkg on 9/21/2016.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = "BETTERSLEEP";
    private static int NUM_ITEMS = 3;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public Fragment mCurrentFragment;

    public Fragment getCurrentFragment() {
        return mCurrentFragment;
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
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (mCurrentFragment != object) {
            mCurrentFragment = (Fragment) object;
        }
        Log.d(TAG,"primary item set");
        super.setPrimaryItem(container, position, object);

    }

    @Override
    public int getCount() {
        return NUM_ITEMS;

    }

    @Override
    public CharSequence getPageTitle(int position) {
        super.getPageTitle(position);
        String PageHeader = "Tab Heading";
        switch (position) {
            case 0:
                PageHeader = "PunchIn";
                break;
            case 1:
                PageHeader = "Yognidra";
                break;
            case 2:
                PageHeader = "Pattern";
                break;
            default:
                break;
        }
        return PageHeader;
    }
}
