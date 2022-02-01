package com.spartaglobal.sortmanager.model;

public class BubbleSort implements SortInterface{
    @Override
    public String sort(int[] ints) {
        for(int i = 0; i < ints.length - 1; i++){
            for(int j = 0; j < ints.length - 1; j++){
                if(ints[j] > ints[j + 1]){
                    int temp = ints[j];
                    ints[j] = ints[j +1];
                    ints[j + 1] = temp;
                }
            }
        }
        return displayArray(ints);
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
