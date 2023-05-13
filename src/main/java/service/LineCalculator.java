package service;

import java.util.List;

import domain.Coordinate;

public class LineCalculator extends CalculatorService {
    private static final int LINE_COORDINATE_COUNT = 2;

    public LineCalculator(List<Coordinate> coordinates) {
        super(coordinates);
    }

    @Override
    public double calculate() {
        if (coordinates.size() != LINE_COORDINATE_COUNT) {
            return 0;
        }
        Coordinate calculatedCoordinate = coordinates.get(0).subtract(coordinates.get(1));
        double valueX = Math.pow(calculatedCoordinate.getXPosition(), 2);
        double valueY = Math.pow(calculatedCoordinate.getYPosition(), 2);
        return Math.sqrt(valueX + valueY);
    }
}
