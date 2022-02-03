package com.spartaglobal.sortmanager.view;

import java.util.Scanner;

public class DisplayManager {
    /**
     * Asks the user for input and returns a desired sorting method from it.
     *
     * @return desired sorting method
     */
    public String getDesiredSortMethod(){
        System.out.println("Available sorting methods:\n\n"
                + "| BubbleSort | MergeSort |\n\n"
                + "------------------------------------------\n"
                + "Please enter what sorting method to use: "
                + "\n------------------------------------------");
        Scanner sc = new Scanner(System.in);
        String desiredSortMethod = sc.next();
        while(!desiredSortMethod.equals("bubblesort") && !desiredSortMethod.equals("mergesort")){
            System.out.println("Incorrect method! Try again: ");
            desiredSortMethod =sc.next();
        }
        return desiredSortMethod;
    }

    /**
     * Asks the user for input and returns a desired array size from it.
     *
     * @return desired array size
     */
    public int getDesiredArraySize(){
        System.out.println("------------------------------------------\n"
                +"Enter array size: "
                + "\n------------------------------------------");
        Scanner sc = new Scanner(System.in);
        while(!sc.hasNextInt()){
            System.out.println("Incorrect number! Enter a number: ");
            sc.next();
        }
        int desiredArraySize = sc.nextInt();
        if(desiredArraySize < 0){
            System.out.println("Negative input! Array size will be: " + (desiredArraySize * (-1)));
            desiredArraySize = desiredArraySize * (-1);
        }
        return desiredArraySize;
    }

    /**
     * Asks the user for input and returns a desired array value range from it.
     *
     * @return desired array value range
     */
    public int getDesiredArrayBounds(){
        System.out.println("------------------------------------------\n"
                + "Enter the desired maximum possible number: "
                + "\n------------------------------------------");
        Scanner sc = new Scanner(System.in);
        while(!sc.hasNextInt()){
            System.out.println("Incorrect number! Enter a number: ");
            sc.next();
        }
        int desiredArrayBounds = sc.nextInt();
        if(desiredArrayBounds < 0){
            System.out.println("Negative input! Maximum number will be: " + (desiredArrayBounds * (-1)));
            desiredArrayBounds = desiredArrayBounds * (-1);
        }
        return desiredArrayBounds;
    }

    /**
     * Asks the user if they want to create a random array and returns a desired answer from it.
     *
     * @return desired answer
     */
    public String getDesiredRandom(){
        System.out.println("------------------------------------------\n" +
                "Would you like to generate a random array?\n"
                + "------------------------------------------");
        Scanner sc = new Scanner(System.in);
        String desiredRandom = sc.next();
//        return desiredRandom.toLowerCase();
        while(!desiredRandom.equalsIgnoreCase("yes") && !desiredRandom.equalsIgnoreCase("no")){
            System.out.println("Incorrect answer! Try again: ");
            desiredRandom =sc.next();
        }
        return desiredRandom.toLowerCase();
    }

    /**
     * Converts an array into a readable String format.
     *
     * @param ints array to be converted
     * @return array in a String format
     */
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

    /**
     * Prints the result of a sorting algorithm.
     *
     * @param result result of a sorting algorithm
     */
    public void getResult(String result){
        System.out.println("------------------------------------------\n"
                + "Sorted Array:\n\n"
                + result);
    }
}
