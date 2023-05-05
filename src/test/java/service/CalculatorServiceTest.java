package service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import domain.Coordinate;

@DisplayName("계산기에 대하여")
public class CalculatorServiceTest {
    @ParameterizedTest
    @DisplayName("정상적으로 선 길이를 구하는가")
    @MethodSource("lineProvider")
    public void lineCalculatorTest(List<Coordinate> coordinates, double wantedResult) {
        CalculatorService calculatorService = new LineCalculator(coordinates);
        assertEquals(calculatorService.calculate(), wantedResult, 0.000001);
    }

    @ParameterizedTest
    @DisplayName("정상적으로 사각형 면적을 구하는가")
    @MethodSource("rectangleProvider")
    public void rectangleCalculatorTest(List<Coordinate> coordinates, double wantedResult) {
        CalculatorService calculatorService = new RectangleCalculator(coordinates);
        assertEquals(calculatorService.calculate(), wantedResult, 0.000001);
    }

    private static Stream<Arguments> lineProvider() {
        return Stream.of(
            Arguments.of(Arrays.asList(new Coordinate(Arrays.asList(1, 2)), new Coordinate(Arrays.asList(1, 3))), 1.0),
            Arguments.of(Arrays.asList(new Coordinate(Arrays.asList(10, 10)), new Coordinate(Arrays.asList(20, 20))),
                14.142135),
            Arguments.of(Arrays.asList(new Coordinate(Arrays.asList(10, 5)), new Coordinate(Arrays.asList(20, 10))),
                11.180339)
        ).map(arguments -> Arguments.of(arguments.get()[0], arguments.get()[1]));
    }

    private static Stream<Arguments> rectangleProvider() {
        return Stream.of(
            Arguments.of(Arrays.asList(new Coordinate(Arrays.asList(1, 2)), new Coordinate(Arrays.asList(1, 3)),
                new Coordinate(Arrays.asList(3, 2)), new Coordinate(Arrays.asList(3, 3))
                ), 2.0),
            Arguments.of(Arrays.asList(new Coordinate(Arrays.asList(10, 1)), new Coordinate(Arrays.asList(20, 11)),
                new Coordinate(Arrays.asList(20, 1)), new Coordinate(Arrays.asList(10, 11))
            ), 100.0),
            Arguments.of(Arrays.asList(new Coordinate(Arrays.asList(5, 5)), new Coordinate(Arrays.asList(10, 10)),
                new Coordinate(Arrays.asList(5, 10)), new Coordinate(Arrays.asList(10, 5))
            ), 25.0)
        ).map(arguments -> Arguments.of(arguments.get()[0], arguments.get()[1]));
    }
}
