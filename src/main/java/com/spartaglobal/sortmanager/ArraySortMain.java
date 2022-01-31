package com.spartaglobal.sortmanager;

import java.util.Arrays;
import java.util.Random;

public class ArraySortMain {
    public static void main(String[] args) {
        // creating the array to be sorted
        Random r = new Random();
        int[] ints = new int[10];
        for(int i = 0; i < ints.length; i++){
            ints[i] = r.nextInt(0, 100);
        }

        // initialising the ArraySort class
        ArraySort as = new ArraySort();

        // print the array before it's sorted
        System.out.println("Array to be sorted:\n" + as.getArray(ints));

        // sorting with bubble sort
        as.bubbleSort(ints);

        // new array to be sorted
        int[] ints2 = Arrays.copyOf(ints, ints.length);

        // sorting with merge sort
        as.mergeSort(ints2, 10);

        // print the sorted arrays
        System.out.println("Array sorted using bubble sort:\n" + as.getArray(ints));
        System.out.println("Array sorted using merge sort:\n" + as.getArray(ints2));
    }
}
