package domain;

import dto.CoordinateDto;
import exception.NotCoordinateException;
import exception.OutOfRangeException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public CoordinateDto toDto() {
        return new CoordinateDto(xPos, yPos);
    }

    public static Coordinate toDomain(CoordinateDto coordinateDto) {
        return new Coordinate(Arrays.asList(coordinateDto.positionX(), coordinateDto.positionY()));
    }

    public Coordinate subtract(Coordinate target) {
        List<Integer> argument = Arrays.asList(xPos - target.xPos, yPos - target.yPos);
        return new Coordinate(argument);
    }

    public int positionX() {
        return xPos;
    }

    public int positionY() {
        return yPos;
    }

    private static List<Integer> process(String input) {
        String original = input;
        input = input.substring(STRING_TRIM_INDEX, input.length() - STRING_TRIM_INDEX);
        List<String> list = Arrays.asList(input.split(","));
        List<Integer> result = stringToIntList(list, original);
        checkExceptions(result);
        return result;
    }

    private static void checkExceptions(List<Integer> result) {
        if (result.stream().anyMatch(i -> i < 1 || i > 24)) {
            throw new OutOfRangeException(result);
        }
    }

    private static List<Integer> stringToIntList(List<String> input, String original) {
        try {
            return input.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NotCoordinateException(original);
        }
    }
}
