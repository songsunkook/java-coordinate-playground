package mapstruct;

import domain.Coordinate;
import dto.CoordinateDto;

public class CoordinateConverter {
    public static CoordinateDto toDto(Coordinate coordinate) {
        return new CoordinateDto(coordinate.getXPosition(), coordinate.getYPosition());
    }
}
