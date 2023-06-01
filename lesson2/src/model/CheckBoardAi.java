package model;

public class CheckBoardAi {

    public CheckBoardAi() {
    }

    public boolean checkOnColumn(String[][] board, int countB){
        boolean flag = false;
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].equals("X")) {
                    countX++;
                }else {
                    countX = 0;
                }
                if (board[i][j].equals("0")) {
                    countO++;
                }else {
                    countO = 0;
                }
                if (countX == countB || countO == countB){
                    flag = true;
                    break;
                }
            }
            if (flag){
                break;
            }
            countX = 0;
            countO = 0;
        }
        return flag;
    }

    public boolean checkOnRow(String[][] board, int countB){
        boolean flag = false;
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[j][i].equals("X")){
                    countX++;
                }else {
                    countX = 0;
                }
                if (board[j][i].equals("0")){
                    countO++;
                }else {
                    countO = 0;
                }
                if (countX == countB || countO == countB) {
                    flag = true;
                    break;
                }
            }
            countX = 0;
            countO = 0;
            if (flag){
                break;
            }
        }
        return flag;
    }

    public boolean checkOnMainDiagonal(String[][] board, int countB){
        boolean flag = false;
        int countX = 0;
        int countO = 0;
        int step = 0;
        while (step < board.length){
            if (board[step][step].equals("X")){
                countX++;
            }else {
                countX = 0;
            }
            if (board[step][step].equals("0")){
                countO++;
            }else {
                countO = 0;
            }
            if (countX  == countB || countO == countB){
                flag = true;
                break;
            }
            step++;
        }
        return flag;
    }

    public boolean checkOnDiagonal(String[][] board, int countB){
        boolean flag = false;
        int countX = 0;
        int countO = 0;
        int step = 0;
        int step2 = Math.min(board.length, board[0].length) - 1;
        while (step < Math.min(board.length, board[0].length)){
            if (board[step][step2].equals("X")){
                countX++;
            } else {
                countX = 0;
            }
            if (board[step][step2].equals("0")){
                countO++;
            } else {
                countO = 0;
            }
            if (countX  == countB || countO == countB){
                flag = true;
                break;
            }
            step++;
            step2--;
        }
        return flag;
    }

    public boolean checkBoundDiagonal(int x, int y, String[][] board){
        if ((x >= 0 && x < board.length) && (y >= 0 && y < board.length) && board[x][y].equals("*")){
            return true;
        }
        return false;
    }
}
