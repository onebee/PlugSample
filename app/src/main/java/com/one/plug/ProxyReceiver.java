package com.one.plug;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.one.stander.ReceiverInterface;

/**
 * @author diaokaibin@gmail.com on 2020/3/7.
 * 能够接收的 广播接收者
 */
public class ProxyReceiver extends BroadcastReceiver {


    /**
     * 插件里面的 MyReceiver 全类名
     */
    private String pluginMyReceiverClassName;


    public ProxyReceiver(String pluginMyReceiverClassName) {
        this.pluginMyReceiverClassName = pluginMyReceiverClassName;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        // 加载插件里面的 receiver
        try {
            Class myReceiverClass = PluginManager.getInstance(context).getClassLoader().loadClass(pluginMyReceiverClassName);
            // 实例化
            Object myReceiver = myReceiverClass.newInstance();
            ReceiverInterface receiverInterface = (ReceiverInterface) myReceiver;

            receiverInterface.onReceive(context, intent);


        } catch (
                Exception e) {
            e.printStackTrace();
        }

    }
}
