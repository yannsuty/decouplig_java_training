package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        return new ContextualLogger(name, new FileLogger("C:\\Users\\yanns\\Documents\\decouplig_java_training\\target\\app.log"));
    }
}
