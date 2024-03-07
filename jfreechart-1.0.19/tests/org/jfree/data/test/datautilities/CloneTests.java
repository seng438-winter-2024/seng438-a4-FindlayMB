package org.jfree.data.test.datautilities;

import org.jfree.data.DataUtilities;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

public class CloneTests {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();


    /**
     * Test clone method to verify that a valid 2D double array is cloned correctly.
     * 
     * @return void
     */
    @Test
    public void validSource_2D_doubleArray_returnClone(){
        double[][] expected = new double[][]{{1,2},{3,4}};
        assertArrayEquals(expected, DataUtilities.clone(expected));
    }


    /**
     * Test clone method to verify that a valid source containing null elements is cloned correctly.
     */
    @Test
    public void validSource_containsNull_returnClone() {
        double[][] expected = new double[][]{null,{1,2}};
        assertArrayEquals(expected, DataUtilities.clone(expected));
    }

    
    /**
     * Test clone method to verify that an empty 1D source returns an empty array upon cloning.
     */
    @Test
    public void emptySource_1D_returnEmptyArray(){
        double[][] expected = new double[][]{};
        assertArrayEquals(expected, DataUtilities.clone(expected));
    }

    
    /**
     * Test clone method to verify that an empty 2D source returns an empty array upon cloning.
     */
    @Test
    public void emptySource_2D_returnEmptyArray(){
        double[][] expected = new double[][]{{},{}};
        assertArrayEquals(expected, DataUtilities.clone(expected));
    }

    
    /**
     * Test clone method to verify that a partially empty source is cloned correctly.
     */
    @Test
    public void partialEmptySource_returnClone() {
        double[][] expected = new double[][]{{},{1,2}};
        assertArrayEquals(expected, DataUtilities.clone(expected));
    }


    /**
     * Test clone method to verify that passing a null source to the clone 
     * method throws an IllegalArgumentException.
     * 
     * @throws IllegalArgumentException if the source array is null
     */
    @Test
    public void nullSource_throwIllegalArgumentException(){
        exceptionRule.expect(IllegalArgumentException.class);
        DataUtilities.clone(null);
    }
}
