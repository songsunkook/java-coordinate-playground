package constant;

import java.util.List;

public enum ExceptionMessages {
    OUT_OF_RANGE("%d ~ %d 사이의 숫자만을 입력해주세요. [잘못 입력된 좌표: (%d, %d)]"),
    NOT_COORDINATE("올바르지 않은 형식이 입력되었습니다. [입력: %s]"),
    NUMBER_OF_INVALID_COORDINATES("좌표의 개수가 잘못되었습니다."),
    ;

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(List<Integer> number) {
        if (message.equals(OUT_OF_RANGE.getMessage())) {
            return String.format(message, ConstantNumber.MIN_RANGE.getNumber(), ConstantNumber.MAX_RANGE.getNumber(), number.get(0), number.get(1));
        }
        return message;
    }

    public String getMessage(String coordinate) {
        if (message.equals(NOT_COORDINATE.getMessage())) {
            return String.format(message, coordinate);
        }
        return message;
    }
}
