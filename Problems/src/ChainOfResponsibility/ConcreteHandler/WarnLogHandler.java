package ChainOfResponsibility.ConcreteHandler;

import ChainOfResponsibility.Constants.LogLevel;
import ChainOfResponsibility.Handler.LogHandler;

public class WarnLogHandler implements LogHandler {
    LogHandler nextHandler;
    public WarnLogHandler(LogHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void setNextLogger(LogHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void writeLog(LogLevel logLevel, String s) {

        if (LogLevel.WARN.equals(logLevel))
            System.out.println("WARN : " + s);
        else if (nextHandler != null)
            nextHandler.writeLog(logLevel, s);
    }
}
