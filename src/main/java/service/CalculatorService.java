package service;

import java.util.ArrayList;
import java.util.List;

import domain.Coordinate;

public abstract class CalculatorService {
    protected List<Coordinate> coordinates = new ArrayList<>();

    public CalculatorService(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public abstract double calculate();
}
