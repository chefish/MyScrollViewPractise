package com.fish.myscrollviewpractise;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by fish on 16/8/3.
 */
public class WatchableScrollView extends ScrollView {
    public WatchableScrollView(Context context) {
        super(context);
    }

    public WatchableScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WatchableScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public WatchableScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


//    public WatchableScrollView(Context context) {
//        this(context,null);
//    }
//
//    public WatchableScrollView(Context context, AttributeSet attrs) {
//        this(context,attrs,0);
//    }
//
//    public WatchableScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
//        this(context,attrs,0,0);
//    }
//
//    public WatchableScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
//        LogUtil.fish("" + getScrollY());
    }

    @Override
    protected boolean awakenScrollBars() {
        boolean bb= super.awakenScrollBars();
        LogUtil.fish(""+bb);
        return bb;
    }
}
