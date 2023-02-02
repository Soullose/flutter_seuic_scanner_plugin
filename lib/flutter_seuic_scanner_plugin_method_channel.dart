import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'Channel.dart';
import 'flutter_seuic_scanner_plugin_platform_interface.dart';

/// An implementation of [FlutterSeuicScannerPluginPlatform] that uses method channels.
class MethodChannelFlutterSeuicScannerPlugin extends FlutterSeuicScannerPluginPlatform {

  @visibleForTesting
  final eventChannel = EventChannel(Channel.scannerCode);

  @override
  Stream<String> getScannerCode() {
    return eventChannel.receiveBroadcastStream().map((event) => event as String);
  }
}
