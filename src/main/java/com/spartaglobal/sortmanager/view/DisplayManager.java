package com.spartaglobal.sortmanager.view;

public class DisplayManager {
    /**
     * Converts an array into a readable String format.
     *
     * @param ints array to be converted
     * @return array in a String format
     */
    public String displayArray(int[] ints){
        StringBuilder output = new StringBuilder();
        if(ints == null || ints.length == 0){
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
     * Prints program headline.
     */
    public void printStart(){
        System.out.println("===============SORT MANAGER===============\n");
    }

    /**
     * Prints the result with the sorting method.
     *
     * @param result result of the sort
     * @param sortMethod method used for sorting
     */
    public void printResult(String result, String sortMethod, long duration){
        System.out.println("Sorted Array with " + sortMethod + " :\n\n"
                + result
                + "\n------------------------------------------\n"
                + getDuration(duration, sortMethod)
                + "\n------------------------------------------");
    }

    /**
     * Prints an unsorted array and an array sorted with Arrays.sort().
     *
     * @param unsortedArray unsorted array
     * @param comparisonArray array sorted with Arrays.sort()
     */
    public void printEnd(int[] unsortedArray, int[] comparisonArray){
        System.out.println("------------------------------------------\n"
                + "Unsorted array:\n\n"
                + displayArray(unsortedArray)
                + "\n------------------------------------------\n"
                + "Array sorted with Arrays.sort():\n\n"
                + displayArray(comparisonArray)
                + "\n------------------------------------------");
    }

    /**
     * Returns a String with the time the sorting algorithm took.
     *
     * @param duration time taken by the sorting algorithm
     * @param sortMethod sorting algorithm used
     * @return String with the time the sorting algorithm took
     */
    public String getDuration(long duration, String sortMethod){
        return "Execution time (" + sortMethod + ") in:\nNanoseconds:\n" + (duration)
                + "\nMilliseconds:\n" + ((double)(duration)/1000000)
                + "\nSeconds:\n" + ((double)(duration)/1000000000);
    }
}
