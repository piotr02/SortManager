package com.spartaglobal.sortmanager.view;

import com.spartaglobal.sortmanager.model.ArrayGenerator;

import java.util.Scanner;

public class DisplayManager {
    public String getDesiredSortMethod(){
        System.out.println("Available sorting methods:\n| BubbleSort | MergeSort |\nPlease enter what sorting method to use: ");
        Scanner sc = new Scanner(System.in);
        String desiredSortMethod = sc.next();
        return desiredSortMethod;
    }

    public int getDesiredArraySize(){
        System.out.println("Enter array size: ");
        Scanner sc = new Scanner(System.in);
        int desiredArraySize = sc.nextInt();
        return desiredArraySize;
    }

    public int getDesiredArrayBounds(){
        System.out.println("Enter the desired maximum possible number: ");
        Scanner sc = new Scanner(System.in);
        int desiredArrayBounds = sc.nextInt();
        return desiredArrayBounds;
    }

    public String getDesiredRandom(){
        System.out.println("Would you like to generate a random array?");
        Scanner sc = new Scanner(System.in);
        String desiredRandom = sc.next();
        return desiredRandom.toLowerCase();
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

    public void getResult(String result){
        System.out.println("Sorted Array:\n" + result);
    }
}
