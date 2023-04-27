package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import domain.Coordinate;

public class NumberUtil {
    public static List<Coordinate> separatingCoordinates(String input) {
        if (input.contains("-")) {
            List<String> splitString = Arrays.asList(input.split("-"));

            return splitString.stream()
                .map(Coordinate::new)
                .collect(Collectors.toList());
        }
        return List.of(new Coordinate(input));
    }
}
