package seminar.src;

import java.io.*;

public class App {
    public static void main(String[] args) throws IOException {
//        File newFile = new File(".");
//        for (File f: newFile.listFiles()) {
//            System.out.println(f.getName());
//        }
//        System.out.println(newFile.isDirectory());
//        System.out.println(newFile.isFile());
//        System.out.println(newFile.length());
//        System.out.println(newFile.getAbsolutePath());
//        System.out.println(newFile.getTotalSpace());
//        System.out.println(newFile.getFreeSpace());

//        List<String> lines = Arrays.asList(
//                "SAKMDLKFNJFNkajsfnasjfnakjfnksanfknjasf af asf af asf naf a sfna f",
//                "sdbhasdhj askj faj dwhb kajq iu y1287hiafgur g3ruas ugvf akmu g eiufsh hhjf nwkejf"
//        );
//        Path file = Files.createFile(Paths.get("cat.txt"));
//        if (Files.exists(file)){
//            Files.write(file, lines, StandardCharsets.UTF_8);
//            lines = Files.readAllLines(
//                    Paths.get("cat.txt"), StandardCharsets.UTF_8
//            );
//            for (String s: lines) {
//                System.out.println(s);
//            }
//        }
//        byte[] bitesToWrite = {0, 12, 24, 42, 15, 31};
//        byte[] bitesToRead = new byte[10];
//        File file = new File("bytes.txt");
//        try {
//            System.out.println("Begin");
//            FileOutputStream outputStream = new FileOutputStream(file);
//            outputStream.write(bitesToWrite); outputStream.close();
//            System.out.println("Bytes written");
//
//            FileInputStream inFile = new FileInputStream(file);
//            int bytesAvalible = inFile.available();
//            System.out.println("Ready to read " + bytesAvalible);
//
//            int count = inFile.read(bitesToRead, 0, bytesAvalible);
//            for (int i = 0; i < count; i++) {
//                System.out.println(" " + bitesToRead[i]);
//            }
//            System.out.println(); inFile.close();
//            System.out.println("Input stream closed");
//
//        }catch (FileNotFoundException ex){
//            System.out.println("Unable to write data to file - " + file.getName());
//        }catch (IOException ex){
//            System.out.println("Error " + ex.toString());
//        }

//        String s = "example";
//        long startTime = nanoTime();
//        for (int i = 0; i < 200000; i++) {
//            s = s + i;
//        }
//        double delta = (nanoTime() - startTime) * 0.000000001;
//        out.println("Delta (sec): " + delta);
//
//        long startTime2 = nanoTime();
//        StringBuilder sb = new StringBuilder("example");
//        for (int i = 0; i < 200000; i++) {
//            sb.append(i);
//        }
//        double delta2 = (nanoTime() - startTime2) * 0.000000001;
//        out.println("Delta2 (sec): " + delta2);

//        int count = 0;
//        while (count < 3){
//            try(FileWriter fw = new FileWriter("file"+count)) {
//                StringBuilder sb = new StringBuilder("test");
//                Random rnd = new Random();
//                for (int i = 0; i < 10; i++) {
//                    fw.write(String.valueOf(sb.append(rnd.nextInt(21)))+"\n");
//                    fw.write("test 2141412 2155 125 1 515 125");
//                }
//            }
//            count++;
//        }
//        concatenateFiles();

//        out.println(researchWord("statist"));
        File file = new File(".");
        Tree.print(file, "", true);
    }

    private static void concatenateFiles() throws FileNotFoundException {
        try (FileWriter fw = new FileWriter("file")) {
            for (int i = 0; i < 3; i++) {
                try {
                    BufferedReader br = new BufferedReader(new FileReader("file" + i));
                    String s;
                    String output = "";
                    while ((s = br.readLine()) != null) {
                        output += s + "\n";
                    }
                    fw.write(output + "\n\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String researchWord(String word) throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader("file"))) {
            boolean flag = false;
            String s;
            while ((s = br.readLine()) != null) {
                if (s.matches(word+"\\d+")){
                    flag = true;
                    break;
                }
            }
            if (flag) return word;
            else return "Not found";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
