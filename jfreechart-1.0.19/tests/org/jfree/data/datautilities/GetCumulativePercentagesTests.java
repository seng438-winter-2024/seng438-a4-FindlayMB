package org.jfree.data.datautilities;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetCumulativePercentagesTests {
    private Mockery mockingContext;
    private KeyedValues values;


    @Before
    public void setUp() {
        // Setup
        mockingContext = new Mockery();
        values = mockingContext.mock(KeyedValues.class);
        mockingContext.checking(new Expectations() {
            {
                allowing(values).getItemCount(); will(returnValue(3));
                allowing(values).getKey(0); will(returnValue(0));
                allowing(values).getValue(0); will(returnValue(5d));
                allowing(values).getKey(1); will(returnValue(1));
                allowing(values).getValue(1); will(returnValue(9d));
                allowing(values).getKey(2); will(returnValue(2));
                allowing(values).getValue(2); will(returnValue(2d));
            }
        });
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();


    /**
     * Test getCumulativePercentages with empty keyed values
     * data = DefaultKeyedValues{}
     * size of resulting KeyedValues = 0
     */
    @Test
    public void validData_EmptyKeyedValues() {
        DefaultKeyedValues expected = new DefaultKeyedValues();
        assertTrue(expected.equals(DataUtilities.getCumulativePercentages(new DefaultKeyedValues())));
    }


    /**
     * Test getCumulativePercentages with single keyed value
     * data = DefaultKeyedValues{0:2.0}
     * result = KeyedValues{0:1.0}
     */
    @Test
    public void validData_SingleKeyedValue() {
        mockingContext = new Mockery();
        values = mockingContext.mock(KeyedValues.class);
        mockingContext.checking(new Expectations() {
            {
                allowing(values).getItemCount(); will(returnValue(1));
                allowing(values).getKey(0); will(returnValue(0));
                allowing(values).getValue(0); will(returnValue(2d));

            }
        });

        DefaultKeyedValues expected = new DefaultKeyedValues();
        expected.addValue((Comparable<?>)0, 1.0);

        KeyedValues results = DataUtilities.getCumulativePercentages(values);

        assertTrue(expected.equals(results));
    }

    /**
     * Test getCumulativePercentages with all positive keyed values
     * data = KeyedValues{0:5.0, 1:9.0, 2:2.0}
     * result = KeyedValues{0:0.3125, 1:0.875, 2:1.0}
     */
    @Test
    public void validKeyedValues_AllPositive() {
        DefaultKeyedValues expected = new DefaultKeyedValues();
        expected.addValue((Comparable<?>)0, 0.3125);
        expected.addValue((Comparable<?>)1, 0.875);
        expected.addValue((Comparable<?>)2, 1.0);

        KeyedValues results = DataUtilities.getCumulativePercentages(values);
        assertTrue(expected.equals(results));
    }

    /**
     * Test getCumulativePercentages with some negative keyed values
     * data = KeyedValues{0:5.0, 1:9.0, 2:-2.0}
     * result = KeyedValues{0:0.4167, 1:1.6667, 2:1.0}
     */
    @Test
    public void validKeyedValues_WithNegatives() {
        mockingContext = new Mockery();
        values = mockingContext.mock(KeyedValues.class);
        mockingContext.checking(new Expectations() {
            {
                allowing(values).getItemCount(); will(returnValue(3));
                allowing(values).getKey(0); will(returnValue(0));
                allowing(values).getValue(0); will(returnValue(5d));
                allowing(values).getKey(1); will(returnValue(1));
                allowing(values).getValue(1); will(returnValue(9d));
                allowing(values).getKey(2); will(returnValue(2));
                allowing(values).getValue(2); will(returnValue(-2d));
            }
        });
        DefaultKeyedValues expected = new DefaultKeyedValues();
        expected.addValue((Comparable<?>)0, (double) 5 / 12);
        expected.addValue((Comparable<?>)1, (double) 14 / 12);
        expected.addValue((Comparable<?>)2, 1);

        KeyedValues results = DataUtilities.getCumulativePercentages(values);
        assertTrue(expected.equals(results));
    }


    /**
     * Test getCumulativePercentages with string keys
     * data = KeyedValues{"A":5.0, "B":9.0, "C":2.0}
     * result = KeyedValues{"A":0.3125, "B":0.875, "C":1.0}
     */
    @Test
    public void validKeyedValues_StringKeys() {
        mockingContext = new Mockery();
        values = mockingContext.mock(KeyedValues.class);
        mockingContext.checking(new Expectations() {
            {
                allowing(values).getItemCount(); will(returnValue(3));
                allowing(values).getKey(0); will(returnValue("A"));
                allowing(values).getValue("A"); will(returnValue(5d));
                allowing(values).getValue(0); will(returnValue(5d));
                allowing(values).getKey(1); will(returnValue("B"));
                allowing(values).getValue("B"); will(returnValue(9d));
                allowing(values).getValue(1); will(returnValue(9d));
                allowing(values).getKey(2); will(returnValue("C"));
                allowing(values).getValue("C"); will(returnValue(2d));
                allowing(values).getValue(2); will(returnValue(2d));
            }
        });
        DefaultKeyedValues expected = new DefaultKeyedValues();
        expected.addValue("A", 0.3125);
        expected.addValue("B", 0.875);
        expected.addValue("C", 1.0);

        KeyedValues results = DataUtilities.getCumulativePercentages(values);

        assertTrue(expected.equals(results));
    }


    /**
     * Test getCumulativePercentages with a null value for data
     * this should throw an InvalidParameterException
     */
    @Test
    public void nullData_ThrowIllegalArgumentException() {
        exceptionRule.expect(IllegalArgumentException.class);
        DataUtilities.getCumulativePercentages(null);
    }

    /**
     * Test getCumulativePercentages with a null value inside of data
     * this should work since the null value will be ignored
     */
    @Test
    public void partialNullData_ThrowInvalidParameterException() {
        mockingContext = new Mockery();
        values = mockingContext.mock(KeyedValues.class);
        mockingContext.checking(new Expectations() {
            {
                allowing(values).getItemCount(); will(returnValue(3));
                allowing(values).getKey(0); will(returnValue(0));
                allowing(values).getValue(0); will(returnValue(5d));
                allowing(values).getKey(1); will(returnValue(1));
                allowing(values).getValue(1); will(returnValue(9d));
                allowing(values).getKey(2); will(returnValue(2));
                allowing(values).getValue(2); will(returnValue(null));
            }
        });

        DefaultKeyedValues expected = new DefaultKeyedValues();
        expected.addValue((Comparable<?>)0, (double) 5/14);
        expected.addValue((Comparable<?>)1, 1.0);
        expected.addValue((Comparable<?>)2, 1.0);

        KeyedValues result = DataUtilities.getCumulativePercentages(values);

        assertTrue(expected.equals(result));

    }
}
