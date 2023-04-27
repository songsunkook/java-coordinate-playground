package controller;

import java.util.List;

import service.CalculatorService;
import util.NumberUtil;
import view.InputView;
import view.OutputView;

public class GameController {
    private final CalculatorService calculatorService = new CalculatorService();

    public void run() {
        List<Integer> inputIntegers = NumberUtil.separatingCoordinates(inputCoordinates());
        calculatorService.inputCoordinates(inputIntegers);
    }

    private String inputCoordinates() {
        return InputView.coordinates();
    }

    private void outputCoordinatePlane() {
        OutputView.outputCoordinatePlane();
    }
}
