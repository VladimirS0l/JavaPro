package homework5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileBackup {

    /**
     * Функция, создает резервную копию всех файлов в директории(без поддиректорий) во вновь созданную папку ./backup
     * @param source название директории для которой делаем бэкап
     * @param destination название директории в которую делаем бэкап
     * @throws IOException Инпут/Аутпут исключение
     */
    public static void backupFirstDirectory(String source, String destination) throws IOException {
        File folder = new File(source);
        File[] listOfFiles = folder.listFiles();
        Path destDir = Paths.get(destination);
        Files.createDirectories(destDir);
        if (listOfFiles != null)
            for (File file : listOfFiles) {
                Files.copy(file.toPath(), destDir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
            }
    }

    /**
     * Функция, создает резервную копию всех файлов в директории во вновь созданную папку ./backup
     * @param sourceDirectoryLocation название директории для которой делаем бэкап
     * @param destinationDirectoryLocation название директории в которую делаем бэкап
     * @throws IOException Инпут/Аутпут исключение
     */
    public static void backupFullDirectory(String sourceDirectoryLocation, String destinationDirectoryLocation)
            throws IOException {
        Files.walk(Paths.get(sourceDirectoryLocation))
                .forEach(source -> {
                    Path destination = Paths.get(destinationDirectoryLocation, source.toString()
                            .substring(sourceDirectoryLocation.length()));
                    try {
                        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}
