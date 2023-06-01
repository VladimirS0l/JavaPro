package view;

import model.Player;

import java.util.Scanner;

public class View {
    Scanner scanner;
    Check check;

    public View() {
        scanner = new Scanner(System.in);
        check = new Check();
    }

    public String mainMenu(){
        System.out.println("""
                
                1 - Играть в крестики нолики с Человеком
                2 - Играть в крестики нолики c Ботом
                3 - Посмотреть результаты
                
                q - выход из игры
                
                """);
        return scanner.nextLine();
    }

    public String firstPlayer(Player player){
        return "По результатам жеребьевки " + player.getName() + " начинает первым\n";
    }

    public void count0X(int n){
        System.out.println("Вам нужно собрать: " + n + " в ряд 'X' или '0' ");
    }

    public int[] getSizeBoard(){
        String str = "";
        do{
            System.out.println("Введите Х и У в формате '(Формат: 3 3) и не более 10' >>> ");
            str = scanner.nextLine();
        }while (!check.checkBoardSize(str) || !check.checkNoMore10(str));
        String[] sizeBoard = str.split(" ");
        int[] xy = new int[2];
        xy[0] = Integer.parseInt(sizeBoard[0]);
        xy[1] = Integer.parseInt(sizeBoard[1]);
        return xy;
    }

    public int[] makeOneStep(Player player, String[][] board){
        String str = "";
        do{
            System.out.println(player.getName() + " введите Х и У '(Формат: 3 3) и не более 10' >>> ");
            str = scanner.nextLine();
        }while (!check.checkBoardSize(str) || !check.checkStep(str, board));
        String[] sizeBoard = str.split(" ");
        int[] xy = new int[2];
        xy[0] = Integer.parseInt(sizeBoard[0]) - 1;
        xy[1] = Integer.parseInt(sizeBoard[1]) - 1;
        return xy;
    }

    public int checkOnWinner(Player player, String[][] board, int num){
        if (check.checkOnColumn(board, num) || check.checkOnRow(board, num) || check.checkOnDiagonal(board, num) ||
                check.checkOnMainDiagonal(board, num)){
            System.out.println(player.getName() + " выйграл в этой Игре!");
            return 1;
        }
        if (!check.checkOnFinishNotWinner(board)){
            return 2;
        }
        return 3;
    }

    public void runGame(){
        System.out.println("Игра началась!");
    }





}
