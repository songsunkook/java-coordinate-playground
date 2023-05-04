package service;

import domain.Coordinate;
import dto.CoordinateDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class CalculatorService {
    protected List<Coordinate> coordinates = new ArrayList<>();

    public List<CoordinateDto> domainToDto(List<Coordinate> coordinate) {
        return coordinate.stream()
            .map(Coordinate::toDto)
            .collect(Collectors.toList());
    }

    private List<Coordinate> dtoToDomain(List<CoordinateDto> coordinateDto) {
        return coordinateDto.stream()
            .map(Coordinate::toDomain)
            .collect(Collectors.toList());
    }

    public abstract double calculate();
}
