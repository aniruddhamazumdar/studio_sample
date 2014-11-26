package com.example.aniruddha.examples;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

/**
 * Created by aniruddha on 26/11/14.
 */
public class MainActivity extends ActionBarActivity {

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

    private void initData(){
        //Request Content Provider for list data
    }
}
