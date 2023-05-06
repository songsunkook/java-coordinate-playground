package constant;

public enum ConstantNumber {
    MIN_RANGE(1),
    MAX_RANGE(24),
    LINE_LENGTH(2),
    TRIANGLE_LENGTH(3),
    RECTANGLE_LENGTH(4);


    private final int number;

    ConstantNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
