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
     * @param array array to be sorted
     * @return a String representation of the sorted array
     */
    public String initiateSorting(String desiredSortMethod, int[] array) {
        // Instantiate the SortInterface object with the desired sorting method instance
        SortInterface si = getSort(desiredSortMethod);
        // Instantiate the DisplayManager object
        DisplayManager view = new DisplayManager();

        // Array to be sorted
        int[] arrayToSort = Arrays.copyOf(array, array.length);
        // Sort the array with the desired sorting method
        arrayToSort = si.sort(arrayToSort);

        // Return the array in a String format
        SortManagerMain.logger.debug("Sorted Array= " + view.displayArray(arrayToSort));
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

    /**
     * Initiates the sorting algorithms and returns the sorted arrays.
     *
     * @param sortMethods string array sorting sorting methods
     * @param array unsorted array to be sorted
     * @param dm instance of DisplayManager class
     */
    private void sortMethodsLoop(String[] sortMethods, int[] array, DisplayManager dm){
        for (String sortMethod : sortMethods) {
            long startTime = System.nanoTime();
            //initiate the sorting
            String result = initiateSorting(sortMethod, Arrays.copyOf(array, array.length));
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            SortManagerMain.logger.info(dm.getDuration(duration, sortMethod));
            // Display the result
            dm.printResult(result, sortMethod);
        }
    }

    /**
     * Selects which sorting algorithms to execute based on user input.
     *
     * @param desiredSortMethod desired sorting method/s entered by the user
     * @param desiredArrayType desired array type entered by the user
     */
    public void executeSort(String desiredSortMethod, String desiredArrayType){
        ArrayGenerator ag = new ArrayGenerator();
        // Generate an unsorted array of a desired type (random or custom)
        ag.generateArray(desiredArrayType);
        DisplayManager view = new DisplayManager();

        // Copy of the unsorted array
        int[] unsortedArray = Arrays.copyOf(ag.getUnsortedArray(), ag.getUnsortedArray().length);
        // Array to be sorted by Arrays.sort()
        int[] comparisonArray = Arrays.copyOf(ag.getUnsortedArray(), ag.getUnsortedArray().length);
        // Sorting with Arrays.sort() for comparison
        Arrays.sort(comparisonArray);
        SortManagerMain.logger.debug("comparisonArray= " + view.displayArray(comparisonArray));

        // Display the unsorted array and the array sorted by Arrays.sort()
        view.printEnd(unsortedArray, comparisonArray);

        // Determine which sorting methods to use based on desiredSortMethod
        if(desiredSortMethod.equals("bubblemerge")) {
            String[] sortMethods = {"bubble", "merge"};
            sortMethodsLoop(sortMethods, ag.getUnsortedArray(), view);
        }
        else if(desiredSortMethod.equals("bubbletree")){
            String[] sortMethods = {"bubble", "tree"};
            sortMethodsLoop(sortMethods, ag.getUnsortedArray(), view);
        }
        else if(desiredSortMethod.equals("mergetree")){
            String[] sortMethods = {"merge", "tree"};
            sortMethodsLoop(sortMethods, ag.getUnsortedArray(), view);
        }
        else if(desiredSortMethod.equals("bubblemergetree")){
            String[] sortMethods = {"bubble", "merge", "tree"};
            sortMethodsLoop(sortMethods, ag.getUnsortedArray(), view);
        }
        else{
            long startTime = System.nanoTime();
            //initiate the sorting
            String result = initiateSorting(desiredSortMethod, Arrays.copyOf(unsortedArray, unsortedArray.length));
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            SortManagerMain.logger.info(view.getDuration(duration, desiredSortMethod));
            view.printResult(result, desiredSortMethod);
        }
    }
}
