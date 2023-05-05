package service;

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
            List<Coordinate> coordinatesParam = coordinates.subList(0, 3);
            LineCalculator lineCalculator = new LineCalculator(coordinatesParam);
            len[i] = Math.abs(lineCalculator.calculate());
        }
        double s = (Arrays.stream(len).sum()) / 2;
        return Math.sqrt(s * (s - len[0]) * (s - len[1]) * (s - len[2]));
    }
}
