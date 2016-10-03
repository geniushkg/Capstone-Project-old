package com.hardikgoswami.bettersleep.Data.Source;

import android.content.AsyncTaskLoader;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;

import com.hardikgoswami.bettersleep.Data.Source.Local.Debt;
import com.hardikgoswami.bettersleep.Data.Source.Local.SleepDebtContract;

/**
 * Created by geniushkg on 9/28/2016.
 */
public class DebtTimeLoader extends AsyncTaskLoader<Debt> {
    Debt mDebt;
    public DebtTimeLoader(Context context) {
        super(context);
    }

    @Override
    public Debt loadInBackground() {
        ContentResolver resolver = getContext().getContentResolver();
        String[] projection = new String[]{SleepDebtContract.INT_DEBT_HOURS};
        Cursor cursor =
                resolver.query(SleepDebtContract.CONTENT_URI,
                        projection,
                        null,
                        null,
                        null);
        int currentDebt = 0;
        if(cursor != null){
            currentDebt = cursor.getInt(0);
        }
        mDebt = new Debt(currentDebt);
        return mDebt;
    }

}
