package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import constant.ConstantNumber;
import exception.NotCoordinateException;
import exception.OutOfRangeException;

public class Coordinate {
    private static final int STRING_TRIM_INDEX = 1;

    private final int xPosition;
    private final int yPosition;

    public Coordinate(List<Integer> numbers) {
        xPosition = numbers.get(0);
        yPosition = numbers.get(1);
    }

    public Coordinate(String input) {
        this(process(input));
    }

    public boolean isEquals(Coordinate coordinate) {
        return xPosition == coordinate.xPosition && yPosition == coordinate.yPosition;
    }

    public Coordinate subtract(Coordinate target) {
        List<Integer> argument = Arrays.asList(xPosition - target.xPosition, yPosition - target.yPosition);
        return new Coordinate(argument);
    }

    public double multiply(Coordinate target) {
        return (xPosition - target.xPosition) * (yPosition - target.yPosition);
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public static Coordinate max(List<Coordinate> coordinates) {
        int maxX = coordinates.stream()
            .mapToInt(Coordinate::getXPosition)
            .max()
            .orElseThrow(() -> new RuntimeException("좌표가 없습니다."));
        int maxY = coordinates.stream()
            .mapToInt(Coordinate::getYPosition)
            .max()
            .orElseThrow(() -> new RuntimeException("좌표가 없습니다."));
        return new Coordinate(Arrays.asList(maxX, maxY));
    }

    public static Coordinate min(List<Coordinate> coordinates) {
        int minX = coordinates.stream()
            .mapToInt(Coordinate::getXPosition)
            .min()
            .orElseThrow(() -> new RuntimeException("좌표가 없습니다."));
        int minY = coordinates.stream()
            .mapToInt(Coordinate::getYPosition)
            .min()
            .orElseThrow(() -> new RuntimeException("좌표가 없습니다."));
        return new Coordinate(Arrays.asList(minX, minY));
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
        if (result.stream().anyMatch(i -> i < ConstantNumber.MIN_RANGE.getNumber() || i > ConstantNumber.MAX_RANGE.getNumber())) {
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
