package com.hardikgoswami.bettersleep.Data.Source.Remote;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SyncResult;
import android.database.Cursor;
import android.os.Bundle;

import com.hardikgoswami.bettersleep.Data.Source.Local.SleepDebtContract;
import com.hardikgoswami.bettersleep.Data.Source.SleepDataRepository;

import static com.hardikgoswami.bettersleep.Data.Source.Remote.ApiHelper.TAG;

/**
 * Created by geniushkg on 10/11/2016.
 */

public class SyncAdapter extends AbstractThreadedSyncAdapter {

    private static final String PREFS_KEY = "EMAIL";
    ContentResolver mContentResolver;
    SharedPreferences setting;
    String userEmail;
    Context mContext;

    public SyncAdapter(Context context, boolean autoInitialize, ContentResolver mContentResolver) {
        super(context, autoInitialize);
        mContentResolver = context.getContentResolver();
        setting = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        userEmail = setting.getString(PREFS_KEY, null);
        mContext = context;
    }

    public SyncAdapter(Context context, boolean autoInitialize, boolean allowParallelSyncs, ContentResolver mContentResolver) {
        super(context, autoInitialize, allowParallelSyncs);
        mContentResolver = context.getContentResolver();
        setting = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        userEmail = setting.getString(PREFS_KEY, null);
        mContext = context;
    }

    @Override
    public void onPerformSync(Account account,
                              Bundle extras,
                              String authority,
                              ContentProviderClient provider,
                              SyncResult syncResult) {


        int currentDebtOnServer = 0;
        currentDebtOnServer = ApiHelper.getUserDebtFromId(userEmail);

        ContentResolver resolver = mContext.getContentResolver();
        String[] projection = new String[]{SleepDebtContract.INT_DEBT_HOURS};
        Cursor cursor =
                resolver.query(SleepDebtContract.CONTENT_URI,
                        projection,
                        null,
                        null,
                        null);
        int currentDebtLocal = 0;
        if(cursor != null){
            currentDebtLocal = cursor.getInt(0);
        }

        // TODO: 10/12/2016 if local data does not exist overrite local data by remote fetched data

        if(currentDebtLocal == 0 ){
            SleepDataRepository sleepRepo = new SleepDataRepository(mContext);
            sleepRepo.modifyDebt(currentDebtOnServer,true);
        }

        // TODO: 10/12/2016 if data in local exist and remote != local ,then update to remote server

        if (currentDebtLocal != currentDebtOnServer){
            ApiHelper.newUserWithId(userEmail,currentDebtLocal);
        }

    }
}
