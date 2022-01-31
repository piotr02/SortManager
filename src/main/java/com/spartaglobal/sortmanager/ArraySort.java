package com.spartaglobal.sortmanager;

public class ArraySort {
    /**
     * A bubble sort method
     *
     * @param ints the array to be sorted
     */
    public void bubbleSort(int[] ints){
        for(int i = 0; i < ints.length - 1; i++){
            for(int j = 0; j < ints.length - 1; j++){
                if(ints[j] > ints[j + 1]){
                    int temp = ints[j];
                    ints[j] = ints[j +1];
                    ints[j + 1] = temp;
                }
            }
        }
    }

    /**
     * A merge sort method
     *
     * @param ints the array to be sorted
     * @param length the length of the array to be sorted
     */
    public void mergeSort(int[] ints, int length){
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

        // merging the arrays back into 1 array
        int i = 0;
        int j = 0;
        int k = 0;

        //sort and populate the array
        while(i < division && j < length - division){
            if(left[i] <= right[i]){
                ints[k++] = left[i++];
            }
            else{
                ints[k++] = right[j++];
            }
        }
        while(i < division){
            ints[k++] = left[i++];
        }
        while(j < length - division){
            ints[k++] = right[j++];
        }
    }

    /**
     * A method that returns the array in a readable format
     *
     * @param ints the array to be converted into a string
     * @return the array in a string format
     */
    public String getArray(int[] ints){
        StringBuilder output = new StringBuilder();
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
        return output.toString();
    }
}
