package com.one.plug_package;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import com.one.stander.ActivityInterface;

/**
 * @author diaokaibin@gmail.com on 2020/3/7.
 */
public class BaseActivity extends Activity implements ActivityInterface {


    public Activity appActivity; // 宿主的环境


    @Override
    public void insertAppContext(Activity activity) {

        this.appActivity = activity;
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onStart() {

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onResume() {

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onDestroy() {

    }

    public void setContentView(int resId){
        appActivity.setContentView(resId);

    }

}
