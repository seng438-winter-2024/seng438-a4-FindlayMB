package org.jfree.data.datautilities.calculate;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CalculateRowTotalOverloadTests {
    private Mockery mockingContext;
    private Values2D values;

    private final double delta = 0.000000001d;

    @Before
    public void setUp() throws Exception {
        mockingContext = new Mockery();
        values = mockingContext.mock(Values2D.class);
    }

    /**
     * Set up mocking of a Values2D object for a given row
     *
     * @param row row number to total along in a Values2D object
     */
    public void setUpMocking(final int row) {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(5));
                one(values).getValue(row, 0);
                will(returnValue(1));
                one(values).getValue(row, 1);
                will(returnValue(1));
                one(values).getValue(row, 2);
                will(returnValue(1));
                one(values).getValue(row, 3);
                will(returnValue(1));
                one(values).getValue(row, 4);
                will(returnValue(1));
            }
        });
    }

    /**
     * Set up mocking of a Values2D object for a given row
     *
     * @param row             row number to total along in a Values2D object
     * @param outOfBoundsFlag Flag to see if row number is out of bounds
     */
    public void setUpMocking(final int row, boolean outOfBoundsFlag) {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(5));
                one(values).getValue(row, 0);
                will(throwException(new IndexOutOfBoundsException()));
                one(values).getValue(row, 1);
                will(throwException(new IndexOutOfBoundsException()));
                one(values).getValue(row, 2);
                will(throwException(new IndexOutOfBoundsException()));
                one(values).getValue(row, 3);
                will(throwException(new IndexOutOfBoundsException()));
                one(values).getValue(row, 4);
                will(throwException(new IndexOutOfBoundsException()));
            }
        });
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    /*
     * Following Tests are for the calculateRowTotal method with the parameters
     * Values2D data, int row, int[] validCols
     */

    /**
     * Testing calculateRowTotal row out of left index bounds
     * row < 1 - columnAmt
     * Parameters: values = 5x5 matrix filled with 1's
     * row = -5
     * <p>
     * Expected output: 0.0
     */
//    @Test
//    public void invalidRow_OutsideLeftBound() {
//        setUpMocking(-5, true);
//        assertEquals(0.0, DataUtilities.calculateRowTotal(values, -5, new int[]{0,1,2,3,4}), delta);
//    }

    /**
     * Testing calculateRowTotal row out of left index bounds
     * row = 1 - columnAmt
     * Parameters: values = 5x5 matrix filled with 1's
     * row = -4
     * <p>
     * Expected output: 5.0
     */
    @Test
    public void validRow_LeftBoundary() {
        setUpMocking(-4);
        assertEquals(5.0, DataUtilities.calculateRowTotal(values, -4, new int[]{0,1,2,3,4}), delta);
    }

    /**
     * Testing calculateRowTotal row out of left index bounds
     * 1 - columnAmt < row < 0
     * Parameters: values = 5x5 matrix filled with 1's
     * row = -2
     * <p>
     * Expected output: 5.0
     */
    @Test
    public void validRow_BetweenLeftBoundaryZero() {
        setUpMocking(-2);
        assertEquals(5.0, DataUtilities.calculateRowTotal(values, -2, new int[]{0,1,2,3,4}), delta);
    }

    /**
     * Testing calculateRowTotal with row = 0
     * Parameters: values = 5x5 matrix filled with 1's
     * row = 0
     * <p>
     * Expected output: 5.0
     */
    @Test
    public void validRow_Zero() {
        setUpMocking(0);
        assertEquals(5.0, DataUtilities.calculateRowTotal(values, 0, new int[]{0,1,2,3,4}), delta);
    }

    /**
     * Testing calculateRowTotal row out of left index bounds
     * 0 < row < columnAmt - 1
     * Parameters: values = 5x5 matrix filled with 1's
     * row = 2
     * <p>
     * Expected output: 5.0
     */
    @Test
    public void validRow_BetweenZeroRightBoundary() {
        setUpMocking(2);
        assertEquals(5.0, DataUtilities.calculateRowTotal(values, 2, new int[]{0,1,2,3,4}), delta);
    }

    /**
     * Testing calculateRowTotal row in upper bound
     * row = columnAmt - 1
     * Parameters: values = 5x5 matrix filled with 1's
     * row = 4
     * <p>
     * Expected output: 5.0
     */
    @Test
    public void validRow_RightBoundary() {
        setUpMocking(4);
        assertEquals(5.0, DataUtilities.calculateRowTotal(values, 4, new int[]{0,1,2,3,4}), delta);
    }

    /**
     * Testing calculateRowTotal row out of left index bounds
     * row > columnAmt - 1
     * Parameters: values = 5x5 matrix filled with 1's
     * row = 5
     * <p>
     * Expected output: 0.0
     */
//    @Test
//    public void invalidRow_OutsideRightBound() {
//        setUpMocking(5, true);
//        assertEquals(0.0,
//                DataUtilities.calculateRowTotal(values, 5, new int[]{0,1,2,3,4}), delta);
//    }


    /**
     * Testing calculateRowTotal for an empty Values2D object
     * Expected output: 0.0
     */
    @Test
    public void emptyData_ReturnZero(){
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount(); will(returnValue(0));
            }
        });
        assertEquals(0, DataUtilities.calculateRowTotal(values, 0, new int[]{}), delta);
    }

    @Test
    public void validColsIncludesInvalidColumns_ignoresInvalidColumns(){
        setUpMocking(2);
        assertEquals(5, DataUtilities.calculateRowTotal(values, 2, new int[]{0,1,2,3,4,5,6}), delta);
    }

    /**
     * Test calculateRowTotal with a null value for data
     * this should throw an IllegalArgumentException
     */
    @Test
    public void nullData_ThrowInvalidParameterException() {
        exceptionRule.expect(IllegalArgumentException.class);
        DataUtilities.calculateRowTotal(null, 1, new int[]{0, 1});
    }

    /**
     * Test calculateRowTotal with a null value inside of data
     * Will ignore null values in data
     * Expected output: 7.5
     */
    @Test
    public void partialNullData_ThrowInvalidParameterException() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount(); will(returnValue(2));
                one(values).getValue(0, 0); will(returnValue(7.5));
                one(values).getValue(0, 1); will(returnValue(null));
            }
        });
        assertEquals(7.5, DataUtilities.calculateRowTotal(values, 0, new int[]{0, 1}), delta);
    }

    /**
     * Test calculateRowTotal with a null value for validCols
     * this should throw an IllegalArgumentException
     */
//    @Test
//    public void validData_nullValidRows_ReturnsZero() {
//        mockingContext.checking(new Expectations() {
//            {
//                one(values).getColumnCount(); will(returnValue(2));
//                one(values).getValue(0, 0); will(returnValue(7.5));
//                one(values).getValue(1, 0); will(returnValue(2.5));
//            }
//        });
//        assertEquals(0, DataUtilities.calculateRowTotal(values, 0, null), delta);
//    }

}
