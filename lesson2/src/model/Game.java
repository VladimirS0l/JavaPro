package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    List<Player> playerList;

    private Board board;

    public Game(int x, int y) {
        playerList = new ArrayList<>();
        board = new Board(x, y);
    }

    public String[][] runGameWithPlayer(int[] xy){
        board.initalizateBoard(xy[0], xy[1]);
        return board.getBoard();
    }

    public String[][] oneStepOnBoard(int[] xy, int num_player){
        board.getOneStep(xy[0], xy[1], num_player);
        return board.getBoard();
    }

    private Player createPlayer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваше имя: ");
        Player player = new Player(scanner.nextLine());
        return player;
    }

    public List<Player> initPlayer(){
        playerList.add(createPlayer());
        playerList.add(createPlayer());
        return playerList;
    }

    public List<Player> initPlayerAi(){
        playerList.add(createPlayer());
        Player pAi = new Player("AiBot");
        playerList.add(pAi);
        return playerList;
    }

    public void stepAi(int[] xy, int numStep, int numXO){
        board.stepBotBoard(xy, numStep, numXO);
    }

    public void printBoard(){
        board.printBoard();
    }
}
