package com.spartaglobal.sortmanager.model;

import com.spartaglobal.sortmanager.view.DisplayManager;

import java.util.Random;
import java.util.Scanner;

public class ArrayGenerator {
    private int[] unsortedArray;

    public void generateRandomArray(int size, int bounds){
        Random r = new Random();
        int[] array = new int[size];
        for(int i = 0; i < array.length; i++){
            array[i] = r.nextInt(0, bounds);
        }
        unsortedArray = array;
    }

    public int[] getUnsortedArray() {
        return unsortedArray;
    }

    public void generateCustomArray(int size){
        Scanner sc = new Scanner(System.in);
        int[] createdArray = new int[size];
        for(int i = 0; i < createdArray.length; i++){
            System.out.println("Enter a value: ");
            createdArray[i] = sc.nextInt();
        }
        unsortedArray = createdArray;
    }
}
