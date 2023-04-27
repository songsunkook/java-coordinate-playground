package controller;

import util.NumberUtil;

public class GameController {
    InputView inputView = new InputView();

    public void run() {
        inputCoordinates();
    }

    private void inputCoordinates() {
        inputView.coordinates();
    }
}
