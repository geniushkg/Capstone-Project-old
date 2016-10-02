package com.hardikgoswami.bettersleep.SleepPattern;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;

import com.hardikgoswami.bettersleep.Data.Source.SleepDataRepository;
import com.hardikgoswami.bettersleep.SleepPunch.SleepPunchContract;

/**
 * Created by geniushkg on 9/29/2016.
 */
public class SleepPatterPresenter implements SleepPatternContract.Presenter,LoaderManager.LoaderCallbacks{

    LoaderManager mLoaderManager;
    SleepDataRepository mDataRepo;
    SleepPatternContract.View mView;

    public SleepPatterPresenter(LoaderManager mLoaderManager, SleepDataRepository mDataRepo, SleepPatternContract.View mView) {
        this.mLoaderManager = mLoaderManager;
        this.mDataRepo = mDataRepo;
        this.mView = mView;
    }

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
