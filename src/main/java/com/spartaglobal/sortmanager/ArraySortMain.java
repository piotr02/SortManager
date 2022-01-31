package com.spartaglobal.sortmanager;

import java.util.Arrays;
import java.util.Random;

public class ArraySortMain {
    public static void main(String[] args) {
        // creating the array to be sorted by bubble sort
        Random r = new Random();
        int[] ints = new int[10];
        for(int i = 0; i < ints.length; i++){
            ints[i] = r.nextInt(0, 100);
        }

        // new array to be sorted by merge sort
        int[] ints2 = Arrays.copyOf(ints, ints.length);

        // new array to be sorted with Arrays.sort() for comparison
        int[] ints3 = Arrays.copyOf(ints, ints.length);

        // initialising the ArraySort class
        ArraySort as = new ArraySort();

        // print the array before it's sorted
        System.out.println("Array to be sorted:\n" + as.getArray(ints));

        // sorting with Arrays.sort()
        Arrays.sort(ints3);
        System.out.println("Array sorted with Arrays.sort():\n" + as.getArray(ints3));

        // sorting with bubble sort
        as.bubbleSort(ints);

        // sorting with merge sort
        as.mergeSort(ints2, 10);

        // print the sorted arrays
        System.out.println("Array sorted using bubble sort:\n" + as.getArray(ints));
        System.out.println("Array sorted using merge sort:\n" + as.getArray(ints2));
    }
}
