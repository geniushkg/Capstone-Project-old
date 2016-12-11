package com.hardikgoswami.githubmetrics.network;


import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import android.widget.Toast;

import com.hardikgoswami.githubmetrics.core.RatingAlgo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by geniushkg on 12/9/2016.
 */

public class GithubDataLoader extends AsyncTaskLoader<UserData> {

    public static final String BASE_URL = "https://api.github.com/";
    private UserData data;
    private Context mContext;
    private Retrofit retrofit;
    private GithubService service;
    private String username;
    private boolean isValid = false;

    public static final String TAG = "GithubMetrics";

    public GithubDataLoader(Context context, String username) {
        super(context);
        mContext = context;
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(GithubService.class);
        this.username = username;
        Log.d(TAG, "GithubDataLoader: init done");
    }


    @Override
    public UserData loadInBackground() {
        Log.d(TAG, "loadInBackground: started");
        data = new UserData();
        //fetch personal details
        Call<User> githubUser = service.getUserPersonalData(username);
        User fetchedUser = new User();
        try {
            fetchedUser = githubUser.execute().body();
            if (fetchedUser == null) {
                isValid = false;
            } else {
                isValid = true;
                Log.d(TAG, "loadInBackground: fetched user : " + fetchedUser.getEmail());
            }
        } catch (IOException exp) {
            Log.d(TAG, "loadInBackground: " + exp.getMessage());
        }
        if (isValid) {


            // model it for ui
            String location = fetchedUser.getLocation();
            String bio = fetchedUser.getBio();
            String imageUrl = fetchedUser.getAvatar_url();
            String email = fetchedUser.getEmail();
            int followers = fetchedUser.getFollowers();
            int invallidUserIfZero = 0;
            invallidUserIfZero = fetchedUser.getId();
            if (invallidUserIfZero < 1) {
                data.setValid(false);
            } else {
                data.setValid(true);
                if (location != null) {
                    data.setLocation(location);
                } else {
                    data.setLocation("Locaion not found");
                }
                if (bio != null) {
                    data.setBio(bio);
                } else {
                    data.setBio("Bio not found");
                }
                if (imageUrl != null) {
                    data.setImageUrl(imageUrl);
                } else {
                    data.setImageUrl("");
                }
                if (email != null) {
                    data.setEmail(email);
                } else {
                    data.setEmail("Email not found");
                }
                if (followers >= 0) {
                    data.setFollowers(followers);
                } else {
                    data.setFollowers(0);
                }


                // fetch users repo data
                Call<List<UserRepo>> userRepolistcall = service.listRepos(username);
                List<UserRepo> repoList = new ArrayList<UserRepo>();
                try {
                    repoList = userRepolistcall.execute().body();
                    Log.d(TAG, "loadInBackground: userrepolist size :" + repoList.size());
                } catch (IOException exp) {
                    Log.d(TAG, "loadInBackground: " + exp.getMessage());
                    Toast.makeText(mContext, "Invalid user : " + exp.getMessage(), Toast.LENGTH_SHORT).show();
                }

                //model it for ui
                List<Contribution> contributionList = new ArrayList<Contribution>();
                if (!contributionList.isEmpty()) {
                    contributionList.clear();
                }
                for (UserRepo each : repoList) {
                    Log.d(TAG, "loadInBackground: each repo :" + each.getFull_name() +
                            " - Stars :" + each.getStargazers_count() +
                            " - forked :" + each.getFork());
                    contributionList.add(new Contribution(each.getFull_name(),
                            each.getStargazers_count(),
                            each.getFork()));
                }
                if (contributionList.size() > 0) {
                    data.setRepoList(contributionList);
                    Log.d(TAG, "loadInBackground: contribution list repo size : " + data.getRepoList().size());
                } else {
                    Log.d(TAG, "loadInBackground: repolist size 0");
                }

                float rating = RatingAlgo.generateRatingFor(data);
                if (rating > 0) {
                    data.setRating(rating);
                    Log.d(TAG, "loadInBackground: rating to set id :" + rating);
                } else {
                    data.setRating(1f);
                }
                Log.d(TAG, "loadInBackground: rating is :" + rating);

            }
        } else {
            data.setValid(false);
            Log.d(TAG, "loadInBackground: null user");
        }
        return data;
    }

    @Override
    public void deliverResult(UserData data) {
        super.deliverResult(data);
        Log.d(TAG, "deliverResult: done");
    }

    @Override
    protected void onStopLoading() {
        super.onStopLoading();
        cancelLoad();
    }

    @Override
    protected void onReset() {
        super.onReset();
        onStopLoading();
        if (data != null) {
            data = null;
        }
    }
}
