package exception;

import constant.ExceptionMessages;

public class OutOfRangeException extends RuntimeException {
	public OutOfRangeException() {
		super(ExceptionMessages.OUT_OF_RANGE.getMessage());
	}
}
