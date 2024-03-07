package org.jfree.data.test.datautilities;

import org.jfree.data.DataUtilities;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.security.InvalidParameterException;

public class CreateNumberArrayTests {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();


    /**
     * Test createNumberArray2D with fully empty array of double arrays
     * data = double[]{}
     * expected = Number[]{}
     */
    @Test
    public void validData_EmptyDoubleArray() {
        Number[] expected = {};
        Assert.assertArrayEquals(expected,
                DataUtilities.createNumberArray(new double[]{}));
    }

    /**
     * Test createNumberArray with basic double array
     * data = double[]{1d, 2d, 3d}
     * expected = Number[]{1d, 2d, 3d}
     */
    @Test
    public void validData_BasicDoubleArray() {
        Number[] expected = {1d, 2d, 3d};
        Assert.assertArrayEquals(expected,
                DataUtilities.createNumberArray(new double[]{1d, 2d, 3d}));
    }


    /**
     * Test createNumberArray with basic double array that contains the max value for a double
     * data = double[]{Double.MAX_VALUE, 2d, 3d}
     * expected = Number[]{Double.MAX_VALUE, 2d, 3d}
     */
    @Test
    public void validData_MaxValueInDoubleArray() {

        Number[] expected = {Double.MAX_VALUE, 2d, 3d};
        Assert.assertArrayEquals(expected,
                DataUtilities.createNumberArray(new double[]{Double.MAX_VALUE, 2d, 3d}));
    }


    /**
     * Test createNumberArray with basic double array that contains the min value for a double
     * data = double[]{Double.MIN_VALUE, 2d, 3d}
     * expected = Number[]{Double.MIN_VALUE, 2d, 3d}
     */
    @Test
    public void validData_MinValueInDoubleArray() {
        Number[] expected = {Double.MIN_VALUE, 2d, 3d};
        Assert.assertArrayEquals(expected,
                DataUtilities.createNumberArray(new double[]{Double.MIN_VALUE, 2d, 3d}));
    }


    /**
     * Test createNumberArray with a null value for data
     * this should throw an InvalidParameterException
     */
    @Test
    public void nullData_ThrowInvalidParameterException() {
        exceptionRule.expect(InvalidParameterException.class);
        Number[] result = DataUtilities.createNumberArray(null);
    }

    /**
     * Test createNumberArray with a null value inside of data
     * this should throw an InvalidParameterException
     * data = double[]{Double.NaN}
     */
    @Test
    public void partialNullData_ThrowInvalidParameterException() {
        exceptionRule.expect(InvalidParameterException.class);
        Number[] result = DataUtilities.createNumberArray(new double[]{Double.NaN});
    }
}
