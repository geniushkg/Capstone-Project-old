package com.hardikgoswami.githubmetrics.persistence;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static com.hardikgoswami.githubmetrics.network.GithubDataLoader.TAG;

/**
 * Created by geniushkg on 12/10/2016.
 */

public class HistoryLoader extends AsyncTaskLoader<List<UserHistory>> {
    List<UserHistory> userHistoryList;
    Context mContext;

    public HistoryLoader(Context context) {
        super(context);
        userHistoryList = new ArrayList<>();
        mContext = context;
    }

    @Override
    public List<UserHistory> loadInBackground() {
        if (userHistoryList.size()>0)userHistoryList.clear();
        Cursor c = mContext.getContentResolver().query(HistoryContract.CONTENT_URI,null,null,null," '_id' ASC ");
        if (c.getCount()>0){
            if (c.moveToFirst()){
             do{
                 UserHistory user = new UserHistory();
                 user.setEmail(c.getString(c.getColumnIndex("email")));
                 user.setUsername(c.getString(c.getColumnIndex("username")));
                 user.setRating(c.getFloat(c.getColumnIndex("rating")));
                 user.setId(c.getInt(c.getColumnIndex("_id")));
                 userHistoryList.add(user);
             }while (c.moveToNext());
            }
        }
        return userHistoryList;
    }

    @Override
    public void deliverResult(List<UserHistory> data) {
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
        if (userHistoryList != null){
            userHistoryList = null;
        }
    }

}
