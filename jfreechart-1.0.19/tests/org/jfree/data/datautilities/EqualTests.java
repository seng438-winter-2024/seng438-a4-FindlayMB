package org.jfree.data.datautilities;

import org.jfree.data.DataUtilities;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class EqualTests {

    /**
     * Testing boolean equal(double[][] a, double[][] b)
     * Where a = null and b = null.
     * Expected output: True
     */
    @Test
    public void matching_Null_returnTrue() {
        assertTrue(DataUtilities.equal(null, null));
    }


    /**
     * Testing boolean equal(double[][] a, double[][] b)
     * Where a = null and b = {{1,2},{1,2}}
     * Expected output: False
     */
    @Test
    public void firstParameter_Null_returnFalse() {
        assertFalse(
                DataUtilities.equal(
                        null,
                        new double[][]{{1,2},{1,2}}));
    }


    /**
     * Testing boolean equal(double[][] a, double[][] b)
     * Where a = {{1,2},{1,2}} and b = null
     * Expected output: False
     */
    @Test
    public void secondParameter_Null_returnFalse() {
        assertFalse(
                DataUtilities.equal(
                        new double[][]{{1,2},{1,2}},
                        null));
    }



    /**
     * Testing boolean equal(double[][] a, double[][] b)
     * Where a and b are matching 2D double arrays.
     * a = b = {{1},{2}}
     * Expected output: True
     */
    @Test
    public void matching_1D_doubleArray_returnTrue() {
        assertTrue(
                DataUtilities.equal(
                        new double[][]{{1},{2}},
                        new double[][]{{1},{2}}));
    }


    /**
     * Testing boolean equal(double[][] a, double[][] b)
     * Where a and b are matching 2D double arrays.
     * a = b = {{1,2},{1,2}}
     * Expected output: True
     */
    @Test
    public void matching_2D_doubleArray_returnTrue() {
        assertTrue(
                DataUtilities.equal(
                        new double[][]{{1,2},{1,2}},
                        new double[][]{{1,2},{1,2}}));
    }


    /**
     * Testing boolean equal(double[][] a, double[][] b)
     * Where the row amount of a and b don't match.
     * a has 1 row and b has 2 rows
     * Expected output: False
     */
    @Test
    public void rowAmountMismatch_returnFalse() {
        assertFalse(DataUtilities.equal(new double[][]{{1,2}}, new double[][]{{1,2},{1,2}}));
    }


    /**
     * Testing boolean equal(double[][] a, double[][] b)
     * Where the column amount of a and b don't match.
     * a has 1 column and b has 2 columns
     * Expected output: False
     */
    @Test
    public void columnAmountMismatch_returnFalse() {
        assertFalse(DataUtilities.equal(new double[][]{{1}, {1}}, new double[][]{{1,2},{1,2}}));
    }
}
