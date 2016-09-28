package com.hardikgoswami.bettersleep.SleepPunch;

import com.hardikgoswami.bettersleep.BasePresenter;
import com.hardikgoswami.bettersleep.BaseView;

/**
 * Created by geniushkg on 9/28/2016.
 */
public class SleepPunchContract {
    interface View extends BaseView<Presenter>{
        void showSleepDebtData();
        void showSleepDebtHelpDialog();
        void showPunchInDialog();
    }

    interface Presenter extends BasePresenter{
        void fetchSleepDebtData();
        void showPunchInDialog();
        void swipeToYoganidra();
    }
}
