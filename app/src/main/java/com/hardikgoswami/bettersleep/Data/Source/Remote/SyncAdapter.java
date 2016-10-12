package com.hardikgoswami.bettersleep.Data.Source.Remote;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;

/**
 * Created by geniushkg on 10/11/2016.
 */

public class SyncAdapter extends AbstractThreadedSyncAdapter {

    ContentResolver mContentResolver;

    public SyncAdapter(Context context, boolean autoInitialize, ContentResolver mContentResolver) {
        super(context, autoInitialize);
        mContentResolver = context.getContentResolver();
    }

    public SyncAdapter(Context context, boolean autoInitialize, boolean allowParallelSyncs, ContentResolver mContentResolver) {
        super(context, autoInitialize, allowParallelSyncs);
        mContentResolver = context.getContentResolver();
    }

    @Override
    public void onPerformSync(Account account,
                              Bundle extras,
                              String authority,
                              ContentProviderClient provider,
                              SyncResult syncResult) {
        // TODO: 10/12/2016 get debt from remote server 


        // TODO: 10/12/2016 get debt from local server  

        // TODO: 10/12/2016 if local data does not exist overrite local data by remote fetched data 

        // TODO: 10/12/2016 if data in local exist and remote != local ,then update to remote server 
    }
}
