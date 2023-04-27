package exception;

import constant.ExceptionMessages;

public class NotCoordinateException extends RuntimeException {
    public NotCoordinateException(String numbers) {
        super(ExceptionMessages.NOT_COORDINATE.getMessage(numbers));
    }
}
