package com.example.sivaramadhiappan.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by sivaramadhiappan on 3/21/16.
 */
public class MyList2Adapter extends ArrayAdapter<String> {

    public MyList2Adapter(Context context, int resource) {
        super(context, resource);
    }

    public MyList2Adapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public MyList2Adapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
    }

    public MyList2Adapter(Context context, int resource, int textViewResourceId, String[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public MyList2Adapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    public MyList2Adapter(Context context, int resource, int textViewResourceId, List<String> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_test, parent, false);
        }

        if (position % 2 == 1) {
            convertView.setBackgroundResource(R.drawable.selector);
        } else {
            convertView.setBackgroundResource(R.drawable.selector1);
        }


        return convertView;
    }
}
