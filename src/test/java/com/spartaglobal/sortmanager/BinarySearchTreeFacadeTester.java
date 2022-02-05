package com.spartaglobal.sortmanager;

import com.spartaglobal.sortmanager.model.BinarySearchTree;
import com.spartaglobal.sortmanager.view.DisplayManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTreeTester {
    private static MergeSort ms;
    private static DisplayManager view;
    @BeforeAll
    public static void setUp(){
        ms = new MergeSort();
        view = new DisplayManager();
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Given an empty source, returns []")
    public void givenEmptySource_MergeSortReturnsEmptyArray(int[] test){
        ms.sort(test);
        assertEquals("[]", view.displayArray(test));
    }

    @Test
    @DisplayName("Give an array with negative numbers, returns a sorted array")
    public void givenArrayWithNegativeNumbers_MergeSortReturnsSortedArray(){
        int[] test = {-12, 55, 0, -1, -76, -90};
        var expected = "[-90, -76, -12, -1, 0, 55]";
        ms.sort(test);
        var actual = view.displayArray(test);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Give an array with uneven length, returns a sorted array")
    public void givenArrayWithUnevenLength_MergeSortReturnsSortedArray(){
        int[] test = {-12, 55, -1, -76, -90};
        var expected = "[-90, -76, -12, -1, 55]";
        ms.sort(test);
        var actual = view.displayArray(test);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Give an array with one value, returns a sorted array")
    public void givenArrayWithOneValue_MergesSortReturnsSortedArray(){
        int[] test = {-12};
        var expected = "[-12]";
        ms.sort(test);
        var actual = view.displayArray(test);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Given an array with duplicate values, returns a sorted array")
    public void givenArrayWithDuplicateValues_MergeSortReturnsSortedArray(){
        int[] test = {-12, -6, 75, 0, 23, -1, -6};
        var expected = "[-12, -6, -6, -1, 0, 23, 75]";
        ms.sort(test);
        var actual = view.displayArray(test);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Given a null array, returns an empty array")
    public void givenNullArray_MergeSortReturnsEmptyArray(){
        int[] test = null;
        var expected = "[]";
        ms.sort(test);
        var actual = view.displayArray(test);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Given an array with max int, returns a sorted array")
    public void givenArrayWithMaxInt_MergeSortReturnsSortedArray(){
        int[] test = {Integer.MAX_VALUE};
        var expected = "["+Integer.MAX_VALUE+"]";
        ms.sort(test);
        var actual = view.displayArray(test);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Given an array with min int, returns a sorted array")
    public void givenArrayWithMinInt_MergeSortReturnsSortedArray(){
        int[] test = {Integer.MIN_VALUE};
        var expected = "["+Integer.MIN_VALUE+"]";
        ms.sort(test);
        var actual = view.displayArray(test);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Given an array with all values = 0, returns a sorted array")
    public void givenArrayWithSameValues_MergeSortReturnsSortedArray(){
        int[] test = {0, 0, 0, 0, 0};
        var expected = "[0, 0, 0, 0, 0]";
        ms.sort(test);
        var actual = view.displayArray(test);
        assertEquals(expected, actual);
    }
}
