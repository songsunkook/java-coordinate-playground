package controller;

import view.InputView;

public class GameController {
    InputView inputView = new InputView();
    CalculatorService calculatorService = new CalculatorService();

    public void run() {
         calculatorService.inputCoordinates(inputCoordinates());
    }

    private String inputCoordinates() {
        return inputView.coordinates();
    }
}
