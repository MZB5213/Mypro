package com.dyth.mzb.utils.myview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Scroller;

/**
 * Created by Lenovo on 2019/1/14.
 */

public class MyCustomFrameLayout extends FrameLayout {

    private static final String TAG = MyCustomFrameLayout.class.getSimpleName();

    /**
     * 拿到两个控件的宽和三个的高
     * @param context
     * @param attrs
     */
    private int myHeigth; // 统一的高度
    private int myContentWidth; // 中间内容TextView的宽度
    private int myMenuWidth; // 菜单的宽度

    private Scroller scroller;

    public MyCustomFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        scroller = new Scroller(context);
    }

    private View tvContent;
    private View tvMenu;

    /**
     * 当布局加载完成✅后就会回调此方法
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        tvContent = getChildAt(0); // 拿到第一个孩子
        tvMenu = getChildAt(1); // 得到第二个孩子
    }

    /**
     * 测量两个孩子的高宽
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        myContentWidth = tvContent.getMeasuredWidth(); // 等价于getMeasuredWidth();因为这个是后去父控件的宽度，父控件和这个孩子控件宽度是一样的
        myHeigth = getMeasuredHeight();
        myMenuWidth = tvMenu.getMeasuredWidth();
    }

    /**
     * 为何不让实现者强制重写，应该在FrameLayout中已经重写过了
     * @param changed
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        // 指定位置
        tvContent.layout(0, 0, myContentWidth, myHeigth);
        tvMenu.layout(myContentWidth, 0 , myContentWidth + myMenuWidth, myHeigth);
    }

    private float startX;
    private int x;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                startX =  event.getX();
                break;
            case MotionEvent.ACTION_UP:
                float upEnd = event.getX();
                float thisUp = upEnd;
                // float myx = getScrollX() - thisUp;
                if (getScrollX() > myMenuWidth / 2) {
                    // x = myMenuWidth;

                    openM();
                } else {
                    // x = 0;

                    closeM();
                }
                /*invalidate();
                scroller.startScroll(getScrollX(), getScrollY(), x, Math.abs(1000));*/
                // scrollTo(x, getScrollY());
                break;
            case MotionEvent.ACTION_MOVE:
                int endX = (int) event.getX();
                int thisX = (int) (endX - startX);

                int scrollX = getScrollX();
                Log.i(TAG, ">>>>> scrollX" + scrollX);

                x =  scrollX - thisX;

                // 非法值的屏蔽
                if (x < 0) {
                    x = 0;
                } else if (x > myMenuWidth) {
                    x = myMenuWidth;
                }

                scrollTo(x, getScrollY());

                startX = event.getX();

                break;
            default:
                break;
        }
        return true;
    }

    private void openM() {
        invalidate();
        int dx = myMenuWidth - getScrollX();
        scroller.startScroll(getScrollX(), getScrollY(), dx, Math.abs(1000));
    }

    private void closeM() {
        invalidate();
        int dx = 0 - getScrollX();
        scroller.startScroll(getScrollX(), getScrollY(), dx, Math.abs(1000));
    }

    @Override
    public void computeScroll() {
        super.computeScroll();

        if (scroller.computeScrollOffset()) {
            int currX = scroller.getCurrX();
            scrollTo(currX, 0);
            invalidate();
        }
    }

}
