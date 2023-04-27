package dto;

public class CoordinateDto {
    private int xPos;
    private int yPos;

    public CoordinateDto(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int positionX() {
        return xPos;
    }

    public int positionY() {
        return yPos;
    }
}
