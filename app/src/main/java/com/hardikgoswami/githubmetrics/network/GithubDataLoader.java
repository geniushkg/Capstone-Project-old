package com.hardikgoswami.githubmetrics.network;

import android.content.AsyncTaskLoader;
import android.content.Context;

/**
 * Created by geniushkg on 12/9/2016.
 */

public class GithubDataLoader extends AsyncTaskLoader<UserData> {

    public GithubDataLoader(Context context) {
        super(context);
    }

    @Override
    public UserData loadInBackground() {
        return null;
    }
}
