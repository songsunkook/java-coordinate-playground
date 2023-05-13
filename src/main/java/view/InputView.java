package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import constant.ConstantNumber;
import domain.Coordinate;
import exception.NotCoordinateException;
import exception.OutOfRangeException;

public class InputView {
    private static final int STRING_TRIM_INDEX = 1;
    private static final String COORDINATE_SEPARATOR = "-";
    private static final String COORDINATE_AXIS_SEPARATOR = ",";
    private static final Scanner scanner = new Scanner(System.in);
    public static List<Coordinate> coordinates() {
        return separatingCoordinates(scanner.nextLine());
    }

    public static List<Coordinate> separatingCoordinates(String input) {
        if (input.contains(COORDINATE_SEPARATOR)) {
            List<String> splitString = Arrays.asList(input.split(COORDINATE_SEPARATOR));

            return splitString.stream()
                .map(InputView::process)
                .map(Coordinate::new)
                .collect(Collectors.toList());
        }
        return List.of(new Coordinate(process(input)));
    }

    private static List<Integer> process(String input) {
        String original = input;
        input = input.substring(STRING_TRIM_INDEX, input.length() - STRING_TRIM_INDEX);
        List<String> list = Arrays.asList(input.split(COORDINATE_AXIS_SEPARATOR));
        List<Integer> result = stringToIntList(list, original);
        checkValidRange(result);
        return result;
    }

    private static void checkValidRange(List<Integer> result) {
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
