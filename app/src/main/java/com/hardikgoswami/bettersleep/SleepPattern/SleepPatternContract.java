package com.hardikgoswami.bettersleep.SleepPattern;

import com.hardikgoswami.bettersleep.BasePresenter;
import com.hardikgoswami.bettersleep.BaseView;

/**
 * Created by geniushkg on 9/29/2016.
 */
public interface SleepPatternContract {
    public interface View extends BaseView<Presenter> {
        void showSleepData();
    }

    public interface Presenter extends BasePresenter {
        void loadWeekData();

        void loadMonthData();
    }

}
