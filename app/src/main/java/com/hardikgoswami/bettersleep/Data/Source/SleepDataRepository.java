package com.hardikgoswami.bettersleep.Data.Source;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.widget.Toast;

import com.hardikgoswami.bettersleep.Data.Source.Local.SleepDebtContract;
import com.hardikgoswami.bettersleep.Data.Source.Local.SleepHistoryContract;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by geniushkg on 9/28/2016.
 */
public class SleepDataRepository {
    private Context mContext;

    public SleepDataRepository(Context mContext) {
        this.mContext = mContext;
    }

    public void addHours(int hours) {
        // TODO: save hours and get current date and store it to db


        // get current date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());

        ContentValues contentValues = new ContentValues();
        contentValues.put(SleepHistoryContract.INT_HOURS, hours);
        contentValues.put(SleepHistoryContract.STRING_DATE, date);
        // insert data
        mContext.getContentResolver().insert(SleepHistoryContract.CONTENT_URI, contentValues);

    }


    public void modifyDebt(int hours, boolean positive) {
        int currentDebt = 0;
        ContentResolver resolver = mContext.getContentResolver();
        String[] projection = new String[]{SleepDebtContract.INT_DEBT_HOURS};
        Cursor cursor =
                resolver.query(SleepDebtContract.CONTENT_URI,
                        projection,
                        null,
                        null,
                        null);
        if (cursor.moveToFirst()) {
            do {
                currentDebt = cursor.getInt(0);
                // do something meaningful
            } while (cursor.moveToNext());
        }
        if (positive) {
            currentDebt = currentDebt + hours;
        } else {
            currentDebt = currentDebt - hours;
        }
        ContentValues cv = new ContentValues();
        cv.put(SleepDebtContract.INT_DEBT_HOURS, currentDebt);
        mContext.getContentResolver().insert(SleepDebtContract.CONTENT_URI, cv);
    }
}
