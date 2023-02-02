package com.seuic.scanner.flutter_seuic_scanner_plugin.constant;

public interface Method {
    String TYPE_PLAYSOUND = "sound_play";
    String TYPE_VIBERATE = "viberate";
    String TYPE_SCAN_ENABLED = "enabled";// Enable/disable scan
    String TYPE_SCAN_CONTINUE = "scan_continue";// Continuous scan
    String TYPE_INTERVAL = "interval";// Continuous scanning interval
    String TYPE_PREFIX = "prefix";// barcode prefix
    String TYPE_SUFFIX = "suffix";// barcode postfix
    String TYPE_BOOT_START = "boot_start";
    String TYPE_END_CHAR = "endchar";
    String TYPE_BARCODE_SEND_MODE = "barcode_send_mode";
    String TYPE_BARCODE_BROADCAST_ACTION = "action_barcode_broadcast";
    String TYPE_BARCODE_BROADCAST_KEY = "key_barcode_broadcast";
    String TYPE_FILTER_PREFIX_SUFFIX_BLANK = "filter_prefix_suffix_blank";	// trim spaces at heading and tailing of the barcode
    String TYPE_FILTER_INVISIBLE_CHARS = "filter_invisible_chars"; 	// filter invisible chars
    String ACTION_SCANNER_PARAMETER_SETTINGS = "com.seuic.scanner.action.PARAM_SETTINGS"; // action: set scanner parameters
    String TYPE_PARAMETER_NUMBER = "number";	// parameter index
    String TYPE_PARAMETER_VALUE = "value";	// parameter value
    String ACTION_SCANNER_ENABLED = "com.android.scanner.ENABLED"; // action: enable/disable scan

    String SCANNER_KEY = "scannerdata";
}
