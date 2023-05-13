package dto;

public class CoordinateDto {
    private final int xPosition;
    private final int yPosition;

    public CoordinateDto(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }
}
