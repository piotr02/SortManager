package com.spartaglobal.sortmanager.model;

public class MergeSort implements SortInterface{

    @Override
    public String sort(int[] ints){
        mergeSort(ints, ints.length);

        return displayArray(ints);
    }
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

    public String displayArray(int[] ints){
        StringBuilder output = new StringBuilder();
        if(ints.length == 0){
            output.append("[]");
        }
        else{
            for(int number: ints){
                output.append(number);
                output.append(", ");
            }
            output.delete(0, output.length());
            output.append("[");
            for(int i = 0; i < ints.length; i++){
                if(i < ints.length - 1){
                    output.append(ints[i]);
                    output.append(", ");
                }
                else{
                    output.append(ints[i]);
                    output.append("]");
                }
            }
        }
        return output.toString();
    }
}
