package ru.solarev.lesson1.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {

    private List<Player> players;


    public GameLogic() {
        players = new ArrayList<>();

    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int choiceHowFirst(){
        System.out.println("Начинаем игру!");
        System.out.println("Первый игрок введите имя: ");
        Scanner scanner = new Scanner(System.in);
        Player player1 = new Player(scanner.nextLine());
        System.out.println("Второй игрок введите имя: ");
        Player player2 = new Player(scanner.nextLine());
        Random rnd = new Random();
        players.add(player1);
        players.add(player2);
        int choice = rnd.nextInt(0,2);
        if (choice == 0){
            return 0;
        }else {
            return 1;
        }
    }

    public void runGame() throws InterruptedException {
        int first = choiceHowFirst();
        int second = 0;
        if (first == 0){
            second = 1;
        }
        BattleShipBoard p1b1 = addBattleShipsInGame(players.get(first));
        players.get(first).addBattleShipBoard(p1b1);
        BattleShipBoard p2b1 = addBattleShipsInGame(players.get(second));
        players.get(second).addBattleShipBoard(p2b1);
        BattleShipBoard p1bGame = new BattleShipBoard();
        BattleShipBoard p2bGame = new BattleShipBoard();

        while (true){
            System.out.println("Игрок " + players.get(first).getName() + " введите координаты выстрела в формате (B1): ");
            p1bGame.print();
            addShotGun(p2b1, p1bGame, players.get(first));
            if (!p2b1.checkOnFinishGame()){
                System.out.println("Выйграл игрок: " + players.get(first).getName());
                break;
            }
            System.out.println("Игрок " + players.get(second).getName() + " введите координаты выстрела в формате (B1): ");
            p2bGame.print();
            addShotGun(p1b1, p2bGame, players.get(second));
            if (!p1b1.checkOnFinishGame()){
                System.out.println("Выйграл игрок: " + players.get(second).getName());
                break;

            }
        }
    }

    public BattleShipBoard addBattleShipsInGame(Player p1) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        BattleShipBoard bsb1 = new BattleShipBoard();
        if (players.get(0).equals(p1)) {
            System.out.println(players.get(1).getName() + " oтвернись от монитора пока " + p1.getName() +
                    " не закончит расстановку кораблей");
            Thread.sleep(3000);
        } else {
            System.out.println(players.get(0).getName() + " Отвернись от монитора пока " + p1.getName() +
                    " не закончит расстановку кораблей");
            Thread.sleep(3000);
        }
        System.out.print("\033[H\033[J");
        System.out.println(p1.getName() + " добавьте корабли!");
        bsb1.print();
        Check check = new Check();
        while (true) {
            var ch1 = check.checkOn(4);
            if (check.checkArrangement(ch1) && check.checkOfBound(ch1)) {
                bsb1.addShipFour(ch1[0], ch1[1], ch1[2], ch1[3], ch1[4], ch1[5], ch1[6], ch1[7]);
                break;
            } else {
                if (!check.checkArrangement(ch1)) {
                    System.out.println("Корабль не целый, нужно сделать правильную расстановку!");
                } else if (!check.checkOfBound(ch1)) {
                    System.out.println("Выходит за рамки карты, еще раз!");
                }
            }
        }
        bsb1.print();
        int count1 = 0;
        while (count1 < 2) {
            while (true) {
                var ch2 = check.checkOn(3);
                if (check.checkArrangement(ch2) && check.checkOfBound(ch2) && bsb1.checkOnArran(ch2)) {
                    bsb1.addShipThree(ch2[0], ch2[1], ch2[2], ch2[3], ch2[4], ch2[5]);
                    break;
                } else {
                    if (!check.checkArrangement(ch2)) {
                        System.out.println("Корабль не целый, нужно сделать правильную расстановку!");
                    } else if (!check.checkOfBound(ch2)) {
                        System.out.println("Выходит за рамки карты, еще раз!");
                    }
                    else if (!bsb1.checkOnArran(ch2)){
                        System.out.println("Корабль нарушает ореол другого корабля");
                    }
                }
            }
            count1++;
            bsb1.print();
        }

        int count2 = 0;
        while (count2 < 3) {
            while (true) {
                var ch3 = check.checkOn(2);
                if (check.checkArrangement(ch3) && check.checkOfBound(ch3) && bsb1.checkOnArran(ch3)) {
                    bsb1.addShipTwo(ch3[0], ch3[1], ch3[2], ch3[3]);
                    break;
                } else {
                    if (!check.checkArrangement(ch3)) {
                        System.out.println("Корабль не целый, нужно сделать правильную расстановку!");
                    } else if (!check.checkOfBound(ch3)) {
                        System.out.println("Выходит за рамки карты, еще раз!");
                    }else if (!bsb1.checkOnArran(ch3)){
                        System.out.println("Корабль нарушает ореол другого корабля");
                    }
                }
            }
            count2++;
            bsb1.print();
        }

        int count3 = 0;
        while (count3 < 4) {
            while (true) {
                var ch4 = check.checkOn(1);
                if (check.checkOfBound(ch4) && bsb1.checkOnArran(ch4)) {
                    bsb1.addShipOne(ch4[0], ch4[1]);
                    break;
                } else {
                    if  (!check.checkOfBound(ch4)) {
                        System.out.println("Выходит за рамки карты, еще раз!");
                    }else if (!bsb1.checkOnArran(ch4)){
                        System.out.println("Корабль нарушает ореол другого корабля");
                    }
                }
            }
            count3++;
            bsb1.print();
        }
        System.out.println("Вы расставили все корабли");
        Thread.sleep(5000);
        System.out.print("\033[H\033[J");
        return bsb1;
    }

    public void addShotGun(BattleShipBoard b1, BattleShipBoard b2, Player p1){
        Check check = new Check();
        int answ = 0;
        while (answ != 1) {
            if (!b1.checkOnFinishGame()){
                break;
            }
            var ch1 = check.checkShutGun();
            if (check.checkOfBound(ch1)) {
                answ = b1.shotGun(ch1[0], ch1[1]);
                if (answ == 4){
                    if (players.get(0) == p1){
                        System.out.println(p1.getName() + " вы уже стреляли в эту точку");
                        break;
                    }else {
                        System.out.println(players.get(1).getName() + " вы уже стреляли в эту точку");
                        break;
                    }
                }
                switch (answ){
                    case 1 -> {
                        System.out.println("Мимо");
                        b2.getBoard()[ch1[0]][ch1[1]] = "*";
                        b2.print();
                    }
                    case 2 -> {
                        System.out.println("Убил");
                        b2.getBoard()[ch1[0]][ch1[1]] = "X";
                        b2.print();
                    }
                    case 3 -> {
                        System.out.println("Попал");
                        b2.getBoard()[ch1[0]][ch1[1]] = "X";
                        b2.print();
                    }
                }
            } else {
                if  (!check.checkOfBound(ch1)) {
                    System.out.println("Выходит за рамки карты, еще раз!");
                }
            }
        }
    }
}
