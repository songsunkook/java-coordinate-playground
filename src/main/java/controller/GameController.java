package controller;

import java.util.List;

import constant.OutputMessages;
import domain.Coordinate;
import dto.CoordinateDto;
import service.CalculatorService;
import service.LineCalculator;
import service.RectangleCalculator;
import service.TriangleCalculator;
import util.NumberUtil;
import view.InputView;
import view.OutputView;

public class GameController {
    private CalculatorService calculatorService;

    public void run() {
        try {
            List<Coordinate> inputIntegers = NumberUtil.separatingCoordinates(inputCoordinates());

            if (inputIntegers.size() <= 2) {
                calculatorService = new LineCalculator();
            }
            if (inputIntegers.size() == 3) {
                calculatorService = new TriangleCalculator();
            }
            if (inputIntegers.size() == 4) {
                calculatorService = new RectangleCalculator();
            }

            outputCoordinatePlane(calculatorService.domainToDto(inputIntegers));
            //TODO 결과 출력 문구
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
