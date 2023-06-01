package view;

public class Check {
    public boolean checkBoardSize(String str){
        return str.matches("[1-9]}*\\s[1-9]*");
    }

    public boolean checkNoMore10(String str){
        String[] sizeBoard = str.split(" ");
        int[] xy = new int[2];
        xy[0] = Integer.parseInt(sizeBoard[0]);
        xy[1] = Integer.parseInt(sizeBoard[1]);
        return xy[0] <= 10 || xy[1] <= 10;
    }

    public boolean checkStep(String str, String[][] board){
        boolean flag = true;
        String[] sizeBoard = str.split(" ");
        int[] xy = new int[2];
        xy[0] = Integer.parseInt(sizeBoard[0]) - 1;
        xy[1] = Integer.parseInt(sizeBoard[1]) - 1;
        if (!(xy[0] < board.length) || !(xy[1] < board[0].length)){
            System.out.println("Ваши координаты выходят за пределы доски");
            return flag = false;
        }
        if (!board[xy[0]][xy[1]].equals("*")){
            System.out.println("Этот квадрат уже занят, попробуйте снова");
            return flag = false;
        }
        return flag;
    }

    public boolean checkOnFinishNotWinner(String[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].equals("*")) return true;
            }
        }
        return false;
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
}
