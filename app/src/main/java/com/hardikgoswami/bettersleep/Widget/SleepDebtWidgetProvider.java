package com.hardikgoswami.bettersleep.Widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;
import com.hardikgoswami.bettersleep.R;

/**
 * Created by geniushkg on 10/15/2016.
 */

public class SleepDebtWidgetProvider extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        String dummyText = "Your Sleep Debt is 10 Hrs.";
        RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.sleepdebt_widget);
        remoteView.setTextViewText(R.id.sleep_debt_tv_widget,dummyText);
    }
}
