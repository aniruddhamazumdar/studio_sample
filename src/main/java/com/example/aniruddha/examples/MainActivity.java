package com.example.aniruddha.examples;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

/**
 * Created by aniruddha on 26/11/14.
 */
public class MainActivity extends ActionBarActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private ListView list_items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews();

        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    private void initViews() {
        list_items = (ListView) findViewById(R.id.list_items);
    }

    private void initData() {

        //start loader with null cursor, swap onLoadFinished

        //Request Content Provider for list data
//        Loader<Cursor> loader = getLoaderManager().getLoader(0);
//        if (loader != null && !loader.isReset()) {
//            getLoaderManager().restartLoader(0, null, this);
//        } else {
//            getLoaderManager().initLoader(0, null, this);
//        }
    }


    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this, SampleProvider.BASE_URI.buildUpon().appendPath("sample").build(), null, null, null, "");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        //swap cursor
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {

    }
}
