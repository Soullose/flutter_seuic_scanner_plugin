import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'flutter_seuic_scanner_plugin_method_channel.dart';

abstract class FlutterSeuicScannerPluginPlatform extends PlatformInterface {
  /// Constructs a FlutterSeuicScannerPluginPlatform.
  FlutterSeuicScannerPluginPlatform() : super(token: _token);

  static final Object _token = Object();

  static FlutterSeuicScannerPluginPlatform _instance = MethodChannelFlutterSeuicScannerPlugin();

  /// The default instance of [FlutterSeuicScannerPluginPlatform] to use.
  ///
  /// Defaults to [MethodChannelFlutterSeuicScannerPlugin].
  static FlutterSeuicScannerPluginPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [FlutterSeuicScannerPluginPlatform] when
  /// they register themselves.
  static set instance(FlutterSeuicScannerPluginPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Stream<String?> getScannerCode() {
    throw UnimplementedError('getScannerCode() has not been implemented.');
  }
}
