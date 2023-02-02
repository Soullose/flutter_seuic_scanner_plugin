import 'dart:developer';

import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:flutter_seuic_scanner_plugin/flutter_seuic_scanner_plugin.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _platformVersion = 'Unknown';
  String _barCode = 'null';
  final _flutterSeuicScannerPlugin = FlutterSeuicScannerPlugin();

  @override
  void initState() {
    super.initState();
    initScanner();
  }

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


  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
            child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text('扫描结果: $_barCode\n'),
          ],
        )),
      ),
    );
  }
}
