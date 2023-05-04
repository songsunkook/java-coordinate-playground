package service;

import domain.Coordinate;

public class LineCalculator extends CalculatorService {
    @Override
    public double calculate() {
        Coordinate calculatedCoordinate = coordinates.get(0).subtract(coordinates.get(1));
        double x = Math.pow(calculatedCoordinate.positionX(), 2);
        double y = Math.pow(calculatedCoordinate.positionY(), 2);
        return Math.sqrt(x + y);
    }
}
