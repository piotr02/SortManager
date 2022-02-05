package com.spartaglobal.sortmanager;

import com.spartaglobal.sortmanager.model.BinarySearchTreeFacade;
import com.spartaglobal.sortmanager.view.DisplayManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTreeFacadeTester {
    private static BinarySearchTreeFacade bstf;
    private static DisplayManager view;
    @BeforeAll
    public static void setUp(){
        bstf = new BinarySearchTreeFacade();
        view = new DisplayManager();
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Given an empty source, returns []")
    public void givenEmptySource_BinarySearchTreeFacadeReturnsEmptyArray(int[] test){
        assertEquals("[]", view.displayArray(bstf.sort(test)));
    }

    @Test
    @DisplayName("Give an array with negative numbers, returns a sorted array")
    public void givenArrayWithNegativeNumbers_BinarySearchTreeFacadeReturnsSortedArray(){
        int[] test = {-12, 55, 0, -1, -76, -90};
        var expected = "[-90, -76, -12, -1, 0, 55]";
        var actual = view.displayArray(bstf.sort(test));
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Give an array with uneven length, returns a sorted array")
    public void givenArrayWithUnevenLength_BinarySearchTreeFacadeReturnsSortedArray(){
        int[] test = {-12, 55, -1, -76, -90};
        var expected = "[-90, -76, -12, -1, 55]";
        var actual = view.displayArray(bstf.sort(test));
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Give an array with one value, returns a sorted array")
    public void givenArrayWithOneValue_BinarySearchTreeFacadeReturnsSortedArray(){
        int[] test = {-12};
        var expected = "[-12]";
        var actual = view.displayArray(bstf.sort(test));
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Given an array with duplicate values, returns a sorted array")
    public void givenArrayWithDuplicateValues_BinarySearchTreeFacadeReturnsSortedArray(){
        int[] test = {-12, -6, 75, 0, 23, -1, -6};
        var expected = "[-12, -6, -6, -1, 0, 23, 75]";
        var actual = view.displayArray(bstf.sort(test));
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Given a null array, returns an empty array")
    public void givenNullArray_BinarySearchTreeFacadeReturnsEmptyArray(){
        int[] test = null;
        var expected = "[]";
        var actual = view.displayArray(bstf.sort(test));
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Given an array with max int, returns a sorted array")
    public void givenArrayWithMaxInt_BinarySearchTreeFacadeReturnsSortedArray(){
        int[] test = {Integer.MAX_VALUE};
        var expected = "["+Integer.MAX_VALUE+"]";
        var actual = view.displayArray(bstf.sort(test));
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Given an array with min int, returns a sorted array")
    public void givenArrayWithMinInt_BinarySearchTreeFacadeReturnsSortedArray(){
        int[] test = {Integer.MIN_VALUE};
        var expected = "["+Integer.MIN_VALUE+"]";
        var actual = view.displayArray(bstf.sort(test));
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Given an array with all values = 0, returns a sorted array")
    public void givenArrayWithSameValues_BinarySearchTreeFacadeReturnsSortedArray(){
        int[] test = {0, 0, 0, 0, 0};
        var expected = "[0, 0, 0, 0, 0]";
        var actual = view.displayArray(bstf.sort(test));
        assertEquals(expected, actual);
    }
}
