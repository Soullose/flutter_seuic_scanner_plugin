import 'flutter_seuic_scanner_plugin_platform_interface.dart';

class FlutterSeuicScannerPlugin {
  Stream<String?> getScannerCode() {
    return FlutterSeuicScannerPluginPlatform.instance.getScannerCode();
  }
}
