package constant;

public enum OutputMessages {
    INPUT_COORDINATES("좌표를 입력하세요.");

    private final String message;

    OutputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
