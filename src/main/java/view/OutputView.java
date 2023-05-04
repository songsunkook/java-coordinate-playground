package view;

import constant.OutputMessages;
import dto.CoordinateDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {
    public static void outputCoordinatePlane(List<CoordinateDto> coordinates) {
        List<String> basePlane = drawBasePlane();
        coordinates = coordinates;

        drawCoordinate(basePlane, coordinates);
        printPlane(basePlane);
    }

    private static void drawCoordinate(List<String> plane, List<CoordinateDto> coordinates) {
        for (CoordinateDto coordinate : coordinates) {
            int xPos = coordinate.positionX();
            int yPos = coordinate.positionY();

            plane.set(yPos + 1,
                plane.get(yPos + 1).substring(0, (xPos + 1) * 2)
                    + " ●"
                    + plane.get(yPos + 1).substring((xPos + 1) * 2 + 2)
            );
        }
    }

    private static List<String> drawBasePlane() {
        List<String> plane = new ArrayList<>();
        drawXAxis(plane);

        for (int height = 1; height <= 24; height++) {
            if (height % 2 == 0) {
                plane.add(String.format("%2d", height) + "│" + " ".repeat(24 * 2));
            } else {
                plane.add("  │" + " ".repeat(24 * 2));
            }
        }

        return plane;
    }

    private static void drawXAxis(List<String> plane) {
        StringBuilder xAxis = new StringBuilder();
        for (int width = 1; width <= 24; width++) {
            if (width % 2 == 0) {
                xAxis.append(String.format("%2d", width));
            } else {
                xAxis.append("  ");
            }
        }
        plane.add(" 0  " + xAxis);

        plane.add("  +" + "─".repeat(24 * 2));
    }

    private static void printPlane(List<String> plane) {
        List<String> clone = new ArrayList<>(plane);
        Collections.reverse(clone);

        for (String line : clone) {
            System.out.println(line);
        }
    }

    public static void outputMessage(OutputMessages outputMessage) {
        System.out.println(outputMessage.getMessage());
    }

    public static void outputExceptionMessage(String message) {
        System.out.println(message);
    }

    public static void resultLine(double result) {
        System.out.println(OutputMessages.OUTPUT_LINE.getMessage(result));
    }
}
