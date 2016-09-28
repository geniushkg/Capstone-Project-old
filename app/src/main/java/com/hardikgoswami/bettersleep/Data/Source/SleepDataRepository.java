package com.hardikgoswami.bettersleep.Data.Source;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.widget.Toast;

import com.hardikgoswami.bettersleep.Data.Source.Local.BSContentProvider;
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

    public  void addHours(int hours){
        // TODO: save hours and get current date and store it to db


        // get current date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());

        ContentValues contentValues = new ContentValues();
        contentValues.put(SleepHistoryContract.INT_HOURS,hours);
        contentValues.put(SleepHistoryContract.STRING_DATE,date);

        Uri uri = mContext.getContentResolver().insert(
                SleepHistoryContract.CONTENT_URI, contentValues);
        // TODO: remove this toast only for debug purpose
        Toast.makeText(mContext,"text is : "+uri.toString(),Toast.LENGTH_SHORT).toString();
    }
}
