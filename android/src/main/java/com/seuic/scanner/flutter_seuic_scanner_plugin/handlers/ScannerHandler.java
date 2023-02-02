package com.seuic.scanner.flutter_seuic_scanner_plugin.handlers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.seuic.scanner.flutter_seuic_scanner_plugin.constant.Channel;
import com.seuic.scanner.flutter_seuic_scanner_plugin.constant.Method;

import io.flutter.plugin.common.EventChannel;

public class ScannerHandler implements EventChannel.StreamHandler {


    private BroadcastReceiver chargingStateChangeReceiver;


    private final Context applicationContext;

    public ScannerHandler(Context context){
        this.applicationContext = context;
    }

    @Override
    public void onListen(Object arguments, EventChannel.EventSink events) {
        chargingStateChangeReceiver = createChargingStateChangeReceiver(events);
        IntentFilter intentFilter  = new IntentFilter();
        intentFilter.addAction(Channel.SCANNER_CHANNEL);
        intentFilter.setPriority(Integer.MAX_VALUE);
        applicationContext.registerReceiver(chargingStateChangeReceiver,intentFilter);
    }

    @Override
    public void onCancel(Object arguments) {
        applicationContext.unregisterReceiver(chargingStateChangeReceiver);
        chargingStateChangeReceiver = null;
    }

    private BroadcastReceiver createChargingStateChangeReceiver(final EventChannel.EventSink events) {
        return new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(Channel.SCANNER_CHANNEL)) {
                    String code = intent.getStringExtra(Method.SCANNER_KEY);
                    events.success(code);
                }
            }
        };
    }
}
