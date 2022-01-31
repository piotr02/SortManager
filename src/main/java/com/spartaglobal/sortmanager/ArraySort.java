package com.spartaglobal.sortmanager;

public class ArraySort {
    /**
     * A bubble sort method
     *
     * @param ints
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
        System.out.println(getArray(ints));
    }

    /**
     * A merge sort method
     *
     * @param ints
     */
    public void mergeSort(int[] ints){

    }

    /**
     * A method that returns the array in a readable format
     *
     * @param ints
     * @return
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
