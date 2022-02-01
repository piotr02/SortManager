package com.spartaglobal.sortmanager.view;

import java.util.Scanner;

public class DisplayManager {
    public String getDesiredSortMethod(){
        System.out.println("Please enter what sorting method to use: ");
        Scanner sc = new Scanner(System.in);
        String desiredSortMethod = sc.next();
        return desiredSortMethod;
    }

//    public String displayArray(int[] ints){
//        StringBuilder output = new StringBuilder();
//        if(ints.length == 0){
//            output.append("[]");
//        }
//        else{
//            for(int number: ints){
//                output.append(number);
//                output.append(", ");
//            }
//            output.delete(0, output.length());
//            output.append("[");
//            for(int i = 0; i < ints.length; i++){
//                if(i < ints.length - 1){
//                    output.append(ints[i]);
//                    output.append(", ");
//                }
//                else{
//                    output.append(ints[i]);
//                    output.append("]");
//                }
//            }
//        }
//        return output.toString();
//    }

    public void getResult(String result){
        System.out.println(result);
    }
}
