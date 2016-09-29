package com.hardikgoswami.bettersleep.SleepPattern;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;

import com.hardikgoswami.bettersleep.SleepPunch.SleepPunchContract;

/**
 * Created by geniushkg on 9/29/2016.
 */
public class SleepPatterPresenter implements SleepPatternContract.Presenter,LoaderManager.LoaderCallbacks{

    @Override
    public void loadWeekData() {

    }

    @Override
    public void loadMonthData() {

    }

    @Override
    public void start() {

    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader loader, Object data) {

    }

    @Override
    public void onLoaderReset(Loader loader) {

    }
}
