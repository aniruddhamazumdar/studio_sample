package com.example.aniruddha.examples;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aniruddha on 26/11/14.
 */
public class StringItemsAdapter extends AbstractItemsAdapter<String> {

    public StringItemsAdapter(Context context, List<String> items) {
        super(context, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(mContext.getApplicationContext()).inflate(R.layout.list_item_samples, null, false);

        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_title.setText(mItems.get(position));

        return view;
    }
}
