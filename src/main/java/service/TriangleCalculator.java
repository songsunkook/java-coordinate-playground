package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domain.Coordinate;

public class TriangleCalculator extends CalculatorService {
    private static final int TRIANGLE_COORDINATE_COUNT = 3;
    public TriangleCalculator(List<Coordinate> coordinates) {
        super(coordinates);
    }

    @Override
    public double calculate() {
        double[] len = new double[TRIANGLE_COORDINATE_COUNT];
        for (int i = 0; i < TRIANGLE_COORDINATE_COUNT; i++) {
            List<Coordinate> coordinatesParam = setCoordinatesParam(i);
            LineCalculator lineCalculator = new LineCalculator(coordinatesParam);
            len[i] = Math.abs(lineCalculator.calculate());
        }
        double valueS = (Arrays.stream(len).sum()) / 2;
        return Math.sqrt(valueS * (valueS - len[0]) * (valueS - len[1]) * (valueS - len[2]));
    }

    private List<Coordinate> setCoordinatesParam(int index) {
        if (index == 2) {
            List<Coordinate> result = new ArrayList<>();
            result.add(coordinates.get(0));
            result.add(coordinates.get(TRIANGLE_COORDINATE_COUNT - 1));
            return result;
        }
        return coordinates.subList(index, index + TRIANGLE_COORDINATE_COUNT - 1);
    }
}
