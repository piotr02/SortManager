package com.spartaglobal.sortmanager.view;

import com.spartaglobal.sortmanager.SortManagerMain;

import java.util.Scanner;

public class DisplayManager {
    /**
     * Asks the user for input and returns a desired sorting method from it.
     *
     * @return desired sorting method
     */
    public String getDesiredSortMethod(){
        System.out.println("Available sorting methods:\n\n"
                + "| BubbleSort | MergeSort | BinarySearchTree |\n\n"
                + "------------------------------------------\n"
                + "Please enter: \"bubble\", \"merge\", \"tree\",\n"
                + "\"bubblemerge\", \"bubbletree\", \"mergetree\",\n"
                + "or \"bubblemergetree\" to choose a method/s: "
                + "\n------------------------------------------");
        Scanner sc = new Scanner(System.in);
        String desiredSortMethod = sc.next();
        SortManagerMain.logger.debug("desiredSortMethod= " + desiredSortMethod);
        while(!desiredSortMethod.equals("bubble") &&
                !desiredSortMethod.equals("merge") &&
                !desiredSortMethod.equals("tree") &&
                !desiredSortMethod.equals("bubblemerge") &&
                !desiredSortMethod.equals("bubbletree") &&
                !desiredSortMethod.equals("mergetree") &&
                !desiredSortMethod.equals("bubblemergetree")){
            SortManagerMain.logger.warn("Incorrect sort method entered!");
            System.out.println("Incorrect method! Try again: ");
            desiredSortMethod =sc.next();
        }
        SortManagerMain.logger.debug("desiredSortMethod= " + desiredSortMethod);
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
            SortManagerMain.logger.warn("Incorrect input! Not a number!");
            System.out.println("Incorrect number! Enter a number: ");
            sc.next();
        }
        int desiredArraySize = sc.nextInt();
        SortManagerMain.logger.debug("desiredArraySize= " + desiredArraySize);
        if(desiredArraySize < 0){
            SortManagerMain.logger.warn("Negative array size entered!");
            System.out.println("Negative input! Array size will be: " + (desiredArraySize * (-1)));
            desiredArraySize = desiredArraySize * (-1);
        }
        SortManagerMain.logger.debug("desiredArraySize= " + desiredArraySize);
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
            SortManagerMain.logger.warn("Incorrect input! Not a number!");
            System.out.println("Incorrect number! Enter a number: ");
            sc.next();
        }
        int desiredArrayBounds = sc.nextInt();
        SortManagerMain.logger.debug("desiredArrayBounds= " + desiredArrayBounds);
        if(desiredArrayBounds < 0){
            SortManagerMain.logger.warn("Negative array range entered!");
            System.out.println("Negative input! Maximum number will be: " + (desiredArrayBounds * (-1)));
            desiredArrayBounds = desiredArrayBounds * (-1);
        }
        SortManagerMain.logger.debug("desiredArrayBounds= " + desiredArrayBounds);
        return desiredArrayBounds;
    }

    /**
     * Asks the user if they want to create a random array and returns a desired answer from it.
     *
     * @return desired answer
     */
    public String getDesiredArrayType(){
        System.out.println("------------------------------------------\n" +
                "Would you like to generate a random or a custom array? Enter \"random\" or \"custom\".\n"
                + "------------------------------------------");
        Scanner sc = new Scanner(System.in);
        String desiredArrayType = sc.next();
        SortManagerMain.logger.debug("desiredArrayType=" + desiredArrayType);
        while(!desiredArrayType.equalsIgnoreCase("random")
                && !desiredArrayType.equalsIgnoreCase("custom")){
            System.out.println("Incorrect answer! Try again: ");
            desiredArrayType =sc.next();
        }
        SortManagerMain.logger.debug("desiredArrayType=" + desiredArrayType);
        return desiredArrayType.toLowerCase();
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

    public void getStart(){
        SortManagerMain.logger.info("\nProgram Start\n");
        System.out.println("===============SORT MANAGER===============\n");
    }

//    /**
//     * Prints the result of a sorting algorithm.
//     *
//     * @param result result of a sorting algorithm
//     */
//    public void getResult(String result){
//        SortManagerMain.logger.debug("result= " + result);
//        System.out.println("------------------------------------------\n"
//                + "Sorted Array:\n\n"
//                + result);
//    }

    public void getResult(String result, String sortMethod){
        SortManagerMain.logger.debug("result= " + result);
//        System.out.println("------------------------------------------\n"
//                + "Unsorted array:\n\n"
//                + displayArray(unsortedArray));
//        System.out.println("------------------------------------------\n"
//                + "Array sorted with Arrays.sort():\n\n"
//                + displayArray(comparisonArray)
//                + "\n------------------------------------------");
        System.out.println("Sorted Array with " + sortMethod + " :\n\n"
                + result
                + "\n------------------------------------------");
    }
    public void getEnd(int[] unsortedArray, int[] comparisonArray){
        System.out.println("------------------------------------------\n"
                + "Unsorted array:\n\n"
                + displayArray(unsortedArray)
                + "\n------------------------------------------\n"
                + "Array sorted with Arrays.sort():\n\n"
                + displayArray(comparisonArray)
                + "\n------------------------------------------");
    }

    public String getDuration(long duration, String sortMethod){
        return "Execution time(" + sortMethod + ") in nano seconds:\n" + (duration)
                + "\nMilliseconds:\n" + ((double)(duration)/1000000)
                + "\nSeconds:\n" + ((double)(duration)/1000000000);
    }

}
