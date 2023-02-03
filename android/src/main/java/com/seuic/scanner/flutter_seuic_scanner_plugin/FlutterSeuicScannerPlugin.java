package com.seuic.scanner.flutter_seuic_scanner_plugin;

import android.content.Context;

import androidx.annotation.NonNull;

import com.seuic.scanner.flutter_seuic_scanner_plugin.constant.Channel;
import com.seuic.scanner.flutter_seuic_scanner_plugin.handlers.ScannerHandler;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

/** FlutterSeuicScannerPlugin */
public class FlutterSeuicScannerPlugin implements FlutterPlugin, MethodCallHandler {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private MethodChannel channel;

  private EventChannel scannerEventChannel;

  private Context applicationContext;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    applicationContext = flutterPluginBinding.getApplicationContext();

    scannerEventChannel = new EventChannel(flutterPluginBinding.getBinaryMessenger(), Channel.SCANNER_CODE);
    scannerEventChannel.setStreamHandler(new ScannerHandler(applicationContext));
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
    scannerEventChannel.setStreamHandler(null);
  }
}
