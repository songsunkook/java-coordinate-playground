package controller;

import java.util.ArrayList;
import java.util.List;

import constant.ConstantNumber;
import constant.OutputMessages;
import domain.Coordinate;
import dto.CoordinateDto;
import mapstruct.CoordinateConverter;
import service.CalculatorService;
import view.InputView;
import view.OutputView;

public class GameController {
    public void run() {
        try {
            List<Coordinate> inputIntegers = inputCoordinates();
            CalculatorService calculatorService = CalculatorService.getInstance(inputIntegers);
            printCoordinatePlane(inputIntegers);
            outputCalculateResult(calculatorService.calculate(), inputIntegers.size());
        } catch (RuntimeException exception) {
            OutputView.outputExceptionMessage(exception.getMessage());
            run();
        }
    }

    private void printCoordinatePlane(List<Coordinate> coordinates) {
        List<CoordinateDto> coordinateDtos = new ArrayList<>();
        for (Coordinate coordinate : coordinates) {
            coordinateDtos.add(CoordinateConverter.toDto(coordinate));
        }
        outputCoordinatePlane(coordinateDtos);
    }

    private List<Coordinate> inputCoordinates() {
        OutputView.outputMessage(OutputMessages.INPUT_COORDINATES);
        return InputView.coordinates();
    }

    private void outputCoordinatePlane(List<CoordinateDto> coordinates) {
        OutputView.outputCoordinatePlane(coordinates);
    }

    private void outputCalculateResult(double result, int size) {
        if (size == ConstantNumber.LINE_LENGTH.getNumber()) {
            OutputView.resultLine(result);
        }
        if (size == ConstantNumber.TRIANGLE_LENGTH.getNumber()) {
            OutputView.resultTriangle(result);
        }
        if (size == ConstantNumber.RECTANGLE_LENGTH.getNumber()) {
            OutputView.resultRectangle(result);
        }
    }
}
