package exception;

import java.util.List;

import constant.ExceptionMessages;

public class OutOfRangeException extends RuntimeException {
	public OutOfRangeException(List<Integer> numbers) {
		super(ExceptionMessages.OUT_OF_RANGE.getMessage(numbers));
	}
}
