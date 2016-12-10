package com.hardikgoswami.githubmetrics.util;

import android.util.Log;

import com.hardikgoswami.githubmetrics.persistence.UserHistory;

import java.util.Comparator;

import static com.hardikgoswami.githubmetrics.network.GithubDataLoader.TAG;

/**
 * Created by geniushkg on 12/10/2016.
 */

public class IdSorter implements Comparator<UserHistory> {
    @Override
    public int compare(UserHistory lhs, UserHistory rhs) {
        int result = 0;
        if (lhs.getId() < rhs.getId()) {
            result = -1;
        } else if (lhs.getId() > rhs.getId()) {
            result = 1;
        } else {
            result = 0;
        }

        Log.d(TAG, "compare: collection sorting");
        return result;
    }
}
