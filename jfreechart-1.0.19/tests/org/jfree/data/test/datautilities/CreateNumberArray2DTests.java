package org.jfree.data.test.datautilities;

import org.jfree.data.DataUtilities;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertArrayEquals;

import java.security.InvalidParameterException;

public class CreateNumberArray2DTests {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();


    /**
     * Test createNumberArray2D with fully empty array of double arrays
     * data = double[][]{{}}
     * expected = Number[][]{{}}
     */
    @Test
    public void validData_Empty2dDoubleArray() {
        Number[][] expected = {{}};
        Assert.assertArrayEquals(expected, DataUtilities.createNumberArray2D(
        			new double[][]{{}}));
    }


    /**
     * Test createNumberArray2D with basic multidimensional array
     * data = double[][]{{1d, 2d, 3d}}
     * expected = Number[][]{{1d, 2d, 3d}}
     */
    @Test
    public void validData_Basic1dDoubleArray() {
        Number[][] expected = {{1d, 2d, 3d}};
        assertArrayEquals(expected,DataUtilities.createNumberArray2D(
        		new double[][]{{1d, 2d, 3d}}));
    }

    /**
     * Test createNumberArray2D with basic multidimensional double array
     * data = double[][]{{1d, 2d}, {1d, 2d}}
     * expected = Number[][]{{1d, 2d}, {1d, 2d}}
     */
    @Test
    public void validData_Basic2dDoubleArray() {
        Number[][] expected = {{1d, 2d}, {1d, 2d}};
        assertArrayEquals(expected, DataUtilities.createNumberArray2D(
        		new double[][]{{1d, 2d}, {1d, 2d}}));
    }


    /**
     * Test createNumberArray2D with basic double array that contains the max value for a double
     * data = double[][]{{Double.MAX_VALUE, 2d},{3d, 4d}}
     * expected = Number[][]{{Double.MAX_VALUE, 2d},{3d, 4d}}
     */
    @Test
    public void validData_MaxValueIn2dDoubleArray() {
        Number[][] expected = {{Double.MAX_VALUE, 2d}, {3d, 4d}};
        Assert.assertArrayEquals(expected, DataUtilities.createNumberArray2D(
        		new double[][]{{Double.MAX_VALUE, 2d}, {3d, 4d}}));
    }


    /**
     * Test createNumberArray2D with basic double array that contains the min value for a double
     * data = double[][]{{Double.MIN_VALUE, 2d},{3d, 4d}}
     * expected = Number[][]{{Double.MIN_VALUE, 2d},{3d, 4d}}
     */
    @Test
    public void validData_MinValueIn2dDoubleArray() {
        Number[][] expected = {{Double.MIN_VALUE, 2d}, {3d, 4d}};
        Assert.assertArrayEquals(expected, DataUtilities.createNumberArray2D(
        		new double[][]{{Double.MIN_VALUE, 2d}, {3d, 4d}}));
    }


    /**
     * Test createNumberArray2D with a null value for data
     * this should throw an InvalidParameterException
     */
    @Test
    public void nullData_ThrowInvalidParameterException() {
        exceptionRule.expect(InvalidParameterException.class);
        DataUtilities.createNumberArray2D(null);
    }


    /**
     * Test createNumberArray2D with a null value inside of data
     * this should throw an InvalidParameterException
     * data = double[][]{{},{1d,2d}}
     */
    @Test
    public void partialNullData_ThrowInvalidParameterException() {
        exceptionRule.expect(InvalidParameterException.class);
        DataUtilities.createNumberArray2D(new double[][]{{}, {1d, 2d}});
    }

}