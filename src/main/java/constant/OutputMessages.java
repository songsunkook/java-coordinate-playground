package constant;

public enum OutputMessages {
    INPUT_COORDINATES("좌표를 입력하세요."),
    OUTPUT_LINE("두 점 사이 거리는 %f"),
    OUTPUT_TRIANGLE("삼각형 넓이는 %.1f"),
    OUTPUT_SQUARE("사각형 넓이는 %.0f");

    private final String message;

    OutputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(double input) {
        return String.format(message, input);
    }
}
