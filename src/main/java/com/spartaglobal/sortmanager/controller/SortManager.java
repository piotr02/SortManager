package com.spartaglobal.sortmanager.controller;

import com.spartaglobal.sortmanager.model.*;
import com.spartaglobal.sortmanager.view.DisplayManager;

import java.util.Random;

public class SortManager {
    public String initiateSorting(String desiredSortMethod){
        SortInterface si = getSort(desiredSortMethod);
        DisplayManager view = new DisplayManager();

        Random r = new Random();
        int[] ints = new int[10];
        for(int i = 0; i < ints.length; i++){
            ints[i] = r.nextInt(0, 100);
        }

        return si.sort(ints);
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
