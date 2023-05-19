package ru.solarev.lesson1.controller;

import ru.solarev.lesson1.model.GameLogic;
import ru.solarev.lesson1.view.View;

import java.util.Scanner;

public class Controller {
    private final GameLogic gl;
    private View view;

    public Controller() {
        gl = new GameLogic();
        view = new View();
    }

    public void start() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        while (!answer.equals("q")){
            view.mainMenu();
            answer = scanner.nextLine();
            switch (answer){
                case "1" -> {
                        gl.runGame();
                    }
                case "2" -> {
                    System.out.println("Choice 2");
                }
            }
        }
    }
}
