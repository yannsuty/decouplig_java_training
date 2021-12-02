package fr.lernejo.logger;

public class CompositeLogger implements Logger {
    private final Logger first_delegate;
    private final Logger second_delegate;

    public CompositeLogger(Logger first_delegate, Logger second_delegate) {
        this.first_delegate = first_delegate;
        this.second_delegate = second_delegate;
    }

    @Override
    public void log(String message) {
        first_delegate.log(message);
        second_delegate.log(message);
    }
}
