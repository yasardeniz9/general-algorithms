package com.algorithms;

import com.algorithms.hashcode.FileInput;
import com.algorithms.hashcode.PizzaFileOperation;

import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class FileOperationDemo {
    private static String filePathIncoming = "D:\\DEV\\FileExercisesDirectory\\INCOMING";
    private static Charset charset = Charset.forName("US-ASCII");

    public static void main(String[] args) {

        /*Path file = Paths.get(filePathIncoming + "/Deneme.txt");
        List<String> strings = FileOperation.readFile(file, charset);
        System.out.println(strings.size());

        Path outputFile = Paths.get(filePathIncoming + "/DenemeOut.txt");
        FileOperation.writeToFile(outputFile, charset, strings);*/
        Map<String, FileInput> pizzaInput = PizzaFileOperation.getPizzaInput();
        System.out.println(pizzaInput.size());
        System.out.println(pizzaInput.entrySet());

    }
}
