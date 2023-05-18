import 'package:flutter_seuic_scanner_plugin/flutter_seuic_scanner_plugin_method_channel.dart';
import 'package:flutter_seuic_scanner_plugin/flutter_seuic_scanner_plugin_platform_interface.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockFlutterSeuicScannerPluginPlatform
    with MockPlatformInterfaceMixin
    implements FlutterSeuicScannerPluginPlatform {
  @override
  Stream<String?> getScannerCode() {
    // TODO: implement getScannerCode
    throw UnimplementedError();
  }
}

void main() {
  final FlutterSeuicScannerPluginPlatform initialPlatform =
      FlutterSeuicScannerPluginPlatform.instance;

  test('$MethodChannelFlutterSeuicScannerPlugin is the default instance', () {
    expect(initialPlatform,
        isInstanceOf<MethodChannelFlutterSeuicScannerPlugin>());
  });
}
