package controller;


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

import java.util.List;

public class GameController {
    private CalculatorService calculatorService;

    public void run() {
        try {
            List<Coordinate> inputIntegers = NumberUtil.separatingCoordinates(inputCoordinates());
            //TODO 조건문 메서드로 분리
            if (inputIntegers.size() <= 2) {
                calculatorService = new LineCalculator(inputIntegers);
            }
            if (inputIntegers.size() == 3) {
                calculatorService = new TriangleCalculator(inputIntegers);
            }
            if (inputIntegers.size() == 4) {
                calculatorService = new RectangleCalculator(inputIntegers);
            }
            //TODO domainToDto -> toDto
            outputCoordinatePlane(calculatorService.domainToDto(inputIntegers));
            //TODO 결과 출력 문구
            outputCalculateResult(calculatorService.calculate(), inputIntegers.size());
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

    private void outputCalculateResult(double result, int size) {
        if(size == 2) {
            OutputView.resultLine(result);
        }
        if(size == 4) {
            OutputView.resultRectangle(result);
        }
    }
}
