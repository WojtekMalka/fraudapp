package pl.wojtekmalka.fraudapp.exception;

public class NotFoundPersonException extends RuntimeException {
    public NotFoundPersonException(String message) {
        super(message);
    }
}
