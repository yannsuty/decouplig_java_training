package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger{
    private final Logger delegateLogger;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    private final String callerClass;

    public ContextualLogger(String callerClass, Logger delegateLogger) {
        this.delegateLogger=delegateLogger;
        this.callerClass=callerClass;
    }
    @Override
    public void log(String message) {
        delegateLogger.log(LocalDateTime.now().format(formatter) + " " + callerClass + " " + message);
    }
}
