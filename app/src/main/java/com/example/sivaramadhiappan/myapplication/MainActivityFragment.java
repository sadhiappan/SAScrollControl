package com.example.sivaramadhiappan.myapplication;

import android.annotation.TargetApi;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private  ListView listView1;
    private  ListView listView2;
    MyListAdapter myListAdapter;
    MyList2Adapter myList2Adapter;
    RecyclerView recyclerView;
    MyHorizontalScroll horizontalScrollView;
    MyHorizontalScroll horizontalScrollRecyclerView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);



        listView1 = (ListView) v.findViewById(R.id.listView1);
        listView2 = (ListView) v.findViewById(R.id.listView2);
        myListAdapter = new MyListAdapter(getContext(),  android.R.layout.simple_list_item_1 ,loadList());
        myList2Adapter = new MyList2Adapter(getContext(),android.R.layout.simple_list_item_1, loadList());
        listView1.setAdapter(myListAdapter);
        listView2.setAdapter(myList2Adapter);
        horizontalScrollView = (MyHorizontalScroll) v.findViewById(R.id.horizontalScrollView);
        horizontalScrollRecyclerView = (MyHorizontalScroll) v.findViewById(R.id.horizontalScrollRecyclerView);
        listView1.setOverScrollMode(View.OVER_SCROLL_NEVER);
        listView2.setOverScrollMode(View.OVER_SCROLL_NEVER);
        horizontalScrollView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        horizontalScrollRecyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false) {
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new RecyclerViewAdapter(loadList()));

        listView1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                listView2.dispatchTouchEvent(motionEvent);
                return false;
            }
        });

        listView2.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                View v = absListView.getChildAt(0);
                if(v != null){
                    listView1.setSelectionFromTop(i, v.getTop());
                }
            }

        });

        listView2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (view == listView2 && motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    listView1.smoothScrollBy(0, 0);
                }
                return false;
            }
        });

        horizontalScrollView.setOnScrollChangeListener(new MyHorizontalScroll.OnScrollChangeListener() {
            @Override
            public void onScrollChanged(int l, int t, int oldl, int oldt) {
                horizontalScrollRecyclerView.scrollTo(l,0);
            }
        });

        horizontalScrollRecyclerView.setOnScrollChangeListener(new MyHorizontalScroll.OnScrollChangeListener() {
            @Override
            public void onScrollChanged(int l, int t, int oldl, int oldt) {
                horizontalScrollView.scrollTo(l,0);
            }
        });

        listView1.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        listView2.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(),"Hello 1",Toast.LENGTH_SHORT);
            }
        });

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listView1.performItemClick(listView1, i, l);
                Toast.makeText(getContext(),"Hello 2",Toast.LENGTH_SHORT);
            }
        });

        return v;
    }

    public List<String> loadList(){

        List<String> list = new ArrayList<String>();
        for(int i = 0; i <30; i ++){
            list.add("Item "+i);
        }

        return list;

    }

}
