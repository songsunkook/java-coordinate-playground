package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import domain.Coordinate;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static List<Coordinate> coordinates() {
        return separatingCoordinates(scanner.nextLine());
    }

    private static List<Coordinate> separatingCoordinates(String input) {
        if (input.contains("-")) {
            List<String> splitString = Arrays.asList(input.split("-"));

            return splitString.stream()
                .map(Coordinate::new)
                .collect(Collectors.toList());
        }
        return List.of(new Coordinate(input));
    }
}
