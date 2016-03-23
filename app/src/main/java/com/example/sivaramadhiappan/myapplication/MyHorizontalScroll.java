package com.example.sivaramadhiappan.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;

/**
 * Created by sivaramadhiappan on 3/21/16.
 */
public class MyHorizontalScroll extends HorizontalScrollView {
    public OnScrollChangeListener onScrollChangeListener;

    public MyHorizontalScroll(Context context) {
        super(context);
    }

    public MyHorizontalScroll(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyHorizontalScroll(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(onScrollChangeListener !=null){
            onScrollChangeListener.onScrollChanged(l, t, oldl, oldt);
        }
    }

    public void setOnScrollChangeListener(OnScrollChangeListener listener){
        onScrollChangeListener = listener;
    }

    public interface OnScrollChangeListener{
        public void onScrollChanged(int l, int t, int oldl, int oldt);
    }
}
