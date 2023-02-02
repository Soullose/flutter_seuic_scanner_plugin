package com.seuic.scanner.flutter_seuic_scanner_plugin_example;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.seuic.scanner.flutter_seuic_scanner_plugin.constant.Channel;
import com.seuic.scanner.flutter_seuic_scanner_plugin.constant.Method;

import io.flutter.embedding.android.FlutterActivity;

public class MainActivity extends FlutterActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boardCastSetting();
    }

    private void boardCastSetting()
    {
        Intent intent = new Intent(Channel.SETTINGS_CHANNEL);
        //声音
        intent.putExtra(Method.TYPE_PLAYSOUND,false);
        //震动
        intent.putExtra(Method.TYPE_VIBERATE,true);
        //其他参数设置参照：Android扫描服务设置.doc
        sendBroadcast(intent);
    }
}
