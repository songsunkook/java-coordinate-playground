package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import exception.OutOfRangeException;

public class Coordinate {
    private static final int STRING_TRIM_INDEX = 1;

    private final int xPos;
    private final int yPos;

    //List<Integer>: 1,3
    public Coordinate(List<Integer> numbers) {
        checkExceptions(numbers);
        this.xPos = numbers.get(0);
        this.yPos = numbers.get(1);
    }

    //String: "(1,3)"
    public Coordinate(String input) {
        this(process(input));
    }

    public boolean isEquals(Coordinate coordinate) {
        return xPos == coordinate.xPos && yPos == coordinate.yPos;
    }

    private static List<Integer> process(String input) {
        input = input.substring(STRING_TRIM_INDEX, input.length() - STRING_TRIM_INDEX);
        List<String> list = Arrays.asList(input.split(","));
        return list.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private void checkExceptions(List<Integer> result) {
        if (result.stream().anyMatch(i -> i < 1 || i > 24)) {
            throw new OutOfRangeException(result);
        }
    }
}
