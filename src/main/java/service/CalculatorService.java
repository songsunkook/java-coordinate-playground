package service;

import java.util.List;
import java.util.stream.Collectors;

import domain.Coordinate;
import dto.CoordinateDto;

public class CalculatorService {
    public List<CoordinateDto> inputCoordinates(List<Coordinate> coordinate) {
        return coordinate.stream()
            .map(Coordinate::toDto)
            .collect(Collectors.toList());
    }
}
