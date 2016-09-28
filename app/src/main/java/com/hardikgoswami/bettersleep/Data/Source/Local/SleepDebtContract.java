package com.hardikgoswami.bettersleep.Data.Source.Local;

import android.net.Uri;

import com.tjeannin.provigen.ProviGenBaseContract;
import com.tjeannin.provigen.annotation.Column;
import com.tjeannin.provigen.annotation.ContentUri;

/**
 * Created by geniushkg on 9/28/2016.
 */
public interface SleepDebtContract extends ProviGenBaseContract {
    @Column(Column.Type.INTEGER)
    public static final String INT_DEBT_HOURS = "int";

    @ContentUri
    public static final Uri CONTENT_URI = Uri.parse("content://com.hardikgoswami.bettersleep/debt_hours");
}
