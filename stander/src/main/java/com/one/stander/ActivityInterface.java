package com.one.stander;

import android.app.Activity;
import android.os.Bundle;

/**
 * @author diaokaibin@gmail.com on 2020/3/7.
 */
public interface ActivityInterface {


    /**
     * 把宿主的环境 给插件
     * @param activity
     */
    void insertAppContext(Activity activity);


    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onDestroy();

}
