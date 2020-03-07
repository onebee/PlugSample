package com.one.plug;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * @author diaokaibin@gmail.com on 2020/3/7.
 *
 *
 * 代理的Activity   代理/占位 插件里面的Activity
 */
public class ProxyActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 真正的加载 插件里面 的Activity


    }


}
