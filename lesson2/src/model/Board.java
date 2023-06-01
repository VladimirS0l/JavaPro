package model;

import java.util.Random;

public class Board {
    
    private final String DOT_EMPTY = "*";
    private final String DOT_Player1 = "0";
    private final String DOT_Player2 = "X";

    private Random random;

    private final String[][] board;
    private CheckBoardAi cbi;

    public Board(int x, int y) {
        board = new String[x][y];
        cbi = new CheckBoardAi();
        random = new Random();
    }

    public Board(String[][] str) {
        board = str;
    }

    public String[][] initalizateBoard(int x, int y){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                board[i][j] = DOT_EMPTY;
            }
        }
        return board;
    }

    public void printBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void getOneStep(int x, int y, int numPlayer){
        if (numPlayer == 0){
            board[x][y] = DOT_Player1;
        }else {
            board[x][y] = DOT_Player2;
        }
    }

    public String[][] getBoard(){
        return board;
    }

    public void stepBotBoard(int[] playerStep, int numberPlayer, int numXO){
        String ai = numberPlayer == 0 ? "0" : "X";
        System.out.println(ai + " ai");
        int x = playerStep[0];
        int y = playerStep[1];
        int stepOnFindBoard = 1;
        if (cbi.checkOnDiagonal(board, numXO/2)) {
            while (true){
                if (cbi.checkBoundDiagonal(x - stepOnFindBoard, y + stepOnFindBoard, board)){
                    board[x - stepOnFindBoard][y + stepOnFindBoard] = ai;
                    break;
                } else if (cbi.checkBoundDiagonal(x + stepOnFindBoard, y - stepOnFindBoard, board)) {
                    board[x + stepOnFindBoard][y - stepOnFindBoard] = ai;
                    break;
                }else {
                    int a = random.nextInt(0, board.length);
                    int b = random.nextInt(0, board[0].length);
                    if (board[a][b].equals(DOT_EMPTY)){
                        board[a][b] = ai;
                        break;
                    }
                }
                stepOnFindBoard++;
            }
        } else if(cbi.checkOnMainDiagonal(board, numXO/2)){
            while (true){
                if (cbi.checkBoundDiagonal(x - stepOnFindBoard, y - stepOnFindBoard, board)){
                    board[x - stepOnFindBoard][y - stepOnFindBoard] = ai;
                    break;
                } else if (cbi.checkBoundDiagonal(x + stepOnFindBoard, y + stepOnFindBoard, board)) {
                    board[x + stepOnFindBoard][y + stepOnFindBoard] = ai;
                    break;
                }else {
                    int a = random.nextInt(0, board.length);
                    int b = random.nextInt(0, board[0].length);
                    if (board[a][b].equals(DOT_EMPTY)){
                        board[a][b] = ai;
                        break;
                    }
                }
                stepOnFindBoard++;
            }
        } else if (cbi.checkOnColumn(board, numXO/2)) {
            while (true){
                if (cbi.checkBoundDiagonal(x, y - stepOnFindBoard, board)){
                    board[x][y - stepOnFindBoard] = ai;
                    break;
                } else if (cbi.checkBoundDiagonal(x, y + stepOnFindBoard, board)) {
                    board[x][y + stepOnFindBoard] = ai;
                    break;
                }else {
                    int a = random.nextInt(0, board.length);
                    int b = random.nextInt(0, board[0].length);
                    if (board[a][b].equals(DOT_EMPTY)){
                        board[a][b] = ai;
                        break;
                    }
                }
                stepOnFindBoard++;
            }
        } else if (cbi.checkOnRow(board, numXO/2)) {
            while (true){
                if (cbi.checkBoundDiagonal(x - stepOnFindBoard, y, board)){
                    board[x - stepOnFindBoard][y] = ai;
                    break;
                } else if (cbi.checkBoundDiagonal(x + stepOnFindBoard, y, board)) {
                    board[x + stepOnFindBoard][y] = ai;
                    break;
                }else {
                    int a = random.nextInt(0, board.length);
                    int b = random.nextInt(0, board[0].length);
                    if (board[a][b].equals(DOT_EMPTY)){
                        board[a][b] = ai;
                        break;
                    }
                }
                stepOnFindBoard++;
            }
        } else {
            checkBoard(x, y, board, numXO, ai);

        }
    }

    public void checkBoard(int x, int y, String[][] board, int countXO, String ai){
        int maxValue = 0;
        int maxXindex = 0;
        int maxYindex = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].equals("*")){
                    if (maxValue < sum(x, y, board, countXO, ai)){
                        maxValue = sum(x, y, board, countXO, ai);
                        maxXindex = i;
                        maxYindex = j;
                    }
                }
            }
        }
        board[maxXindex][maxYindex] = ai;
    }


    public int checkDiag(int x, int y, String[][] board, int countXO, String ai){
        int stepOne = 1;
        int additional = 0;
        int len = board.length;
        while (true){
            if (checkBound(x - stepOne, len) && checkBound(y + stepOne, len)){
                if (board[x - stepOne][y + stepOne].equals(ai)){
                    additional++;
                } else if (board[x - stepOne][y + stepOne].equals("0")) {
                    additional--;
                }
                stepOne++;
            }else {
                break;
            }
        }
        return stepOne+additional;
    }

    public int checkCol(int x, int y, String[][] board, int countXO, String ai){
        int stepOne = 0;
        int additional = 0;
        int len = board.length;
        while (true){
            if (checkBound(y + stepOne, len)){
                if (board[x][y + stepOne].equals(ai)){
                    additional++;
                } else if (board[x][y + stepOne].equals("0")) {
                    additional--;
                }
                stepOne++;

            }else {
                break;
            }
        }
        return stepOne+additional;
    }

    public int checkMainDiag(int x, int y, String[][] board, int countXO, String ai){
        int stepOne = 0;
        int stepTwo = 0;
        int additional = 0;
        int len = board.length;
        while (true){
            if (checkBound(x + stepOne, len) && checkBound(y + stepOne, len)){
                if (board[x+stepOne][y + stepOne].equals(ai)){
                    additional++;
                } else if (board[x+stepOne][y + stepOne].equals("0")) {
                    additional--;
                }
                stepOne++;
            }else {
                break;
            }
        }
        return stepOne+additional+stepTwo;
    }

    public int checkRow(int x, int y, String[][] board, int countXO, String ai){
        int stepOne = 0;
        int stepTwo = 0;
        int additional = 0;
        int len = board.length;
        while (true){
            if (checkBound(x + stepOne, len)){
                if (board[x+ stepOne][y].equals(ai)){
                    additional++;
                } else if (board[x + stepOne][y].equals("0")) {
                    additional--;
                }
                stepOne++;
            }else {
                break;
            }
        }
        return stepOne+additional+stepTwo;
    }

    public boolean checkBound(int num, int l2){
        return num >= 0 && num < l2;
    }

    public int sum(int x, int y, String[][] board, int countXO, String ai){
        return checkCol(x, y, board, countXO, ai) + checkRow(x, y, board, countXO, ai) +
                + checkDiag(x, y, board, countXO, ai) + checkMainDiag(x, y, board, countXO, ai);
    }

}
