package seminar.src;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Seminar {

    private static final int LENGTH_STR = 10;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws IOException {
        recordRandomWord("test1", LENGTH_STR, "RestFest");
        recordRandomWord("test2", LENGTH_STR, "RestFest");
        concatenate("test1", "test2", "testOut");
        System.out.println(searchWord("test1", "RestFest"));
        System.out.println(searchWord("test2", "RestFest"));
        System.out.println(searchWord("testOut", "RestFest"));

        String[] files = new String[10];
        for (int i = 0; i < files.length; i++) {
            files[i] = "file_"+i+".txt";
            recordRandomWord(files[i], LENGTH_STR, "RestFest");
            System.out.printf("Файл %s создан.\n", files[i]);
        }

        List<String> result = searchMatch(files,"RestFest");
        for (String s: result) {
            System.out.printf("Файл %s содержит искомое слово '%s'\n", s, "RestFest");
        }
    }

    private static String generate(int length) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append((char) RANDOM.nextInt(60, 91));
        }
        return stringBuilder.toString();
    }

    private static void recordInFile(String fileName, int length) {
        try(FileOutputStream fileOutputStream = new FileOutputStream(fileName)){
            fileOutputStream.write(generate(length).getBytes());
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private static void recordRandomWord(String fileName, int length, String word) {
        try(FileOutputStream fileOutputStream = new FileOutputStream(fileName)){
            for (int i = 0; i < length; i++) {
                if (RANDOM.nextInt(10) == 1) fileOutputStream.write(word.getBytes());
                else fileOutputStream.write(generate(length).getBytes());
            }
            fileOutputStream.write(' ');
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private static void concatenate(String f1, String f2, String fOut){
        try (FileOutputStream fileOutputStream = new FileOutputStream(fOut)){
            int c;
            try (FileInputStream fileInputStream1 = new FileInputStream(f1)){
                while ((c = fileInputStream1.read()) != -1){
                    fileOutputStream.write(c);
                }
            }
            try (FileInputStream fileInputStream2 = new FileInputStream(f2)){
                while ((c = fileInputStream2.read()) != -1){
                    fileOutputStream.write(c);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean searchWord(String nameFile, String word) throws FileNotFoundException {
        try(FileInputStream fileInputStream = new FileInputStream(nameFile)) {
            byte[] data = word.getBytes();
            int c;
            int i = 0;
            while ((c = fileInputStream.read()) != -1){
                if (c == data[i]){
                    i++;
                }else {
                    i = 0;
                    if (c == data[i]){
                        i++;
                    }
                    continue;
                }
                if (i == data.length-1){
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> searchMatch(String[] files, String search) throws IOException {
        List<String> list = new ArrayList<>();
        File path = new File(new File(".").getCanonicalPath());
        File[] dir = path.listFiles();
        for (int i = 0; i < dir.length; i++) {
            if (dir[i].isDirectory()) continue;
            for (int j = 0; j < files.length; j++) {
                if (dir[i].getName().equals(files[j])){
                    if (searchWord(dir[i].getName(), search)){
                        list.add(dir[i].getName());
                        break;
                    }
                }
            }
        }
        return list;
    }
}
