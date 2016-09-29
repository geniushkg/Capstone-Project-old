package com.hardikgoswami.bettersleep.SleepCycleCore;

import android.text.format.Time;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geniushkg on 9/27/2016.
 */
public class SleepCycleCalculator {
    Time currentTime;

    public SleepCycleCalculator(Time currentTime) {
        this.currentTime = currentTime;
    }

    /**
     * returns list of alarm times to wake up based on current time calculated sleep cycles
     */
    public static List<Time> getAlarmTimeList() {
        List<Time> sleepCycleList = new ArrayList<Time>();
        // TODO : add current time variable then calculate list of 5 upcoming sleepcycle and return as list.

        return sleepCycleList;
    }
}
