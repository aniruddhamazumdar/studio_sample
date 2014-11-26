package com.example.aniruddha.examples;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aniruddha on 26/11/14.
 */
public class SampleDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "sample_db";
    private static final int DB_VERSION = 1;

    public SampleDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Samples.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Samples.SQL_DELETE);
        db.execSQL(Samples.SQL_CREATE);
    }
}
