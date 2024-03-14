package org.jfree.data.range;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.jfree.data.Range;

public class IsNaNRangeTests {
    private Range rangeValid;
    private Range rangeNaN;
    private Range rangeLBNaN;
    private Range rangeUBNaN;

    @Before
    public void setUp() throws Exception {
        rangeValid = new Range(-1, 1);
        rangeNaN = new Range(Double.NaN, Double.NaN);
        rangeLBNaN = new Range(Double.NaN, 1);
        rangeUBNaN = new Range(-1, Double.NaN);
    }

    /**
     * Test isNanRange function with a valid range
     * Expected outcome: false.
     */
    @Test
    public void validRangeIsNotNaNRange() {
        assertEquals("False",
                false, rangeValid.isNaNRange());
    }

    /**
     * Test isNanRange function with a range of LB NaN
     * Expected outcome: false.
     */
    @Test
    public void LBNaNRangeIsNotNaNRange() {
        assertEquals("False",
                false, rangeLBNaN.isNaNRange());
    }

    /**
     * Test isNanRange function with a range of UB NaN
     * Expected outcome: false.
     */
    @Test
    public void UBNaNRangeIsNotNaNRange() {
        assertEquals("False",
                false, rangeUBNaN.isNaNRange());
    }

    /**
     * Test isNanRange function with a NaN range (both UB and LB are NaN)
     * Expected outcome: true.
     */
    @Test
    public void NaNRangeIsNaNRange() {
        assertEquals("True",
                true, rangeNaN.isNaNRange());
    }
}

