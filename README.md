# flutter_seuic_scanner_plugin

A Flutter plugin based on the seuic(东集) UTouch mobile phone scanner broadcast

## Getting Started

in pubspec.yml dependencies add

```yaml

flutter_seuic_scanner_plugin:
  git:
    url: https://github.com/Soullose/flutter_seuic_scanner_plugin.git

```

## Get Scanner

```dart
final _flutterSeuicScannerPlugin = FlutterSeuicScannerPlugin();


void initScanner() {
  String barcode;
  _flutterSeuicScannerPlugin.getScannerCode().listen((event) {
    log('-----$event');
    barcode = event ?? '无';

    setState(() {
      _barCode = barcode;
    });
  });
}


```