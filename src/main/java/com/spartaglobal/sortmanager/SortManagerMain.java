package com.spartaglobal.sortmanager;

import com.spartaglobal.sortmanager.controller.SortManager;
import com.spartaglobal.sortmanager.model.ArrayGenerator;
import com.spartaglobal.sortmanager.view.DisplayManager;

import java.util.Arrays;

public class SortManagerMain {
    public static void main(String[] args) {
        System.out.println("===============SORT MANAGER===============\n");

        DisplayManager view = new DisplayManager();
        String desiredSortMethod = view.getDesiredSortMethod();
        SortManager controller = new SortManager();

        String desiredRandom = view.getDesiredRandom();

        ArrayGenerator ag = new ArrayGenerator();

        // decides which array generation method to use
        if(desiredRandom.equals("yes")){
            int arraySize = view.getDesiredArraySize();
            int arrayBounds = view.getDesiredArrayBounds();

            ag.generateRandomArray(arraySize, arrayBounds);
        }
        else{
            int arraySize = view.getDesiredArraySize();
            ag.generateCustomArray(arraySize);
        }

        int [] unsortedArray = ag.getUnsortedArray();
        int [] sortingArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
        int [] comparisonArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
        Arrays.sort(comparisonArray);

        String result = controller.initiateSorting(desiredSortMethod, sortingArray);
        System.out.println("------------------------------------------\n"
                + "Unsorted array:\n\n"
                + view.displayArray(unsortedArray));
        view.getResult(result);
        System.out.println("------------------------------------------\n"
                + "Array sorted with Arrays.sort():\n\n"
                + view.displayArray(comparisonArray)
                + "\n------------------------------------------");
    }
}