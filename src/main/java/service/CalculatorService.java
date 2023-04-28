package service;

import java.util.List;
import java.util.stream.Collectors;

import domain.Coordinate;
import dto.CoordinateDto;

public abstract class CalculatorService {
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
