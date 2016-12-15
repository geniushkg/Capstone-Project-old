package com.hardikgoswami.githubmetrics.network;

import android.util.Log;

import java.io.IOException;
import java.util.logging.Logger;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static com.hardikgoswami.githubmetrics.network.GithubDataLoader.TAG;

/**
 * Created by geniushkg on 12/12/2016.
 */
public class LoggingInterceptor implements Interceptor {
    @Override public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();

        long t1 = System.nanoTime();

        Log.d(TAG, "intercept: okhttp : sending request to : "+request.url()
            + " on "+ chain.connection()+ " - " +request.headers());
        Response response = chain.proceed(request);


        return response;
    }
}
