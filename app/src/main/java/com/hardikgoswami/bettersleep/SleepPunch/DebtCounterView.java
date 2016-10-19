package com.hardikgoswami.bettersleep.SleepPunch;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by geniushkg on 10/4/2016.
 */

public class DebtCounterView extends TextView {

    public DebtCounterView(Context context) {
        super(context);
    }

    public DebtCounterView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DebtCounterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("Roboto-Bold.ttf", context);
        setTypeface(customFont);
    }

}
