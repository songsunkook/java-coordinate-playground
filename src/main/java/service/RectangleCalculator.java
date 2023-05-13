package service;

import java.util.List;

import domain.Coordinate;

public class RectangleCalculator extends CalculatorService {
    public RectangleCalculator(List<Coordinate> coordinates) {
        super(coordinates);
    }

    @Override
    public double calculate() {
        Coordinate minCoordinate = Coordinate.min(coordinates);
        Coordinate maxCoordinate = Coordinate.max(coordinates);
        return (maxCoordinate.getXPosition() - minCoordinate.getXPosition()) * (maxCoordinate.getYPosition() - minCoordinate.getYPosition());
    }
}
