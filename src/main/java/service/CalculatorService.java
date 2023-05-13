package service;

import java.util.List;

import constant.ConstantNumber;
import constant.ExceptionMessages;
import domain.Coordinate;

public abstract class CalculatorService {
    protected List<Coordinate> coordinates;

    protected CalculatorService(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public static CalculatorService getInstance(List<Coordinate> coordinates) {
        if (coordinates.size() <= ConstantNumber.LINE_LENGTH.getNumber()) {
            return new LineCalculator(coordinates);
        }
        if (coordinates.size() == ConstantNumber.TRIANGLE_LENGTH.getNumber()) {
            return new TriangleCalculator(coordinates);
        }
        if (coordinates.size() == ConstantNumber.RECTANGLE_LENGTH.getNumber()) {
            return new RectangleCalculator(coordinates);
        }
        throw new RuntimeException(ExceptionMessages.NUMBER_OF_INVALID_COORDINATES.getMessage());
    }

    public abstract double calculate();
}
