package com.hardikgoswami.githubmetrics.util;

import android.util.Log;

import com.hardikgoswami.githubmetrics.network.Contribution;

import java.util.Comparator;

import static com.hardikgoswami.githubmetrics.network.GithubDataLoader.TAG;

/**
 * Created by geniushkg on 12/9/2016.
 */

public class StarsSorter implements Comparator<Contribution> {
    @Override
    public int compare(Contribution lhs, Contribution rhs) {
        int returnValue = 0;

        if (lhs.getStars() < rhs.getStars()){
            returnValue = -1;
        }else if (lhs.getStars() > rhs.getStars()){
            returnValue = 1;
        }else {
            returnValue = 0;
        }
        Log.d(TAG, "compare: collection sorting");
        return returnValue;
    }
}
