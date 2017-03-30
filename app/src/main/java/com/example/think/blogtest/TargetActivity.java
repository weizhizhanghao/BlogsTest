package com.example.think.blogtest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class TargetActivity extends Activity {

    public static final Intent newIntent(Context context) {
        Intent intent = new Intent(context, TargetActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        int[] a = {1,3,6,2,7,5,0,4};
        SortAlgorithm.insertSort(a);
    }
}
