package com.spartaglobal.sortmanager.controller;

import com.spartaglobal.sortmanager.SortManagerMain;
import com.spartaglobal.sortmanager.model.*;
import com.spartaglobal.sortmanager.view.DisplayManager;

import java.util.Arrays;

public class SortManager {
    /**
     * Initiates the sorting process with a chosen algorithm and an unsorted array.
     *
     * @param desiredSortMethod the chosen sorting algorithm
     * @param array     array to be sorted
     * @return a String representation of the sorted array
     */
    public String initiateSorting(String desiredSortMethod, int[] array) {
        SortManagerMain.logger.info("desiredSortMethod= " + desiredSortMethod);
        SortManagerMain.logger.info("array= " + new DisplayManager().displayArray(array));
        SortInterface si = getSort(desiredSortMethod);
        SortManagerMain.logger.info("desiredSortMethod= " + getSort(desiredSortMethod).getClass());
        DisplayManager view = new DisplayManager();

        int[] arrayToSort = Arrays.copyOf(array, array.length);
        SortManagerMain.logger.debug("arrayToSort= " + new DisplayManager().displayArray(arrayToSort));
        arrayToSort = si.sort(arrayToSort);
        SortManagerMain.logger.debug("arrayToSort= " + new DisplayManager().displayArray(arrayToSort));

        return view.displayArray(arrayToSort);
    }

    /**
     * Creates an instance of a sorting algorithm class based on user input.
     *
     * @param sortMethod sorting algorithm
     * @return the instance of the chosen sorting algorithm
     */
    public static SortInterface getSort(String sortMethod) {
        SortManagerMain.logger.debug("sortMethod = " + sortMethod);
        SortFactory sf = switch (sortMethod.toLowerCase()) {
            case "bubble" -> new BubbleSortFactory();
            case "merge" -> new MergeSortFactory();
            case "tree" -> new BinarySearchTreeFactory();
            default -> null;
        };
        return sf.getInstance();
    }

    public void executeSort(String desiredSortMethod, String desiredArrayType){
        ArrayGenerator ag = new ArrayGenerator();
        ag.generateArray(desiredArrayType);
        DisplayManager view = new DisplayManager();


        int[] unsortedArray = Arrays.copyOf(ag.getUnsortedArray(), ag.getUnsortedArray().length);
        SortManagerMain.logger.debug("unsortedArray= " + view.displayArray(unsortedArray));
        int[] comparisonArray = Arrays.copyOf(ag.getUnsortedArray(), ag.getUnsortedArray().length);
        SortManagerMain.logger.debug("comparisonArray= " + view.displayArray(comparisonArray));
        Arrays.sort(comparisonArray);
        SortManagerMain.logger.debug("comparisonArray= " + view.displayArray(comparisonArray));

        view.getEnd(unsortedArray, comparisonArray);

        if(desiredSortMethod.equals("bubblemerge")) {
            String[] sortMethods = {"bubble", "merge"};
            for (String sortMethod : sortMethods) {
                long startTime = System.nanoTime();
                //initiate the sorting
                String result = initiateSorting(sortMethod, Arrays.copyOf(unsortedArray, unsortedArray.length));
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                SortManagerMain.logger.info(view.getDuration(duration, sortMethod));
                view.getResult(result, sortMethod);
            }
        }
        else if(desiredSortMethod.equals("bubbletree")){
            String[] sortMethods = {"bubble", "tree"};
            for (String sortMethod : sortMethods) {
                long startTime = System.nanoTime();
                //initiate the sorting
                String result = initiateSorting(sortMethod, Arrays.copyOf(unsortedArray, unsortedArray.length));
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                SortManagerMain.logger.info(view.getDuration(duration, sortMethod));
                view.getResult(result, sortMethod);
            }
        }
        else if(desiredSortMethod.equals("mergetree")){
            String[] sortMethods = {"merge", "tree"};
            for (String sortMethod : sortMethods) {
                long startTime = System.nanoTime();
                //initiate the sorting
                String result = initiateSorting(sortMethod, Arrays.copyOf(unsortedArray, unsortedArray.length));
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                SortManagerMain.logger.info(view.getDuration(duration, sortMethod));
                view.getResult(result, sortMethod);
            }
        }
        else if(desiredSortMethod.equals("bubblemergetree")){
            String[] sortMethods = {"bubble", "merge", "tree"};
            for (String sortMethod : sortMethods) {
                long startTime = System.nanoTime();
                //initiate the sorting
                String result = initiateSorting(sortMethod, Arrays.copyOf(unsortedArray, unsortedArray.length));
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                SortManagerMain.logger.info(view.getDuration(duration, sortMethod));
                view.getResult(result, sortMethod);
            }
        }
        else{
            long startTime = System.nanoTime();
            //initiate the sorting
            String result = initiateSorting(desiredSortMethod, Arrays.copyOf(unsortedArray, unsortedArray.length));
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            SortManagerMain.logger.info(view.getDuration(duration, desiredSortMethod));
            view.getResult(result, desiredSortMethod);
        }
    }
}
