package service;

import java.util.List;

import domain.Coordinate;

public class LineCalculator extends CalculatorService {
    public LineCalculator(List<Coordinate> coordinates) {
        super(coordinates);
    }

    @Override
    public double calculate() {
        if (coordinates.size() != 2) {
            return 0;
        }
        Coordinate calculatedCoordinate = coordinates.get(0).subtract(coordinates.get(1));
        double valueX = Math.pow(calculatedCoordinate.getXPosition(), 2);
        double valueY = Math.pow(calculatedCoordinate.getYPosition(), 2);
        return Math.sqrt(valueX + valueY);
    }
}
