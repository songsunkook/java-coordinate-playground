package controller;

import java.util.ArrayList;
import java.util.List;

import constant.OutputMessages;
import domain.Coordinate;
import dto.CoordinateDto;
import mapstruct.CoordinateConverter;
import service.CalculatorService;
import service.LineCalculator;
import service.RectangleCalculator;
import service.TriangleCalculator;
import util.NumberUtil;
import view.InputView;
import view.OutputView;

public class GameController {
    public void run() {
        try {
            List<Coordinate> inputIntegers = NumberUtil.separatingCoordinates(inputCoordinates());
            CalculatorService calculatorService = selectCalculatorService(inputIntegers);
            printCoordinatePlane(inputIntegers);
            outputCalculateResult(calculatorService.calculate(), inputIntegers.size());
        } catch (RuntimeException exception) {
            OutputView.outputExceptionMessage(exception.getMessage());
            run();
        }
    }

    private CalculatorService selectCalculatorService(List<Coordinate> inputIntegers) {
        if (inputIntegers.size() <= 2) {
            return new LineCalculator(inputIntegers);
        }
        if (inputIntegers.size() == 3) {
            return new TriangleCalculator(inputIntegers);
        }
        if (inputIntegers.size() == 4) {
            return new RectangleCalculator(inputIntegers);
        }
        throw new RuntimeException("좌표의 개수가 잘못되었습니다.");
    }

    private void printCoordinatePlane(List<Coordinate> coordinates) {
        List<CoordinateDto> coordinateDtos = new ArrayList<>();
        for (Coordinate coordinate : coordinates) {
            coordinateDtos.add(CoordinateConverter.toDto(coordinate));
        }
        outputCoordinatePlane(coordinateDtos);
    }

    private String inputCoordinates() {
        OutputView.outputMessage(OutputMessages.INPUT_COORDINATES);
        return InputView.coordinates();
    }

    private void outputCoordinatePlane(List<CoordinateDto> coordinates) {
        OutputView.outputCoordinatePlane(coordinates);
    }

    private void outputCalculateResult(double result, int size) {
        if (size == 2) {
            OutputView.resultLine(result);
        }
        if (size == 3) {
            OutputView.resultTriangle(result);
        }
        if (size == 4) {
            OutputView.resultRectangle(result);
        }
    }
}
