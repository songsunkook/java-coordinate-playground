package controller;

import java.util.List;

import constant.OutputMessages;
import domain.Coordinate;
import dto.CoordinateDto;
import service.CalculatorService;
import util.NumberUtil;
import view.InputView;
import view.OutputView;

public class GameController {
    private final CalculatorService calculatorService = new CalculatorService();

    public void run() {
        try {
            List<Coordinate> inputIntegers = NumberUtil.separatingCoordinates(inputCoordinates());
            outputCoordinatePlane(calculatorService.inputCoordinates(inputIntegers));
        } catch (RuntimeException exception) {
            OutputView.outputExceptionMessage(exception.getMessage());
            run();
        }
    }

    private String inputCoordinates() {
        OutputView.outputMessage(OutputMessages.INPUT_COORDINATES);
        return InputView.coordinates();
    }

    private void outputCoordinatePlane(List<CoordinateDto> coordinates) {
        OutputView.outputCoordinatePlane(coordinates);
    }
}
