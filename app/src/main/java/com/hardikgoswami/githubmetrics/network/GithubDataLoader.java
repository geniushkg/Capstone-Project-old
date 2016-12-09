package com.hardikgoswami.githubmetrics.network;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

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
    }


    @Override
    public UserData loadInBackground() {
        data = new UserData();

        //fetch personal details
        Call<User> githubUser = service.getUserPersonalData(username);
        User fetchedUser = new User();
        try {
            fetchedUser = githubUser.execute().body();
        } catch (IOException exp) {
            Log.d(TAG, "loadInBackground: " + exp.getMessage());
        }

        // model it for ui
        String location = fetchedUser.getLocation();
        String bio = fetchedUser.getBio();
        String imageUrl = fetchedUser.getAvatar_url();
        String email = fetchedUser.getEmail();
        int followers = fetchedUser.getFollowers();

        if (location!=null) data.setLocation(location);
        if (bio!=null) data.setBio(bio);
        if (imageUrl!=null) data.setImageUrl(imageUrl);
        if (email!=null) data.setEmail(email);
        if (followers >= 0) data.setFollowers(followers);

        // fetch users repo data
        Call<List<UserRepo>> userRepolistcall = service.listRepos(username);
        List<UserRepo> repoList = new ArrayList<UserRepo>();
                try {
                    repoList = userRepolistcall.execute().body();
                }catch (IOException exp){
                    Log.d(TAG, "loadInBackground: "+exp.getMessage());
                }

        //model it for ui
        List<Contribution> contributionList = new ArrayList<Contribution>();
        for (UserRepo each:repoList){
            contributionList.add(new Contribution(each.getFull_name(),each.getStargazers_count(),each.getFork()));
        }
        if (contributionList.size()>0) data.setRepoList(contributionList);

        //// TODO: 12/9/2016 algorith in core calculate rating and set rating 

        return data;
    }
}
