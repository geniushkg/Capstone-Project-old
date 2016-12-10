package com.hardikgoswami.githubmetrics.persistence;

import android.net.Uri;

import com.tjeannin.provigen.ProviGenBaseContract;
import com.tjeannin.provigen.annotation.Column;
import com.tjeannin.provigen.annotation.ContentUri;

/**
 * Created by geniushkg on 12/10/2016.
 */

public class HistoryContract implements ProviGenBaseContract {
    @Column(Column.Type.REAL)
    public static final String RATING_COLUMN = "rating";

    @Column(Column.Type.TEXT)
    public static final String USERNAME_COLUMN = "username";

    @Column(Column.Type.TEXT)
    public static final String EMAIL_COLUMN = "email";


    @ContentUri
    public static final Uri CONTENT_URI = Uri.parse("content://com.hardikgoswami/history");


}
