package com.spartaglobal.sortmanager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArraySortTester {

    private static ArraySort as;
    @BeforeAll
    public static void setUp(){
        as = new ArraySort();
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Given an empty source, returns []")
    public void givenEmptySource_BubbleSortReturnsEmptyArray(int[] ints){
        as.bubbleSort(ints);
        assertEquals("[]", as.getArray(ints));
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Given an empty source, returns []")
    public void givenEmptySource_MergeSortReturnsEmptyArray(int[] ints){
        as.mergeSort(ints, 0);
        assertEquals("[]", as.getArray(ints));
    }

    @Test
    @DisplayName("Give an array with negative numbers, returns a sorted array")
    public void givenArrayWithNegativeNumbers_BubbleSortReturnsSortedArray(){
        int[] test = {-12, 55, 0, -1, -76, -90};
        var expected = "[-90, -76, -12, -1, 0, 55]";
        as.bubbleSort(test);
        var actual = as.getArray(test);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Give an array with negative numbers, returns a sorted array")
    public void givenArrayWithNegativeNumbers_MergeSortReturnsSortedArray(){
        int[] test = {-12, 55, 0, -1, -76, -90};
        var expected = "[-90, -76, -12, -1, 0, 55]";
        as.mergeSort(test, 6);
        var actual = as.getArray(test);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Give an array with uneven length, returns a sorted array")
    public void givenArrayWithUnevenLength_BubblesSortReturnsSortedArray(){
        int[] test = {-12, 55, -1, -76, -90};
        var expected = "[-90, -76, -12, -1, 55]";
        as.bubbleSort(test);
        var actual = as.getArray(test);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Give an array with uneven length, returns a sorted array")
    public void givenArrayWithUnevenLength_MergeSortReturnsSortedArray(){
        int[] test = {-12, 55, -1, -76, -90};
        var expected = "[-90, -76, -12, -1, 55]";
        as.mergeSort(test, 5);
        var actual = as.getArray(test);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Give an array with wrong length, returns a sorted array")
    public void givenArrayWithWrongLength_MergeSortReturnsSortedArray(){
        int[] test = {-12, 55, -1, -76, -90};
        var expected = "[-90, -76, -12, -1, 55]";
        as.mergeSort(test, 6);
        var actual = as.getArray(test);
        assertEquals(expected, actual);
    }
}
