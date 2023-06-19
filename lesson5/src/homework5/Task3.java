package homework5;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class Task3 {
    /**
     * Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3], и представляют собой,
     * например, состояния ячеек поля для игры в крестикинолики, где 0 – это пустое поле, 1 – это поле с крестиком,
     * 2 – это поле с ноликом, 3 – резервное значение. Такое предположение позволит хранить в одном числе типа int
     * всё поле 3х3. Записать в файл 9 значений так, чтобы они заняли три байта
     */

    private static final Random random = new Random();

    /**
     * Функция разбивает массив 3х3 по байтам и записывает в файл ровно 3 байта
     * @param array Массив целых чисел от 0 до 3
     */
    private static void recordInFileBoard(int[][] array){
        String s = "";
        try (FileOutputStream fileOutputStream = new FileOutputStream("board.txt")){
            for (int i = 0; i < array.length; i++) {
                byte b;
                for (int j = 0; j < array[0].length; j++) {
                    s += array[i][j];
                }
                System.out.printf("Байт №%d - число: %s\n", i, s);
                int a = Integer.parseInt(s) - 128;
                s = ""+a;
                b = Byte.parseByte(s);
                fileOutputStream.write(b);
                s = "";
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Функция создает массив целых чисел и заполняет его числами от 0 до 3
     * @return передает заполненый массив
     */
    private static int[][] createArray(){
        int[][] array = new int[3][3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <array[0].length; j++) {
                array[i][j] = random.nextInt(3);
            }
        }
        return array;
    }

    /**
     * Функция инициализирует запись массива 3х3 в файл, и распечатывает его размер
     */
    public static void init(){
        recordInFileBoard(createArray());
        File file = new File("board.txt");
        System.out.printf("Размер файла board = %d байт(а)\n", file.length());
    }

    /**
     * Функция проверки, обратно считывает из файла поток байт и переводит их в числа, написал исключительно для проверки
     * разбивать все числа в обратно в массив 3х3 не стал
     */
    public static void readFile(){
        try (FileInputStream fileInputStream = new FileInputStream(new File("board.txt"))){
            int[] array = new int[3];
            String s = "";
            int count = 0;
            for (byte b: fileInputStream.readAllBytes()) {
                s = String.valueOf(b);
                int a = Integer.parseInt(s) + 128;
                array[count] = a;
                count++;
            }
            System.out.printf("Массив cчитан из файла ");
            System.out.println(Arrays.toString(array));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
