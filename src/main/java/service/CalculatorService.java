package service;

import java.util.List;

import domain.Coordinate;

public abstract class CalculatorService {
    protected List<Coordinate> coordinates;

    public CalculatorService(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public abstract double calculate();
}
