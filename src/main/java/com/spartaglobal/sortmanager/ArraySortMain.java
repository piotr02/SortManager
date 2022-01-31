package com.spartaglobal.sortmanager;

import java.util.Random;

public class ArraySortMain {
    public static void main(String[] args) {
        Random r = new Random();
        int[] ints = new int[10];
        for(int i = 0; i < ints.length; i++){
            ints[i] = r.nextInt(0, 100);
        }

        ArraySort as = new ArraySort();
        as.bubbleSort(ints);
        as.getArray(ints);
    }
}
