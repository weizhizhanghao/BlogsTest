package com.example.think.blogtest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
/*
*处理需要预先加载某些数据但是不在加载时显示黑屏的情况
*/
public class SplashActivity extends Activity {

    private static final int SHOW_MIN_TIME = 3000;
    private long mStartTime;
    Context context;

    private Handler mHanlder = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                //这个值表示数据已经加载完全
                case 1:
                    long loadingTime = System.currentTimeMillis() - mStartTime;
                    if (loadingTime < SHOW_MIN_TIME){
                        mHanlder.postDelayed(goToTargetActivity, SHOW_MIN_TIME  - loadingTime);
                    } else {
                        mHanlder.post(goToTargetActivity);
                    }
                    break;
                default:
                    break;
            }
        }
    };

    Runnable goToTargetActivity = new Runnable() {
        @Override
        public void run() {
            startActivity(TargetActivity.newIntent(context));
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        context = this;
        mStartTime = System.currentTimeMillis();

        // 此处加载需要预加载的数据
        // Application.getInstance().initData(mHandler);
        // 由于这是个测试，所以随便写写加载
        mHanlder.sendEmptyMessage(1);
    }
}
