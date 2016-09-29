package com.hardikgoswami.bettersleep.Util;

import android.app.Activity;
import android.support.v4.view.ViewPager;

/**
 * Created by geniushkg on 9/27/2016.
 */
public class ActivityUtils {
    /**
     * @param pageNumber pagenumber of fragment to which we need to swipe
     * @param viewPager  Viewpager in which operation will be performed
     */
    public static void swipeViewPagerTo(int pageNumber, ViewPager viewPager) {
        viewPager.setCurrentItem(pageNumber);
    }
}
