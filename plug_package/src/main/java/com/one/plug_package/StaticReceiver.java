package com.one.plug_package;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * @author diaokaibin@gmail.com on 2020/3/7.
 */
public class StaticReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "我是插件里面静态注册的广播", Toast.LENGTH_SHORT).show();

    }
}
