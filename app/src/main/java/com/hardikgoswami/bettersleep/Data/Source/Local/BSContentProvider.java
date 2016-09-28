package com.hardikgoswami.bettersleep.Data.Source.Local;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import com.tjeannin.provigen.ProviGenOpenHelper;
import com.tjeannin.provigen.ProviGenProvider;

/**
 * Created by geniushkg on 9/28/2016.
 */
public class BSContentProvider extends ProviGenProvider {

    private static Class[] contracts = new Class[]{SleepHistoryContract.class,SleepDebtContract.class};

    @Override
    public SQLiteOpenHelper openHelper(Context context) {
        return new ProviGenOpenHelper(getContext(), "bs_db", null, 1, contracts);
    }

    @Override
    public Class[] contractClasses() {
        return contracts;
    }
}