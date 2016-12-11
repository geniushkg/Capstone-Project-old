package com.hardikgoswami.githubmetrics.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by geniushkg on 12/9/2016.
 */

public interface GithubService {

    @GET("users/{user}/repos")
    Call<List<UserRepo>> listRepos(@Path("user") String user);

    @GET("users/{user}")
    Call<User> getUserPersonalData(@Path("user") String user);

    @GET("user")
    Call<String> getUser(@Header("Authorization") String authorization);

}
