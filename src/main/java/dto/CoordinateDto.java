package dto;

public class CoordinateDto {
    private int xPosition;
    private int yPosition;

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
