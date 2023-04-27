package exception;

import constant.ExceptionMessages;

public class NotCoordinateException extends RuntimeException {
    public NotCoordinateException(/*List<Integer> numbers*/) {
        super(ExceptionMessages.NOT_COORDINATE.getMessage(/*numbers*/));
    }
}
