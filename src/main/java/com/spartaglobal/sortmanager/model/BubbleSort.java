package com.spartaglobal.sortmanager.model;

public class BubbleSort implements SortInterface{
    /**
     * Sorts an array with a bubble sort algorithm.
     *
     * @param array unsorted array
     * @return sorted array
     */
    @Override
    public int[] sort(int[] array) {
        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - 1; j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j +1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
