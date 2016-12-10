package com.hardikgoswami.githubmetrics.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import com.tjeannin.provigen.ProviGenBaseContract;
import com.tjeannin.provigen.ProviGenOpenHelper;
import com.tjeannin.provigen.ProviGenProvider;

import static java.security.AccessController.getContext;

/**
 * Created by geniushkg on 12/10/2016.
 */

public class HistoryProvider extends ProviGenProvider {

    private static Class[] contracts = new Class[]{HistoryContract.class};

    @Override
    public SQLiteOpenHelper openHelper(Context context) {
        return new ProviGenOpenHelper(getContext(), "githubmetrics", null, 1, contracts);
    }

    @Override
    public Class[] contractClasses() {
        return contracts;
    }

}
