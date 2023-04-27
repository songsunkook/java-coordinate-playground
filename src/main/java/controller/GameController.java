package controller;

import java.util.List;

import constant.OutputMessages;
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
        OutputView.outputMessage(OutputMessages.INPUT_COORDINATES);
        return InputView.coordinates();
    }

    private void outputCoordinatePlane() {
        OutputView.outputCoordinatePlane();
    }
}
