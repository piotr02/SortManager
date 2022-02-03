package com.spartaglobal.sortmanager.model;

import com.spartaglobal.sortmanager.SortManagerMain;
import com.spartaglobal.sortmanager.view.DisplayManager;

public class MergeSort implements SortInterface{

    /**
     * Initiates the mergeSort method with the given parameters.
     *
     * @param ints unsorted array
     * @return sorted array
     */
    @Override
    public int[] sort(int[] ints){
        SortManagerMain.logger.debug("ints+ " + new DisplayManager().displayArray(ints));
        SortManagerMain.logger.debug("ints.length= " + ints.length);
        mergeSort(ints, ints.length);
        SortManagerMain.logger.debug("ints= " + new DisplayManager().displayArray(ints));
        return ints;
    }

    /**
     * A part of a merge sort algorithm.
     *
     * @param ints unsorted array
     * @param length length of the unsorted array
     */
    public void mergeSort(int[] ints, int length) {
        SortManagerMain.logger.debug("ints= " + new DisplayManager().displayArray(ints));
        SortManagerMain.logger.debug("ints.length= " + ints.length);
        // making sure the code works if user inputs a wrong length
        if(length != ints.length)
            length = ints.length;

        // return if array can't be divided anymore
        if(length < 2) {
            SortManagerMain.logger.info("Array length less than 2. Returning.");
            return;
        }

        // create 2 new arrays to store the initial array after division
        int division = length / 2;
        SortManagerMain.logger.debug("division= " + division);
        int[] left = new int[division];
        SortManagerMain.logger.debug("left= " + new DisplayManager().displayArray(left));
        int[] right = new int[length - division];
        SortManagerMain.logger.debug("right= " + new DisplayManager().displayArray(right));

        // populate the left array
        for(int i = 0; i < division; i++){
            left[i] = ints[i];
        }
        SortManagerMain.logger.debug("left= " + new DisplayManager().displayArray(left));

        // populate the right array
        for(int i = division; i < length; i++){
            right[i - division] = ints[i];
        }
        SortManagerMain.logger.debug("right= " + new DisplayManager().displayArray(right));

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
        SortManagerMain.logger.debug("ints= " + new DisplayManager().displayArray(ints));
        SortManagerMain.logger.debug("left= " + new DisplayManager().displayArray(left));
        SortManagerMain.logger.debug("right= " + new DisplayManager().displayArray(right));
        SortManagerMain.logger.debug("l= " + l);
        SortManagerMain.logger.debug("r= " + r);
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
        SortManagerMain.logger.debug("ints= " + new DisplayManager().displayArray(ints));
    }
}
