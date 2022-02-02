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
     * @param unsortedArray     array to be sorted
     * @return a String representation of the sorted array
     */
    public String initiateSorting(String desiredSortMethod, int[] unsortedArray) {
        SortManagerMain.logger.info("desiredSortMethod= " + desiredSortMethod);
        SortManagerMain.logger.info("unsortedArray= " + new DisplayManager().displayArray(unsortedArray));
        SortInterface si = getSort(desiredSortMethod);
        SortManagerMain.logger.info("desiredSortMethod= " + getSort(desiredSortMethod).getClass());
        DisplayManager view = new DisplayManager();

        int[] arrayToSort = Arrays.copyOf(unsortedArray, unsortedArray.length);
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
        SortFactory sf = switch (sortMethod.toLowerCase()) {
            case "bubblesort" -> new BubbleSortFactory();
            case "mergesort" -> new MergeSortFactory();
            default -> null;
        };
        return sf.getInstance();
    }
}
