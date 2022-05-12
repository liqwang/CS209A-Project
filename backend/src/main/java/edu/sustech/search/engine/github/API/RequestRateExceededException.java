package edu.sustech.search.engine.github.API;

public class RequestRateExceededException extends Exception {

    public RequestRateExceededException() {
        super("Request rate is too high.");
    }

    public RequestRateExceededException(String message) {
        super(message);
    }

    public RequestRateExceededException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestRateExceededException(Throwable cause) {
        super("Request rate is too high.", cause);
    }
}
