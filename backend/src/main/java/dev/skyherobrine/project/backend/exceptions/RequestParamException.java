package dev.skyherobrine.project.backend.exceptions;

public class RequestParamException extends RuntimeException {
    public RequestParamException(String message) {
        super(message);
    }
}
