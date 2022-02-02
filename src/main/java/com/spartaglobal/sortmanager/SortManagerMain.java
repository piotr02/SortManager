package com.spartaglobal.sortmanager;

import com.spartaglobal.sortmanager.controller.SortManager;
import com.spartaglobal.sortmanager.model.ArrayGenerator;
import com.spartaglobal.sortmanager.view.DisplayManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class SortManagerMain {
    public static Logger logger = LogManager.getLogger("Logger");

    public static void main(String[] args) {
        logger.warn("warning");
        System.out.println("===============SORT MANAGER===============\n");

        DisplayManager view = new DisplayManager();
        String desiredSortMethod = view.getDesiredSortMethod();
        SortManager controller = new SortManager();

        String desiredRandom = view.getDesiredRandom();

        ArrayGenerator ag = new ArrayGenerator();

        // decides which array generation method to use
        while (true) {
            if(desiredRandom.equals("yes")){
                int arraySize = view.getDesiredArraySize();
                int arrayBounds = view.getDesiredArrayBounds();

                ag.generateRandomArray(arraySize, arrayBounds);
                break;
            }
            else if(desiredRandom.equals("no")){
                int arraySize = view.getDesiredArraySize();
                ag.generateCustomArray(arraySize);
                break;
            }
            else {
                System.out.println("Answer \"yes\" or \"no\".");
                desiredRandom = view.getDesiredRandom();
            }
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
