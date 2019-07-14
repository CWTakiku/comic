package com.example.cwl.base.logger;

public interface LogStrategy {

  void log(int priority, String tag, String message);
}
