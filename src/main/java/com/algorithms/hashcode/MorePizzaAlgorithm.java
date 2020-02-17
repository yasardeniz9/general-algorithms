package com.algorithms.hashcode;

import org.apache.commons.io.FilenameUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MorePizzaAlgorithm {

    public static void main(String[] args) {
        Map<String, FileInput> pizzaInput = PizzaFileOperation.getPizzaInput();
        pizzaInput.forEach((filename,fileInput)->{
            FileOutput fileOutput = getPossibleMaxSlice(fileInput);
            String outputFileName = FilenameUtils.removeExtension(filename);
            PizzaFileOperation.writePizzaOutput(outputFileName, fileOutput);

            System.out.println(fileOutput.getTypeOfPizzaCount());
            System.out.println(fileOutput.getTypeNoList());
            System.out.println();

        });

    }


    public static FileOutput getPossibleMaxSlice(FileInput fileInput) {
        FileOutput fileOutput = new FileOutput();
        List<Integer> selectedTypeList = new ArrayList<>();
        int maxLimit = fileInput.getMaxSlice();
        int typeCount = fileInput.getDifferentTypeCount();
        List<Integer> sliceOfType = fileInput.getSliceOfTypeList();
        int sliceCount = 0;
        int i = typeCount - 1;
        while (sliceCount < maxLimit && i >= 0) {
            if (sliceCount + sliceOfType.get(i) <= maxLimit) {
                sliceCount += sliceOfType.get(i);
                selectedTypeList.add(i);
            }
            i--;
        }
        fileOutput.setTypeOfPizzaCount(sliceCount);
        //refactor
        Collections.reverse(selectedTypeList);
        fileOutput.setTypeNoList(selectedTypeList);
        return fileOutput;
    }
}
