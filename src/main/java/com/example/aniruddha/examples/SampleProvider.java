package com.example.aniruddha.examples;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

/**
 * Created by aniruddha on 26/11/14.
 */
public class SampleProvider extends ContentProvider {
    SampleDatabaseHelper mDBHelper;

    private static final String AUTH = "com.example.aniruddha.examples.data";
    public static final Uri BASE_URI = Uri.parse("content://" + AUTH);

    private static final int SAMPLE = 1;
    private static final int SAMPLE_ID = 2;
    private static final int SAMPLE_NAME = 3;

    private static final UriMatcher mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        mUriMatcher.addURI(AUTH, "sample", SAMPLE);
        mUriMatcher.addURI(AUTH, "sample/#", SAMPLE_ID);
        mUriMatcher.addURI(AUTH, "sample/#/name", SAMPLE_NAME);
    }

    @Override
    public boolean onCreate() {
        mDBHelper = new SampleDatabaseHelper(getContext());

        insertDummyValues();

        return true;
    }

    private void insertDummyValues() {
        SQLiteDatabase db = mDBHelper.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(Samples.COL_ID, 1);
        values.put(Samples.COL_NAME, "Aniruddha");
        values.put(Samples.COL_CREATED, 342343);
        values.put(Samples.COL_MODIFIED, 342344);
        db.insert(Samples.TABLE_NAME, "", values);

        values = new ContentValues();
        values.put(Samples.COL_ID, 2);
        values.put(Samples.COL_NAME, "Ravi");
        values.put(Samples.COL_CREATED, 342343);
        values.put(Samples.COL_MODIFIED, 342344);
        db.insert(Samples.TABLE_NAME, "", values);

        values = new ContentValues();
        values.put(Samples.COL_ID, 3);
        values.put(Samples.COL_NAME, "Rafiq");
        values.put(Samples.COL_CREATED, 342343);
        values.put(Samples.COL_MODIFIED, 342344);
        db.insert(Samples.TABLE_NAME, "", values);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = mDBHelper.getReadableDatabase();

        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();

        switch (mUriMatcher.match(uri)) {
            case SAMPLE:
                if (!TextUtils.isEmpty(sortOrder)) {
                    sortOrder = "_id ASC";
                }
                builder.setTables(Samples.TABLE_NAME);
                break;
            case SAMPLE_ID:
                break;
            case SAMPLE_NAME:
                break;
//            case default:
//                throw new Exception("WRONG URI: " + uri.toString());
//                break;
        }
        return builder.query(db, projection, selection, selectionArgs, "", "", sortOrder);
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
