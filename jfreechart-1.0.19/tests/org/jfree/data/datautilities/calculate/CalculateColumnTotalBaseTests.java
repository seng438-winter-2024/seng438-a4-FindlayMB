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

public class CalculateColumnTotalBaseTests {
    private Mockery mockingContext;
    private Values2D values;

    private final double delta = 0.000000001d;

    @Before
    public void setUp() throws Exception {
        // Setup
        mockingContext = new Mockery();
        values = mockingContext.mock(Values2D.class);
    }

    /**
     * Set up mocking of a Values2D object for a given column
     *
     * @param column column number to total along in a Values2D object
     */
    public void setUpMocking(final int column) {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount(); will(returnValue(5));
                one(values).getValue(0, column); will(returnValue(1));
                one(values).getValue(1, column); will(returnValue(1));
                one(values).getValue(2, column); will(returnValue(1));
                one(values).getValue(3, column); will(returnValue(1));
                one(values).getValue(4, column); will(returnValue(1));
            }
        });
    }

    public void setUpMocking(final int column, boolean outOfBoundsFlag) {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount(); will(returnValue(5));
                one(values).getValue(0, column); will(throwException(new IndexOutOfBoundsException()));
                one(values).getValue(1, column); will(throwException(new IndexOutOfBoundsException()));
                one(values).getValue(2, column); will(throwException(new IndexOutOfBoundsException()));
                one(values).getValue(3, column); will(throwException(new IndexOutOfBoundsException()));
                one(values).getValue(4, column); will(throwException(new IndexOutOfBoundsException()));
            }
        });
    }


    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    /**
     * Testing calculateColumnTotal column out of left index bounds
     * column < 1 - rowAmt
     * Parameters:  values = 5x5 matrix filled with 1's
     * column = -5
     * <p>
     * Expected output: 0.0
     */
//    @Test
//    public void invalidColumn_OutsideLeftBound() {
//        setUpMocking(-5, true);
//        assertEquals(0.0, DataUtilities.calculateColumnTotal(values, -5), delta);
//    }


    /**
     * Testing calculateColumnTotal column out of left index bounds
     * column = 1 - rowAmt
     * Parameters:  values = 5x5 matrix filled with 1's
     * column = -4
     * <p>
     * Expected output: 5.0
     */
    @Test
    public void validColumn_LeftBoundary() {
        setUpMocking(-4);
        assertEquals(5.0, DataUtilities.calculateColumnTotal(values, -4), delta);
    }

    /**
     * Testing calculateColumnTotal column out of left index bounds
     * 1 - rowAmt < column < 0
     * Parameters:  values = 5x5 matrix filled with 1's
     * column = -2
     * <p>
     * Expected output: 5.0
     */
    @Test
    public void validColumn_BetweenLeftBoundaryZero() {
        setUpMocking(-2);
        assertEquals(5.0, DataUtilities.calculateColumnTotal(values, -2), delta);
    }

    /**
     * Testing calculateColumnTotal with a valid parameters
     * column = 0
     * Parameters:  values = 5x5 matrix filled with 1's
     * column = 0
     * <p>
     * Expected output: 5.0
     */
    @Test
    public void validColumn_Zero() {
        setUpMocking(0);
        assertEquals(5.0, DataUtilities.calculateColumnTotal(values, 0), delta);
    }

    /**
     * Testing calculateColumnTotal column out of left index bounds
     * 0 < column < rowAmt - 1
     * Parameters:  values = 5x5 matrix filled with 1's
     * column = 2
     * <p>
     * Expected output: 5.0
     */
    @Test
    public void validColumn_BetweenZeroRightBoundary() {
        setUpMocking(2);
        assertEquals(5.0, DataUtilities.calculateColumnTotal(values, 2), delta);
    }

    /**
     * Testing calculateColumnTotal column in upper bound
     * column = rowAmt - 1
     * Parameters:  values = 5x5 matrix filled with 1's
     * column = 4
     * <p>
     * Expected output: 5.0
     */
    @Test
    public void validColumn_RightBoundary() {
        setUpMocking(4);
        assertEquals(5.0, DataUtilities.calculateColumnTotal(values, 4), delta);
    }


    /**
     * Testing calculateColumnTotal column out of right index bounds
     * column > rowAmt - 1
     * Parameters:  values = 5x5 matrix filled with 1's
     * column = 5
     * <p>
     * Expected output: 0.0
     */
//    @Test
//    public void invalidColumn_OutsideRightBound() {
//        setUpMocking(5, true);
//        assertEquals(0.0, DataUtilities.calculateColumnTotal(values, 5), delta);
//    }

    /**
     * Testing calculateColumTotal for an empty Values2D object
     *
     * Expected output: 0.0
     */
    @Test
    public void emptyData_ReturnZero(){
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount(); will(returnValue(0));
            }
        });
        assertEquals(0, DataUtilities.calculateColumnTotal(values, 0), delta);
    }

    /**
     * Test calculateColumnTotal with a null value for data
     * this should throw an IllegalArgumentException
     */
    @Test
    public void nullData_ThrowIllegalArgumentException() {
        exceptionRule.expect(IllegalArgumentException.class);
        DataUtilities.calculateColumnTotal(null, 0);
    }

    /**
     * Test calculateColumnTotal with a null value inside of data
     * Will ignore null values in data
     * Expected output: 7.5
     */
    @Test
    public void partialNullData_ignoreNull_returnTotal() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount(); will(returnValue(2));
                one(values).getValue(0, 0); will(returnValue(7.5));
                one(values).getValue(1, 0); will(returnValue(null));
            }
        });
        assertEquals(7.5, DataUtilities.calculateColumnTotal(values, 0), delta);
    }






}
