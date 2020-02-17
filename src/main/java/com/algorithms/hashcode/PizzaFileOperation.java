package com.algorithms.hashcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PizzaFileOperation {

    private static String filePathIncoming = "D:\\DEV\\HashCode\\2020\\Inputs";
    private static String filePathOutgoing = "D:\\DEV\\HashCode\\2020\\Outputs";
    private static final Charset charset = Charset.forName("US-ASCII");

    public static Map<String, FileInput> getPizzaInput() {
        Map<String, FileInput> mapOfFiles = new HashMap<>();

        try (Stream<Path> walk = Files.walk(Paths.get(filePathIncoming))) {

            List<Path> fileNames = walk.filter(Files::isRegularFile).collect(Collectors.toList());

            fileNames.forEach(file -> {
                FileInput fileInput = new FileInput();
                List<Integer> sliceOfTypeList = new ArrayList<>();
                try (BufferedReader bufferedReader = Files.newBufferedReader(file, charset)) {
                    //read first line
                    String line = bufferedReader.readLine();
                    String[] firstLine = line.split(" ");
                    fileInput.setMaxSlice(Integer.valueOf(firstLine[0]));
                    fileInput.setDifferentTypeCount(Integer.valueOf(firstLine[1]));

                    //read second line
                    line = bufferedReader.readLine();
                    String[] secondLine = line.split(" ");
                    fileInput.setSliceOfTypeList(Arrays.stream(secondLine)
                            .map(Integer::valueOf)
                            .collect(Collectors.toList()));
                    mapOfFiles.put(file.getFileName().toString(), fileInput);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapOfFiles;
    }

    public static void writePizzaOutput(String fileName, FileOutput fileOutput) {
        Path filePath = Paths.get(filePathOutgoing + "/" + fileName + ".out");

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(filePath, charset)) {
            bufferedWriter.write(String.valueOf(fileOutput.getTypeOfPizzaCount()));
            bufferedWriter.newLine();
            fileOutput.getTypeNoList().forEach(type-> {
                try {
                    bufferedWriter.write(type + " ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}