package com.hardikgoswami.bettersleep.Data.Source.Local;

import android.net.Uri;

import com.tjeannin.provigen.ProviGenBaseContract;
import com.tjeannin.provigen.annotation.Column;
import com.tjeannin.provigen.annotation.ContentUri;
import com.tjeannin.provigen.model.Contract;

/**
 * Created by geniushkg on 9/28/2016.
 */
public interface SleepHistoryContract extends ProviGenBaseContract {
    @Column(Column.Type.INTEGER)
    public static final String INT_HOURS = "int";

    @Column(Column.Type.TEXT)
    public static final String STRING_DATE = "string";

    @ContentUri
    public static final Uri CONTENT_URI = Uri.parse("content://com.hardikgoswami.bettersleep/sleep_history");
}
