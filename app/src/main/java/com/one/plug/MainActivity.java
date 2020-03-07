package com.one.plug;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadPlugin(View view) {

        PluginManager.getInstance(this).loadPlugin();
    }

    /**
     * 启动插件里面的Activity
     *
     * @param view
     */
    public void startPluginActivity(View view) {
        // 占位 代理Activity
        Intent intent = new Intent(this, ProxyActivity.class);
        startActivity(intent);

    }
}
