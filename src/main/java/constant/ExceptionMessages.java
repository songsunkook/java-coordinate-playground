package constant;

public enum ExceptionMessages {
	OUT_OF_RANGE("Out of range");

	private final String message;

	ExceptionMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
