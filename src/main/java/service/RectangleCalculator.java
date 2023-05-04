package service;

import domain.Coordinate;

import java.util.List;

public class RectangleCalculator extends CalculatorService {
    public RectangleCalculator(List<Coordinate> coordinates) {
        super(coordinates);
    }

    @Override
    public double calculate() {
        return coordinates.get(0).multiply(coordinates.get(1));
    }
}
