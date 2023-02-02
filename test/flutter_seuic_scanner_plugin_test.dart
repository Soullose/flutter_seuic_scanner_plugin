import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_seuic_scanner_plugin/flutter_seuic_scanner_plugin.dart';
import 'package:flutter_seuic_scanner_plugin/flutter_seuic_scanner_plugin_platform_interface.dart';
import 'package:flutter_seuic_scanner_plugin/flutter_seuic_scanner_plugin_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockFlutterSeuicScannerPluginPlatform
    with MockPlatformInterfaceMixin
    implements FlutterSeuicScannerPluginPlatform {

  @override
  Future<String?> getPlatformVersion() => Future.value('42');
}

void main() {
  final FlutterSeuicScannerPluginPlatform initialPlatform = FlutterSeuicScannerPluginPlatform.instance;

  test('$MethodChannelFlutterSeuicScannerPlugin is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelFlutterSeuicScannerPlugin>());
  });

  test('getPlatformVersion', () async {
    FlutterSeuicScannerPlugin flutterSeuicScannerPlugin = FlutterSeuicScannerPlugin();
    MockFlutterSeuicScannerPluginPlatform fakePlatform = MockFlutterSeuicScannerPluginPlatform();
    FlutterSeuicScannerPluginPlatform.instance = fakePlatform;

    expect(await flutterSeuicScannerPlugin.getPlatformVersion(), '42');
  });
}
