package SingletonPattern;

public class Logger {

    static volatile Logger logger;

    private Logger() {

    };

    public static Logger getLogger() {
        if (logger == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger();
                }
            }
        }
        return logger;
    }

    public void log(String message) {
        System.out.println(message);
    }
}
