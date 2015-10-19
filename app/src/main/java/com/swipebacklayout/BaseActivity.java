package com.swipebacklayout;

import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;

import com.library.SwipeBackLayout;
import com.library.app.SwipeBackActivity;


public class BaseActivity extends SwipeBackActivity {

    //随手势滑动而滑动的Activity界面
    private SwipeBackLayout mSwipeBackLayout;
    //随手势返回的处罚方位，有EDGE_LEFT、EDGE_RIGHT、EDGE_BOTTOM、EDGE_ALL
    //一般选择自左侧返回
    private int edgeFlag = SwipeBackLayout.EDGE_LEFT;
    //用于取消手势滑动返回
    private boolean mSwipeBackEnable = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.colorPrimaryDark);
        }
        mSwipeBackLayout = getSwipeBackLayout();
        mSwipeBackLayout.setEdgeTrackingEnabled(edgeFlag);
    }

    /**
     *  取消滑动返回
     *
     * @param enable
     */
    public void setActivitySwipeBackEnable(boolean enable) {
        mSwipeBackEnable = enable;
        setSwipeBackEnable(mSwipeBackEnable);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if(mSwipeBackEnable){
                scrollToFinishActivity();
            }else{
                finish();
            }
        }
        return false;
    }


}
