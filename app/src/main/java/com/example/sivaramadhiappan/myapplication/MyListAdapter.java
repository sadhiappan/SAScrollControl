package com.example.sivaramadhiappan.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sivaramadhiappan on 3/21/16.
 */
public class MyListAdapter extends ArrayAdapter<String> {

    List<String> list = new ArrayList<>();

    public MyListAdapter(Context context, int resource) {
        super(context, resource);
    }

    public MyListAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public MyListAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
    }

    public MyListAdapter(Context context, int resource, int textViewResourceId, String[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public MyListAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        list = objects;
    }

    public MyListAdapter(Context context, int resource, int textViewResourceId, List<String> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.mytext1, parent, false);
        }

        if (position % 2 == 1) {
            convertView.setBackgroundResource(R.drawable.selector);
        } else {
            convertView.setBackgroundResource(R.drawable.selector1);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.textView1);
        textView.setText(list.get(position));

        return convertView;
    }

}
