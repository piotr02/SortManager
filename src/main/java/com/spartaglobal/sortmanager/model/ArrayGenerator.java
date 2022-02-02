package com.spartaglobal.sortmanager.model;

import com.spartaglobal.sortmanager.view.DisplayManager;

import java.util.Random;
import java.util.Scanner;

public class ArrayGenerator {
    private int[] unsortedArray;

    /**
     * Generates an array of given size populated with random numbers within given range.
     *
     * @param size desired size of the array
     * @param bounds desired range of the numbers in the array
     */
    public void generateRandomArray(int size, int bounds){
        Random r = new Random();
        int[] array = new int[size];
        for(int i = 0; i < array.length; i++){
            array[i] = r.nextInt(-bounds, bounds);
        }
        unsortedArray = array;
    }

    /**
     * Returns the unsorted array generated by one of the methods in this class.
     *
     * @return unsorted array
     */
    public int[] getUnsortedArray() {
        return unsortedArray;
    }

    /**
     * Generates a custom array of given size populated with given numbers.
     *
     * @param size desired size of the array
     */
    public void generateCustomArray(int size){
        Scanner sc = new Scanner(System.in);
        int[] createdArray = new int[size];
        for(int i = 0; i < createdArray.length; i++){
            System.out.println("------------------------------------------\n"
                    + "Enter a value: ");
            while(!sc.hasNextInt()){
                System.out.println("Incorrect number! Enter a number: ");
                sc.next();
            }
            createdArray[i] = sc.nextInt();
        }
        unsortedArray = createdArray;
    }
}
