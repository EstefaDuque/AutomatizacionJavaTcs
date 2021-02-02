package com.firstfewlines;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;

public class TestCalculation {

    //private final TestCalculation classUnderTest = new TestCalculation();

    private int number1;
    private int number2;

    @Before
    public void setUp() {
        number1 = 1;
        number2 = 2;
    }

    @After
    public void tearDown() {
        number1 = 0;
        number2 = 0;
    }

    @Test
    public void onePlusOneShouldBeTwo() {
        int sum = 1 + 1;
        assertEquals(2, sum);
    }

    @Test
    public void testAdd() {
        assertEquals(42, Integer.sum(19, 23));
    }

    /*
    @Test
    public void testSumOfTwoNumbers() {
        // set expectation
        int expectedResult = 3;

        // execute
        Object actualResult = classUnderTest.sum(number1, number2);

        // verify
        assertEquals(expectedResult, actualResult);
    }
    */

    private int sum(int number11, int number22) {
        return (int) number11 + number22;
    }
}