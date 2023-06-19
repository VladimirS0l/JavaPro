package homework5;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class AppHW {
    public static void main(String[] args) throws IOException {

        /**
         * Task 1
         */
        String sourceDirectory = ".";
        String destinationDirectory = "./backup";

        FileBackup.backupFirstDirectory(sourceDirectory, destinationDirectory);
//        FileBackup.backupFullDirectory(sourceDirectory, destinationDirectory);

        /**
         * Task 2
         */
        File file = new File(".");
        Tree.print(file, "", true);

        /**
         * Task 3
         */
        Task3.init();
        Task3.readFile();
    }

}
