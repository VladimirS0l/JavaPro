package ru.solarev.lesson1.model;

public class BattleShipBoard {
    private String[][] board;

    public BattleShipBoard() {
        board = new String[][]{
                {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
                {"A", "-", "-", "-", "-" , "-", "-", "-", "-", "-", "-"},
                {"B", "-", "-", "-", "-" , "-", "-", "-", "-", "-", "-"},
                {"C", "-", "-", "-", "-" , "-", "-", "-", "-", "-", "-"},
                {"D", "-", "-", "-", "-" , "-", "-", "-", "-", "-", "-"},
                {"E", "-", "-", "-", "-" , "-", "-", "-", "-", "-", "-"},
                {"F", "-", "-", "-", "-" , "-", "-", "-", "-", "-", "-"},
                {"G", "-", "-", "-", "-" , "-", "-", "-", "-", "-", "-"},
                {"H", "-", "-", "-", "-" , "-", "-", "-", "-", "-", "-"},
                {"I", "-", "-", "-", "-" , "-", "-", "-", "-", "-", "-"},
                {"J", "-", "-", "-", "-" , "-", "-", "-", "-", "-", "-"}
        };
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public void addShipFour(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
        board[x1][y1] = "K";
        board[x2][y2] = "K";
        board[x3][y3] = "K";
        board[x4][y4] = "K";
        addOnFreeOreol(x1, y1);
        addOnFreeOreol(x2, y2);
        addOnFreeOreol(x3, y3);
        addOnFreeOreol(x4, y4);
    }

    public void addShipThree(int x1, int y1, int x2, int y2, int x3, int y3){
        board[x1][y1] = "K";
        board[x2][y2] = "K";
        board[x3][y3] = "K";
        addOnFreeOreol(x1, y1);
        addOnFreeOreol(x2, y2);
        addOnFreeOreol(x3, y3);
    }

    public void addShipTwo(int x1, int y1, int x2, int y2){
        board[x1][y1] = "K";
        board[x2][y2] = "K";
        addOnFreeOreol(x1, y1);
        addOnFreeOreol(x2, y2);
    }

    public void addShipOne(int x1, int y1){
        board[x1][y1] = "K";
        addOnFreeOreol(x1, y1);
    }

    public void print(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.printf(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int shotGun(int x1, int y1){
        int answer = 0;
        int count = 0;
        if (board[x1][y1].equals("-") || board[x1][y1].equals("^")){
            board[x1][y1] = "*";
            answer = 1;
//            System.out.println("МИМО!");
        } else if (board[x1][y1].equals("K")){

            //   2 1 2 2 2 3 2 4
            //   2 4 2 5
            for (int i = y1; i < board.length; i++) {
                if (board[x1][i].equals("K")) {
                    board[x1][y1] = "X";
                    count++;
                } else if (board[x1][i].equals("^")) {
                    break;
                }
            }
            for (int j = y1; j > 0; j--) {
                if (board[x1][j].equals("K")) {
                    board[x1][y1] = "X";
                    count++;
                } else if (board[x1][j].equals("^")) {
                    break;
                }
            }
            for (int k = x1; k < board.length; k++) {
                if (board[k][y1].equals("K")) {
                    board[x1][y1] = "X";
                    count++;
                } else if (board[k][y1].equals("^")) {
                    break;
                }
            }
            for (int t = x1; t > 0; t--) {
                if (board[t][y1].equals("K")) {
                    board[x1][y1] = "X";
                    count++;
                } else if (board[t][y1].equals("^")) {
                    break;
                }
            }
            if (count > 1){
                answer = 3;
                //Попал
            }else {
                answer = 2;
                //Убил
            }
        }else {
            board[x1][y1] = "X";
            answer = 4;
            //Вы уже стреляли в эту точку
        }
        return answer;
    }

    public void addOnFreeOreol(int one, int two){
        if (one + 1 < 11 && one + 1 > 0){
            if (!board[one+1][two].equals("K")){board[one+1][two] = "^";}
        }
        if (one - 1 < 11 && one - 1 > 0){
            if (!board[one-1][two].equals("K")){board[one-1][two] = "^";}
        }
        if (two + 1 < 11 && two + 1 > 0) {
            if (!board[one][two + 1].equals("K")) {board[one][two + 1] = "^";}
        }
        if (two - 1 < 11 && two - 1 > 0){
            if (!board[one][two-1].equals("K")){board[one][two-1] = "^";}
        }
        if (one + 1 < 11 && one + 1 > 0 && two + 1 < 11){
            if (!board[one+1][two+1].equals("K")){board[one+1][two+1] = "^";}
        }
        if ((one + 1 < 11 && one + 1 > 0) && (two - 1 < 11 && two - 1 > 0)){
            if (!board[one+1][two-1].equals("K")){board[one+1][two-1] = "^";}
        }
        if (one - 1 < 11 && one - 1 > 0 && two + 1 < 11){
            if (!board[one-1][two+1].equals("K")){board[one-1][two+1] = "^";}
        }
        if ((one - 1 < 11 && one - 1 > 0) && (two - 1 < 11 && two - 1 > 0)){
            if (!board[one-1][two-1].equals("K")){board[one-1][two-1] = "^";}
        }
    }

    public boolean checkOnArran(int[] arr){
        boolean error = true;
        for (int i = 0; i < arr.length; i+=2) {
            if (board[arr[i]][arr[i + 1]].equals("K") || board[arr[i]][arr[i + 1]].equals("^")) {
                error = false;
                break;
            }
        }
        return error;
    }

    public boolean checkOnFinishGame(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals("K")){
                    return true;
                }
            }
        }
        return false;
    }
}
