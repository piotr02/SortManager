package com.spartaglobal.sortmanager.controller;

import com.spartaglobal.sortmanager.model.*;
import com.spartaglobal.sortmanager.view.DisplayManager;

import java.util.Arrays;
import java.util.Random;

public class SortManager {
    public String initiateSorting(String desiredSortMethod, int[] unsortedArray){
        SortInterface si = getSort(desiredSortMethod);
        DisplayManager view = new DisplayManager();

        int[] arrayToSort = Arrays.copyOf(unsortedArray, unsortedArray.length);
        arrayToSort = si.sort(arrayToSort);

        return view.displayArray(arrayToSort);
    }

    public static SortInterface getSort(String sortMethod){
        SortFactory sf = switch (sortMethod.toLowerCase()){
            case "bubblesort" -> new BubbleSortFactory();
            case "mergesort" -> new MergeSortFactory();
            default -> null;
        };
        return sf.getInstance();
    }
}
