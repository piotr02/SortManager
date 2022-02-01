package com.spartaglobal.sortmanager.model;

public class BubbleSort implements SortInterface{
    @Override
    public int[] sort(int[] ints) {
        for(int i = 0; i < ints.length - 1; i++){
            for(int j = 0; j < ints.length - 1; j++){
                if(ints[j] > ints[j + 1]){
                    int temp = ints[j];
                    ints[j] = ints[j +1];
                    ints[j + 1] = temp;
                }
            }
        }
        return ints;
    }
}
