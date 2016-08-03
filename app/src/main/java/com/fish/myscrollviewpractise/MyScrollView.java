package com.fish.myscrollviewpractise;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;

/**
 * Created by fish on 16/8/2.
 */
public class MyScrollView extends FrameLayout {

    private boolean mIsBeingDragged = false;
    /**
     * Position of the last motion event.
     */
    private int mLastMotionY;
    private int mTouchSlop;


    public MyScrollView(Context context) {
        this(context, null);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initScrollView();
    }

    private void initScrollView() {
        final ViewConfiguration configuration = ViewConfiguration.get(getContext());
        mTouchSlop = configuration.getScaledTouchSlop();
    }


    //让内部的LinearLayout高度可以很大很大
    @Override
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {

        final MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();

        final int childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                getPaddingLeft() + getPaddingRight() + lp.leftMargin + lp.rightMargin
                        + widthUsed, lp.width);
        final int childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);

        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastMotionY = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int delta = (int) (event.getY() - mLastMotionY);
                if (mIsBeingDragged) {
                    scrollBy(0, -delta);
                    mLastMotionY= (int) event.getY();
                } else if (Math.abs(delta) > mTouchSlop) {
                    mIsBeingDragged = true;
                    mLastMotionY= (int) event.getY();
                    scrollBy(0, -delta);
                }
                break;

            case MotionEvent.ACTION_UP:
                mIsBeingDragged = false;
                break;
        }

        return true;
    }
}
