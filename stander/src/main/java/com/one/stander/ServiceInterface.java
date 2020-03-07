package com.one.stander;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * @author diaokaibin@gmail.com on 2020/3/7.
 */
public interface ServiceInterface {

    /**
     * 把宿主的环境 给插件
     * @param appService
     */
    void insertAppContext(Service appService);

    void onCreate();
    int onStartCommand(Intent intent, int flags, int startId);
    IBinder onBind(Intent intent);
    void onDestroy();
}
