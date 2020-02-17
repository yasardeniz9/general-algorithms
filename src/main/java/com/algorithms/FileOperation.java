package com.algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileOperation {

    //private static final Charset charset = Charset.forName("US-ASCII");

    public static List<String> readFile(Path filePath, Charset charset) {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(filePath, charset)) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return stringList;
    }

    public static void writeToFile(Path filePath, Charset charset, List<String> stringList) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(filePath, charset)) {
            for (String line : stringList) {
                bufferedWriter.write(line, 0, line.length());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
