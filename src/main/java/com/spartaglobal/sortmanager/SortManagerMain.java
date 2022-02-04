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

        DisplayManager view = new DisplayManager();
        view.getStart();
        String desiredSortMethod = view.getDesiredSortMethod();
        logger.debug("desiredSortMethod= " + desiredSortMethod);
        SortManager controller = new SortManager();

        String desiredArrayType = view.getDesiredArrayType();
        logger.debug("desiredArrayType= " + desiredArrayType);

//        ArrayGenerator ag = new ArrayGenerator();
//        ag.generateArray(desiredArrayType);

        controller.executeSort(desiredSortMethod, desiredArrayType);


//        if(desiredArrayType.equals("random")){
//            int arraySize = view.getDesiredArraySize();
//                logger.debug("arraySize= " + arraySize);
//                int arrayBounds = view.getDesiredArrayBounds();
//                logger.debug("arrayBounds= " + arrayBounds);
//
//                ag.generateRandomArray(arraySize, arrayBounds);
//                logger.info("Unsorted array= " + view.displayArray(ag.getUnsortedArray()));
//        }
//        else{
//            int arraySize = view.getDesiredArraySize();
//                logger.debug("arraySize= " + arraySize);
//                ag.generateCustomArray(arraySize);
//                logger.info("Unsorted array= " + view.displayArray(ag.getUnsortedArray()));
//        }

//        if(desiredSortMethod.equals("bubblemerge")){
//            String[] sortMethods = {"bubble", "merge"};
//            for(String sortMethod: sortMethods){
//                int [] unsortedArray = ag.getUnsortedArray();
//                logger.debug("unsortedArray= " + view.displayArray(unsortedArray));
//                int [] sortingArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
//                logger.debug("sortingArray= " + view.displayArray(sortingArray));
//                int [] comparisonArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
//                logger.debug("comparisonArray= " + view.displayArray(comparisonArray));
//                Arrays.sort(comparisonArray);
//                logger.debug("comparisonArray= " + view.displayArray(comparisonArray));
//
//                //initiate the sorting
//                String result = controller.initiateSorting(sortMethod, sortingArray);
//                logger.info("result= " + result);
//                System.out.println("------------------------------------------\n"
//                        + "Unsorted array:\n\n"
//                        + view.displayArray(unsortedArray));
//                view.getResult(result);
//                System.out.println("------------------------------------------\n"
//                        + "Array sorted with Arrays.sort():\n\n"
//                        + view.displayArray(comparisonArray)
//                        + "\n------------------------------------------");




    }
}
