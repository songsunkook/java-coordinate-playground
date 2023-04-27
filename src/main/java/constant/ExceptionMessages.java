package constant;

import java.util.List;

public enum ExceptionMessages {
    OUT_OF_RANGE("1 ~ 24 사이의 숫자만을 입력해주세요. [잘못 입력된 좌표: (%d, %d)]"),
    NOT_COORDINATE("올바르지 않은 형식이 입력되었습니다. [입력: %s]");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(List<Integer> number) {
        if (message.equals(OUT_OF_RANGE.getMessage())) {
            return String.format(message, number.get(0), number.get(1));
        }
        return message;
    }
/*
    public String getMessage(List<String> coordinate) {
        if (message.equals(NOT_COORDINATE.getMessage())) {
            return String.format(message, coordinate);
        }
        return message;
    }*/
}
