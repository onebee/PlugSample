package com.one.plug_package;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.one.stander.ServiceInterface;

import androidx.annotation.Nullable;

/**
 * @author diaokaibin@gmail.com on 2020/3/7.
 */
public class BaseService extends Service implements ServiceInterface {

    public Service appService;

    @Override
    public void insertAppContext(Service appService) {
        this.appService = appService;
    }


    @Override
    public void onCreate() {

    }


    @SuppressLint("WrongConstant")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return 0;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
