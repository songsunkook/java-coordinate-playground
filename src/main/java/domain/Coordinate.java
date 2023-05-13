package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Coordinate {
    private final int xPosition;
    private final int yPosition;

    public Coordinate(List<Integer> numbers) {
        xPosition = numbers.get(0);
        yPosition = numbers.get(1);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (!(object instanceof Coordinate))
            return false;
        Coordinate that = (Coordinate)object;
        return xPosition == that.xPosition && yPosition == that.yPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xPosition, yPosition);
    }

    public Coordinate subtract(Coordinate target) {
        List<Integer> argument = Arrays.asList(xPosition - target.xPosition, yPosition - target.yPosition);
        return new Coordinate(argument);
    }

    public double multiply(Coordinate target) {
        return (xPosition - target.xPosition) * (yPosition - target.yPosition);
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public static Coordinate max(List<Coordinate> coordinates) {
        int maxX = coordinates.stream()
            .mapToInt(Coordinate::getXPosition)
            .max()
            .orElseThrow(() -> new RuntimeException("좌표가 없습니다."));
        int maxY = coordinates.stream()
            .mapToInt(Coordinate::getYPosition)
            .max()
            .orElseThrow(() -> new RuntimeException("좌표가 없습니다."));
        return new Coordinate(Arrays.asList(maxX, maxY));
    }

    public static Coordinate min(List<Coordinate> coordinates) {
        int minX = coordinates.stream()
            .mapToInt(Coordinate::getXPosition)
            .min()
            .orElseThrow(() -> new RuntimeException("좌표가 없습니다."));
        int minY = coordinates.stream()
            .mapToInt(Coordinate::getYPosition)
            .min()
            .orElseThrow(() -> new RuntimeException("좌표가 없습니다."));
        return new Coordinate(Arrays.asList(minX, minY));
    }



}
