package com.spartaglobal.sortmanager.model;

public class MergeSort implements SortInterface{

    /**
     * Initiates the mergeSort method with the given parameters.
     *
     * @param ints unsorted array
     * @return sorted array
     */
    @Override
    public int[] sort(int[] ints){
        mergeSort(ints, ints.length);
        return ints;
    }

    /**
     * A part of a merge sort algorithm.
     *
     * @param ints unsorted array
     * @param length length of the unsorted array
     */
    public void mergeSort(int[] ints, int length) {
        // making sure the code works if user inputs a wrong length
        if(length != ints.length)
            length = ints.length;

        // return if array can't be divided anymore
        if(length < 2)
            return;

        // create 2 new arrays to store the initial array after division
        int division = length / 2;
        int[] left = new int[division];
        int[] right = new int[length - division];

        // populate the left array
        for(int i = 0; i < division; i++){
            left[i] = ints[i];
        }

        // populate the right array
        for(int i = division; i < length; i++){
            right[i - division] = ints[i];
        }

        // keep dividing arrays until they can't be divided anymore
        mergeSort(left, division);
        mergeSort(right, length - division);

        merge(ints, left, right, division, length - division);
    }

    /**
     * A part of a merge sort algorithm. Sorts the array split by the mergeSort method.
     *
     * @param ints unsorted array
     * @param left left part of the array split by mergeSort method
     * @param right right part of the array split by mergeSort method
     * @param l length of the left array
     * @param r length of the right array
     */
    public void merge(int[] ints, int[] left, int[] right, int l, int r) {
        // merging the arrays back into 1 array
        int i = 0;
        int j = 0;
        int k = 0;

        //sort and populate the array
        while (i < l && j < r) {
            if (left[i] <= right[j]) {
                ints[k++] = left[i++];
            } else {
                ints[k++] = right[j++];
            }
        }
        while (i < l) {
            ints[k++] = left[i++];
        }
        while (j < r) {
            ints[k++] = right[j++];
        }
    }
}
