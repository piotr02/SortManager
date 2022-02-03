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
        long startTime = System.nanoTime();

        logger.info("\nProgram Start\n");
        System.out.println("===============SORT MANAGER===============\n");

        DisplayManager view = new DisplayManager();
        String desiredSortMethod = view.getDesiredSortMethod();
        logger.debug("desiredSortMethod= " + desiredSortMethod);
        SortManager controller = new SortManager();

        String desiredRandom = view.getDesiredArrayType();
        logger.debug("desiredRandom= " + desiredRandom);

        ArrayGenerator ag = new ArrayGenerator();

//        // decides which array generation method to use
//        while (true) {
//            if(desiredRandom.equals("yes")){
//                int arraySize = view.getDesiredArraySize();
//                logger.info("arraySize= " + arraySize);
//                int arrayBounds = view.getDesiredArrayBounds();
//                logger.info("arrayBounds= " + arrayBounds);
//
//                ag.generateRandomArray(arraySize, arrayBounds);
//                logger.info("Unsorted array= " + view.displayArray(ag.getUnsortedArray()));
//                break;
//            }
//            else if(desiredRandom.equals("no")){
//                int arraySize = view.getDesiredArraySize();
//                logger.info("arraySize= " + arraySize);
//                ag.generateCustomArray(arraySize);
//                logger.info("Unsorted array= " + view.displayArray(ag.getUnsortedArray()));
//                break;
//            }
//            else {
//                System.out.println("Answer \"yes\" or \"no\".");
//                desiredRandom = view.getDesiredRandom();
//                logger.info("Desired type of array= " + desiredRandom);
//            }
//        }
        if(desiredRandom.equals("random")){
            int arraySize = view.getDesiredArraySize();
                logger.debug("arraySize= " + arraySize);
                int arrayBounds = view.getDesiredArrayBounds();
                logger.debug("arrayBounds= " + arrayBounds);

                ag.generateRandomArray(arraySize, arrayBounds);
                logger.info("Unsorted array= " + view.displayArray(ag.getUnsortedArray()));
        }
        else{
            int arraySize = view.getDesiredArraySize();
                logger.debug("arraySize= " + arraySize);
                ag.generateCustomArray(arraySize);
                logger.info("Unsorted array= " + view.displayArray(ag.getUnsortedArray()));
        }

        int [] unsortedArray = ag.getUnsortedArray();
        logger.debug("unsortedArray= " + view.displayArray(unsortedArray));
        int [] sortingArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
        logger.debug("sortingArray= " + view.displayArray(sortingArray));
        int [] comparisonArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
        logger.debug("comparisonArray= " + view.displayArray(comparisonArray));
        Arrays.sort(comparisonArray);
        logger.debug("comparisonArray= " + view.displayArray(comparisonArray));

        String result = controller.initiateSorting(desiredSortMethod, sortingArray);
        logger.info("result= " + result);
        System.out.println("------------------------------------------\n"
                + "Unsorted array:\n\n"
                + view.displayArray(unsortedArray));
        view.getResult(result);
        System.out.println("------------------------------------------\n"
                + "Array sorted with Arrays.sort():\n\n"
                + view.displayArray(comparisonArray)
                + "\n------------------------------------------");

        long endTime = System.nanoTime();
        logger.info("Execution time(" + desiredSortMethod + ") in nano seconds:\n" + (endTime - startTime)
                + "\nMilliseconds:\n" + ((double)(endTime - startTime)/1000000)
                + "\nSeconds:\n" + ((double)(endTime - startTime)/1000000000));
    }
}
