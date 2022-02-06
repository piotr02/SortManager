package com.spartaglobal.sortmanager;

import com.spartaglobal.sortmanager.model.ArrayGenerator;
import com.spartaglobal.sortmanager.view.DisplayManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayGeneratorTester {
    private static ArrayGenerator ag;
    @BeforeAll
    public static void setUp(){
        ag = new ArrayGenerator();
    }

    @Test
    @DisplayName("Given an array length, generateRandomArray returns an array of the same length")
    public void givenArrayLength_GenerateRandomArrayReturnsArrayOfSameLength(){
        int arrayLength = 10;
        int arrayBounds = 100;
        var expected = 10;
        ag.generateRandomArray(arrayLength, arrayBounds);
        var actual = ag.getUnsortedArray().length;
        assertEquals(expected, actual);
    }
}
