package ru.solarev.lesson1.model;

import java.util.*;

public class Check {
    Scanner scanner;
    private HashMap<Character, Integer> abc;

    public Check() {
        scanner = new Scanner(System.in);
        abc = new HashMap<>();
        abc.put('A', 1);
        abc.put('B', 2);
        abc.put('C', 3);
        abc.put('D', 4);
        abc.put('E', 5);
        abc.put('F', 6);
        abc.put('G', 7);
        abc.put('H', 8);
        abc.put('I', 9);
        abc.put('J', 10);
    }

    public int[] checkOn(int shipCount){
        switch (shipCount){
            case 1 -> System.out.println("Введите координаты однопалубного корабля в формате (В1): ");
            case 2 -> System.out.println("Введите координаты двухпалубного корабля в формате (В1 А4): ");
            case 3 -> System.out.println("Введите координаты трехпалубного корабля в формате (В1 А4 С5): ");
            case 4 -> System.out.println("Введите координаты четырехпалубного корабля в формате (В1 А4 С5 D1): ");
        }
        String[] str1 = scanner.nextLine().split(" ");
        int[] arr = new int[shipCount*2];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0){
                while (true){
                    try{
                        arr[i] = abc.get(str1[count].charAt(0));
                        break;
                    }catch (Exception ex){
                        System.out.println("Неверный ввод буквы");
                        str1 = scanner.nextLine().split(" ");
                    }
                }
            }else {
                while (true){
                    try{
                        if (Integer.parseInt(str1[count].replaceAll("[^0-9]", "")) < 11 &&
                                Integer.parseInt(str1[count].replaceAll("[^0-9]", "")) > 0){
                            arr[i] = Integer.parseInt(str1[count].replaceAll("[^0-9]", ""));
                            break;
                        } else {
                            System.out.println("Вы должны ввести число от 0 до 11");
                            str1 = scanner.nextLine().split(" ");
                        }
                    }catch (Exception ex){
                        System.out.println("Вы должны ввести число от 0 до 11");
                        str1 = scanner.nextLine().split(" ");
                    }
                }
                count++;
            }
        }
        return arr;
    }

    public boolean checkArrangement(int[] arr){
        boolean flag1 = false;
        boolean flag2 = false;
        int even = arr[0];
        int odd = arr[1];
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0){
                flag1 = arr[i] == even;
                arr1.add(arr[i]);
            }else {
                flag2 = arr[i] == odd;
                arr2.add(arr[i]);
            }
        }
        boolean flag3 = false;
        if (!flag1){
            arr1.stream().sorted();
            int min = arr1.get(0);
            for (int i = 0; i < arr1.size(); i++) {
                if (min + i == arr1.get(i)){
                    flag3 = true;
                }else {
                    flag3 = false;
                }
            }
        }
        boolean flag4 = false;
        if (!flag2){
            arr2.stream().sorted();
            int min = arr2.get(0);
            for (int i = 0; i < arr2.size(); i++) {
                if (min + i == arr2.get(i)){
                    flag4 = true;
                }else {
                    flag4 = false;
                }
            }
        }
        if (flag2 && flag3){
            return true;
        } else return flag1 && flag4;
    }

    public boolean checkOfBound(int[] arr){
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 11 && arr[i] > 0){
                flag = true;
            }
            else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public int[] checkShutGun(){
        String[] str1 = scanner.nextLine().split(" ");
        int[] arr = new int[2];
        while (true) {
            try {
                arr[0] = abc.get(str1[0].charAt(0));
                break;
            } catch (Exception ex) {
                System.out.println("Неверный ввод буквы");
                str1 = scanner.nextLine().split(" ");
            }
        }
        while (true) {
            try {
                if (Integer.parseInt(str1[0].replaceAll("[^0-9]", "")) < 11 &&
                        Integer.parseInt(str1[0].replaceAll("[^0-9]", "")) > 0) {
                    arr[1] = Integer.parseInt(str1[0].replaceAll("[^0-9]", ""));
                    break;
                } else {
                    System.out.println("Вы должны ввести число от 0 до 11");
                    str1 = scanner.nextLine().split(" ");
                }
            } catch (Exception ex) {
                System.out.println("Вы должны ввести число от 0 до 11");
                str1 = scanner.nextLine().split(" ");
            }
        }
        return arr;
    }
}
