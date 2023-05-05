package service;

import java.util.List;

import domain.Coordinate;

public class LineCalculator extends CalculatorService {
    public LineCalculator(List<Coordinate> coordinates) {
        super(coordinates);
    }

    @Override
    public double calculate() {
        Coordinate calculatedCoordinate = coordinates.get(0).subtract(coordinates.get(1));
        double valueX = Math.pow(calculatedCoordinate.positionX(), 2);
        double valueY = Math.pow(calculatedCoordinate.positionY(), 2);
        return Math.sqrt(valueX + valueY);
    }
}
