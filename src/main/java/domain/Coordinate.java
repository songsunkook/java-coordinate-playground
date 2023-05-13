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
        Coordinate callerX = coordinates.stream()
            .reduce((a,b) -> (a.getXPosition() > b.getXPosition() ? a : b)).get();
        Coordinate callerY = coordinates.stream()
            .reduce((a,b) -> (a.getYPosition() > b.getYPosition() ? a : b)).get();
        return new Coordinate(Arrays.asList(callerX.xPosition, callerY.yPosition));
    }

    public static Coordinate min(List<Coordinate> coordinates) {
        Coordinate callerX = coordinates.stream()
            .reduce((a,b) -> (a.getXPosition() > b.getXPosition() ? b : a)).get();
        Coordinate callerY = coordinates.stream()
            .reduce((a,b) -> (a.getYPosition() > b.getYPosition() ? b : a)).get();
        return new Coordinate(Arrays.asList(callerX.xPosition, callerY.yPosition));
    }
}
