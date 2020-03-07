package com.one.plug_package;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PlugActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plug);

        Toast.makeText(appActivity, "我是插件", Toast.LENGTH_SHORT).show();

        findViewById(R.id.btn_startActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(appActivity,TestActivity.class));
            }
        });

        findViewById(R.id.btn_startService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startService(new Intent(appActivity, TestService.class));

            }
        });
    }



}
