package service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import domain.Coordinate;

@DisplayName("계산기에 대하여")
public class CalculatorServiceTest {
    @ParameterizedTest
    @DisplayName("정상적으로 선 길이를 구하는가")
    @MethodSource("parameter.TestParameter#lineProvider")
    public void lineCalculatorTest(List<Coordinate> coordinates, double wantedResult) {
        CalculatorService calculatorService = new LineCalculator(coordinates);
        assertEquals(calculatorService.calculate(), wantedResult, 0.001);
    }

    @ParameterizedTest
    @DisplayName("정상적으로 삼각형 면적을 구하는가")
    @MethodSource("parameter.TestParameter#triangleProvider")
    public void triangleCalculatorTest(List<Coordinate> coordinates, double wantedResult) {
        CalculatorService calculatorService = new TriangleCalculator(coordinates);
        assertEquals(calculatorService.calculate(), wantedResult, 0.001);
    }

    @ParameterizedTest
    @DisplayName("정상적으로 사각형 면적을 구하는가")
    @MethodSource("parameter.TestParameter#rectangleProvider")
    public void rectangleCalculatorTest(List<Coordinate> coordinates, double wantedResult) {
        CalculatorService calculatorService = new RectangleCalculator(coordinates);
        assertEquals(calculatorService.calculate(), wantedResult, 0.001);
    }
}
