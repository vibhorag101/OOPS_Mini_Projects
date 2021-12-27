package com.quiz.quiz4_2020349;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.*;
import java.lang.Thread;
class rotatingRotor implements Runnable{
    static Boolean toStop = true;
    static int speedUP= 0;
    static boolean wait = true;
    Button rotor;
    Label info;
    rotatingRotor(Button rotor, Label info){
        this.rotor = rotor;
        this.info = info;
    }
    @Override
    public void run() {
        while (!toStop){
            rotor.setRotate(rotor.getRotate() + 30+speedUP);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    info.setText("rotated has rotated " +rotor.getRotate()+ " degrees so far");
                }
            });

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
