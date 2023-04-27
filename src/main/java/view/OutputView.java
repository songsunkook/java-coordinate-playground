package view;

import java.util.ArrayList;
import java.util.List;

import constant.OutputMessages;

public class OutputView {
    public static void outputCoordinatePlane() {
        List<String> basePlane = drawBasePlane();
    }

    private static List<String> drawBasePlane() {
        List<String> plane = new ArrayList<>();
        drawXAxis(plane);

        for (int height = 1; height <= 24 + 1; height++) {
            if (height % 2 == 0) {
                plane.add(String.format("%2d", height) + "│");
            } else {
                plane.add("  │");
            }
        }
        /* BasePlane 출력 테스트용
        for (int height = 25; height >= 0; height--) {
            System.out.println(plane.get(height));
        }*/
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

    public static void outputMessage(OutputMessages outputMessage) {
        System.out.println(outputMessage.getMessage());
    }
}
