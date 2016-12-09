package com.hardikgoswami.githubmetrics.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by geniushkg on 12/9/2016.
 */

public interface GithubService {
    @GET("users/{user}/repos")
    Call<List<UserRepo>> listRepos(@Path("user") String user);

    @GET("users/{user}")
    Call<User> getUserPersonalData(@Path("user") String user);

}
