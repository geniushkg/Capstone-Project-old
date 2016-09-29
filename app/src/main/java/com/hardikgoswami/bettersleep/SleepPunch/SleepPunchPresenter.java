package com.hardikgoswami.bettersleep.SleepPunch;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import com.hardikgoswami.bettersleep.Data.Source.SleepDataRepository;

/**
 * Created by geniushkg on 9/28/2016.
 */
public class SleepPunchPresenter implements SleepPunchContract.Presenter ,LoaderManager.LoaderCallbacks {
    LoaderManager loaderManager;
    SleepDataRepository dataRepository;
    SleepPunchContract.View mView;

    public SleepPunchPresenter(LoaderManager loaderManager, SleepDataRepository dataRepository, SleepPunchContract.View mView) {
        this.loaderManager = loaderManager;
        this.dataRepository = dataRepository;
        this.mView = mView;
    }

    @Override
    public void fetchSleepDebtData() {

    }

    @Override
    public void showPunchInDialog() {

    }

    @Override
    public void swipeToYoganidra() {

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
