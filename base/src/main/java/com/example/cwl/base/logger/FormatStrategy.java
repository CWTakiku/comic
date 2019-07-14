package com.example.cwl.base.logger;

public interface FormatStrategy {

  void log(int priority, String tag, String message);
}
