package com.one.plug_package;

import android.os.Bundle;
import android.widget.Toast;

public class PlugActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plug);

        Toast.makeText(this, "我是插件", Toast.LENGTH_SHORT).show();
    }

}
