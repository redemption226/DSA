package DesignPatterns.ChainOfResponsibility.Handler;

import DesignPatterns.ChainOfResponsibility.Constants.LogLevel;

public interface LogHandler {

     void setNextLogger(LogHandler next);
     void writeLog(LogLevel logLevel, String s);
}
