package com.hardikgoswami.githubmetrics.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;

import com.hardikgoswami.githubmetrics.persistence.HistoryContract;
import com.hardikgoswami.githubmetrics.persistence.UserHistory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geniushkg on 12/10/2016.
 */

public class HistoryWidgetProvider extends AppWidgetProvider {

    private static List<UserHistory> historyList;
    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        updateWidgetUi(context,appWidgetManager,appWidgetIds);
    }

    private static void updateWidgetUi(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        historyList = new ArrayList<>();
        Cursor c =context.getContentResolver().query(HistoryContract.CONTENT_URI,null,null,null," '_id'  DESC ");
        if (c.getCount()>0){
            if (c.moveToFirst()){
                do{
                    UserHistory user = new UserHistory();
                    user.setEmail(c.getString(c.getColumnIndex("email")));
                    user.setUsername(c.getString(c.getColumnIndex("username")));
                    user.setRating(c.getFloat(c.getColumnIndex("rating")));
                    user.setId(c.getInt(c.getColumnIndex("_id")));
                    historyList.add(user);
                }while (c.moveToNext());

            }
        }
    }
}
