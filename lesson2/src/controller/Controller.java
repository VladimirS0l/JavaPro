package controller;

import model.Game;
import model.Player;
import view.View;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Controller {
    private final View view;
    private final Scanner scanner;
    private Random random;

    public Controller() {
        view = new View();
        scanner = new Scanner(System.in);
        random = new Random();
    }

    public void appStart(){

        String userChoice = "";
        while (!userChoice.equals("q")){
            userChoice = view.mainMenu();
            switch (userChoice){
                case "1" -> playerVsPlayer();
                case "2" -> playerVsAi();
                case "3" -> System.out.println("Scores");
                case "q" -> System.out.println("Bye");
            }
        }
    }

    public void playerVsPlayer(){
        view.runGame();
        int[] xy = view.getSizeBoard();
        int x = xy[0];
        int y = xy[1];
        int sizeXO = 3;
        if (x > 5 && y > 5){
            sizeXO = x > y ? y -2 : x-2;
        }
        view.count0X(sizeXO);
        Game game = new Game(x, y);
        List<Player> pl = game.initPlayer();
        int first = random.nextInt(0, 2);
        int second = (first == 0 ? 1 : 0);
        view.firstPlayer(pl.get(first));
        String[][] board = game.runGameWithPlayer(xy);
        while (true){
            game.printBoard();
            game.oneStepOnBoard(view.makeOneStep(pl.get(first), board), first);
            if (view.checkOnWinner(pl.get(first), board, sizeXO) == 1 ||
                    view.checkOnWinner(pl.get(first), board, sizeXO) == 2){
                break;
            }
            game.printBoard();
            game.oneStepOnBoard(view.makeOneStep(pl.get(second), board), second);
            if (view.checkOnWinner(pl.get(second), board, sizeXO) == 1 ||
                    view.checkOnWinner(pl.get(second), board, sizeXO) == 2){
                break;
            }

        }
    }

    public void playerVsAi(){
        view.runGame();
        int[] xy = view.getSizeBoard();
        int x = xy[0];
        int y = xy[1];
        int sizeXO = 3;
        if (x > 5 && y > 5){
            sizeXO = x > y ? y -2 : x-2;
        } else if (x == 5) {
            sizeXO = 4;
        }
        view.count0X(sizeXO);
        Game game = new Game(x, y);
        List<Player> pl = game.initPlayerAi();
        int first = random.nextInt(0, 2);
        int second = (first == 0 ? 1 : 0);
        view.firstPlayer(pl.get(first));
        String[][] board = game.runGameWithPlayer(xy);
        int[] player = new int[2];
        while (true){
            if (pl.get(first).getName().equals("AiBot")){
                game.stepAi(player, first, sizeXO);
                if (view.checkOnWinner(pl.get(first), board, sizeXO) == 1 ||
                        view.checkOnWinner(pl.get(first), board, sizeXO) == 2) {
                    break;
                }
                game.printBoard();
                player = view.makeOneStep(pl.get(second), board);
                game.oneStepOnBoard(player, second);
                if (view.checkOnWinner(pl.get(second), board, sizeXO) == 1 ||
                        view.checkOnWinner(pl.get(second), board, sizeXO) == 2){
                    break;
                }
            }else {
                game.printBoard();
                player = (view.makeOneStep(pl.get(first), board));
                game.oneStepOnBoard(player, first);
                if (view.checkOnWinner(pl.get(first), board, sizeXO) == 1 ||
                        view.checkOnWinner(pl.get(first), board, sizeXO) == 2){
                    break;
                }
                game.stepAi(player, second, sizeXO);
                if (view.checkOnWinner(pl.get(second), board, sizeXO) == 1 ||
                        view.checkOnWinner(pl.get(second), board, sizeXO) == 2){
                    break;
                }
            }
        }
    }
}
