package com.quiz.quiz4_2020349;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    Boolean toStop = true;
    int speedUP = 0;
    boolean isFirst = true;
    @FXML
    private Button rotor;
    @FXML
    private Button rotator;

    @FXML
    private Label rotateInfo;

    @FXML
    public void rotate() {
        /*
            This creates multiple threads so the rotor rotates faster
            each time rotate is pressed as a new thread is created which causes an
            extra 30 degrees
            The implementation contains a different approach in which thread is created
            only after the first time rotate is pressed. And we check for this and increase
            the angle of rotation.
            Thread t = new Thread(new rotatingRotor(rotor, rotateInfo));
            t.start();
         */
        if (isFirst) {
            Thread t = new Thread(new rotatingRotor(rotor, rotateInfo));
            t.start();
        } else {
            speedUP = speedUP + 15;
        }
        rotatingRotor.toStop = false;
        rotatingRotor.wait = false;
        isFirst = false;
        rotatingRotor.speedUP = speedUP;
    }

    @FXML
    public void stopRotate() {
        rotatingRotor.toStop = true;
        speedUP = 0;
        isFirst = true;

    }

}