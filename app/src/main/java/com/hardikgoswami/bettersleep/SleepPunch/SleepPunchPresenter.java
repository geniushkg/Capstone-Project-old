package com.hardikgoswami.bettersleep.SleepPunch;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import com.hardikgoswami.bettersleep.Data.Source.Local.Debt;
import com.hardikgoswami.bettersleep.Data.Source.SleepDataRepository;

/**
 * Created by geniushkg on 9/28/2016.
 */
public class SleepPunchPresenter implements SleepPunchContract.Presenter, LoaderManager.LoaderCallbacks<Debt> {


    LoaderManager loaderManager;
    SleepDataRepository dataRepository;
    SleepPunchContract.View mView;
    Loader<Debt> mLoader;
    Debt mData;
    public static int DEBT_QUERY = 1;
    public SleepPunchPresenter(LoaderManager loaderManager, SleepDataRepository dataRepository, SleepPunchContract.View mView, Loader<Debt> debtLoader) {
        this.loaderManager = loaderManager;
        this.dataRepository = dataRepository;
        this.mView = mView;
        this.mLoader = debtLoader;
        mView.setPresenter(this);
    }



    @Override
    public void fetchSleepDebtData(Debt debt) {
        mView.showSleepDebtData(debt);
    }

    @Override
    public void showPunchInDialog() {
        mView.showMessage("This is from Presenter , show punch trigered");
    }

    @Override
    public void swipeToYoganidra() {

    }

    @Override
    public void start() {
        loaderManager.initLoader(DEBT_QUERY,null,this);
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        // TODO : setup loading view for debt counter and enable it.
        return mLoader;
    }

    @Override
    public void onLoadFinished(Loader<Debt> loader, Debt data) {
        // TODO:  disable loading view
        if(data == null){
            //// TODO: 10/3/2016  cannot be null show error and error view enable
        }else {
            mData = data;
        }
        fetchSleepDebtData(data);
    }

    @Override
    public void onLoaderReset(Loader loader) {

    }
}
