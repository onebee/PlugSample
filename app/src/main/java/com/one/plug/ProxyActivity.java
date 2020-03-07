package com.one.plug;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;

import com.one.stander.ActivityInterface;

import java.lang.reflect.Constructor;

import androidx.annotation.Nullable;

/**
 * @author diaokaibin@gmail.com on 2020/3/7.
 *
 *
 * 代理的Activity   代理/占位 插件里面的Activity
 */
public class ProxyActivity extends Activity {

    @Override
    public Resources getResources() {
        return PluginManager.getInstance(this).getResources();
    }

    @Override
    public ClassLoader getClassLoader() {
        return PluginManager.getInstance(this).getClassLoader();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // 真正的加载 插件里面 的Activity
        String className = getIntent().getStringExtra("className");

        try {
            Class mPluginActivityClass = getClassLoader().loadClass(className);

            // 实例化插件包 里面的Activity
            Constructor constructor = mPluginActivityClass.getConstructor(new Class[]{});
            Object mPluginActivity = constructor.newInstance(new Object[]{});

            ActivityInterface activityInterface = (ActivityInterface)mPluginActivity;

            // 注入
            activityInterface.insertAppContext(this);

            Bundle bundle = new Bundle();
            bundle.putString("appName","我是宿主传递过来的信息");

            // 执行插件里面的onCreate的方法
            activityInterface.onCreate(bundle);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }



}
