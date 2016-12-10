package com.hardikgoswami.githubmetrics.core;

import android.util.Log;

import com.hardikgoswami.githubmetrics.network.Contribution;
import com.hardikgoswami.githubmetrics.network.UserData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by geniushkg on 12/9/2016.
 */

public class RatingAlgo {
    public static int followerCount = 0;// range from 0 to 5;
    public static int repoCountScore = 0;// range from 0 to 10;
    public static final String TAG = "GithubMetrics";
    public RatingAlgo() {
    }

    /***
     * This method will rate developer profile on scale of five
     *
     * @param userData - data fetched from github api
     * @return - float from 1 to 5 ;
     */
    public static float generateRatingFor(UserData userData) {
        // rating = (followerCount + repoCountScore)/3

        // define follower count
        if (isBetween(userData.getFollowers(), 0, 1)) {
            followerCount = 1;
        } else if (isBetween(userData.getFollowers(), 2, 10)) {
            followerCount = 2;
        } else if (isBetween(userData.getFollowers(), 11, 25)) {
            followerCount = 3;
        } else if (isBetween(userData.getFollowers(), 26, 75)) {
            followerCount = 4;
        } else {
            followerCount = 5;
        }

        List<Contribution> repoList = new ArrayList<Contribution>();
        List<Integer> repoStars = new ArrayList<Integer>();
        // define repoCountScore
        if (userData.getRepoList() != null) {
            repoList = userData.getRepoList();
        }

        for (Contribution eachRepo : repoList){
            repoStars.add(eachRepo.getStars());
        }

        Collections.sort(repoStars);
        Collections.reverse(repoStars);
        int maxStars = repoStars.get(0);
        if (isBetween(maxStars,0,49)){
            repoCountScore = 2;
        }else if (isBetween(maxStars,50,99)){
            repoCountScore = 4;
        }else if (isBetween(maxStars,100,499)){
            repoCountScore = 6;
        }else {
            repoCountScore = 10;
        }

        float rating = 0f;
        rating = (followerCount + repoCountScore)/3;
        Log.d(TAG, "generateRatingFor: "+rating);
        return rating;
    }

    public static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }
}
