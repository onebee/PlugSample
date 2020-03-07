package com.one.plug;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.one.stander.ServiceInterface;

import androidx.annotation.Nullable;

/**
 * @author diaokaibin@gmail.com on 2020/3/7.
 */
public class ProxyService extends Service {


    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        try {
            String className = intent.getStringExtra("className");
            Class clazz = PluginManager.getInstance(this).getClassLoader().loadClass(className);

            Object mTestService = clazz.newInstance();

            ServiceInterface serviceInterface = (ServiceInterface)mTestService;

            // 注入组件环境
            serviceInterface.insertAppContext(this );

            serviceInterface.onStartCommand(intent, flags, startId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
