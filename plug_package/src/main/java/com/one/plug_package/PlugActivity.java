package com.one.plug_package;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PlugActivity extends BaseActivity {

    private String ACTION = "com.one.plug_package.ACTION";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plug);

        Toast.makeText(appActivity, "我是插件", Toast.LENGTH_SHORT).show();

        findViewById(R.id.btn_startActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(appActivity, TestActivity.class));
            }
        });

        findViewById(R.id.btn_startService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startService(new Intent(appActivity, TestService.class));

            }
        });

        findViewById(R.id.btn_register_receiver).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentFilter filter = new IntentFilter();

                filter.addAction(ACTION);
                registerReceiver(new MyReceiver(), filter);
            }
        });

        findViewById(R.id.btn_send_receiver).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setAction(ACTION);
                sendBroadcast(intent);
            }
        });


    }


}
