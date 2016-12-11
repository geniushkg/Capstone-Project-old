package com.hardikgoswami.githubmetrics.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.widget.RemoteViews;

import com.hardikgoswami.githubmetrics.R;
import com.hardikgoswami.githubmetrics.login.LoginGithubActivity;
import com.hardikgoswami.githubmetrics.persistence.HistoryContract;
import com.hardikgoswami.githubmetrics.persistence.UserHistory;

import static com.hardikgoswami.githubmetrics.network.GithubDataLoader.TAG;

/**
 * Created by geniushkg on 12/10/2016.
 */

public class HistoryWidgetProvider extends AppWidgetProvider {


    private UserHistory user;

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        final int N = appWidgetIds.length;
        // Perform this loop procedure for each App Widget that belongs to this provider
        for (int i = 0; i < N; i++) {
            int appWidgetId = appWidgetIds[i];
            Cursor c = context.getContentResolver().query(HistoryContract.CONTENT_URI, null, null, null, " '_id'  DESC LIMIT 1");
            if (c.getCount() > 0) {
                c.moveToFirst();
                user = new UserHistory();
                user.setEmail(c.getString(c.getColumnIndex("email")));
                user.setUsername(c.getString(c.getColumnIndex("username")));
                user.setRating(c.getFloat(c.getColumnIndex("rating")));
                user.setId(c.getInt(c.getColumnIndex("_id")));
            }else {
                Log.d(TAG, "onUpdate: empty widget content resolver query");
            }
            c.close();
            RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.history_widget);
            remoteView.setTextViewText(R.id.tvNameHistoryRowWidget,user.getUsername());
            remoteView.setTextViewText(R.id.tvEmailHistoryRowWidget,user.getEmail());
            remoteView.setTextViewText(R.id.tvRatingTextWidget,"Rating:-"+user.getRating());
            remoteView.setTextViewText(R.id.tvLabelHistory,"History");

            // Create an Intent to launch MainActivity
            Intent launchIntent = new Intent(context, LoginGithubActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, launchIntent,PendingIntent.FLAG_UPDATE_CURRENT);
            remoteView.setOnClickPendingIntent(R.id.llWidget, pendingIntent);

            //performupdate
            appWidgetManager.updateAppWidget(appWidgetId,remoteView);
        }
    }
}
