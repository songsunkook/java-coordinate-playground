package controller;

import view.InputView;

public class GameController {
    InputView inputView = new InputView();

    public void run() {
        inputCoordinates();
    }

    private void inputCoordinates() {
        inputView.coordinates();
    }
}
