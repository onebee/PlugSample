package com.one.plug_package;

import android.content.Intent;
import android.util.Log;

/**
 * @author diaokaibin@gmail.com on 2020/3/7.
 */
public class TestService extends BaseService {

    private final String TAG = this.getClass().getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 开启子线程,执行耗时任务
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        Log.d(TAG,"  插件里面的服务  正在执行中....");
                    }
                }

            }
        }).start();

        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
