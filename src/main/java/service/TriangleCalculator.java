package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domain.Coordinate;

public class TriangleCalculator extends CalculatorService {
    public TriangleCalculator(List<Coordinate> coordinates) {
        super(coordinates);
    }

    @Override
    public double calculate() {
        double[] len = new double[3];
        for (int i = 0; i < 3; i++) {
            List<Coordinate> coordinatesParam = setCoordinatesParam(i);
            LineCalculator lineCalculator = new LineCalculator(coordinatesParam);
            len[i] = Math.abs(lineCalculator.calculate());
        }
        double s = (Arrays.stream(len).sum()) / 2;
        return Math.sqrt(s * (s - len[0]) * (s - len[1]) * (s - len[2]));
    }

    private List<Coordinate> setCoordinatesParam(int index) {
        if (index == 2) {
            List<Coordinate> result = new ArrayList<>();
            result.add(coordinates.get(0));
            result.add(coordinates.get(2));
            return result;
        }
        return coordinates.subList(index, index + 2);
    }
}
