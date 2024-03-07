package org.jfree.data.test.range;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ShiftTests {
    private Range range1;
    private Range range2;
    private Range range3;

    @Before
    public void setUp() throws Exception {
        // ranges for tests
        range1 = new Range(-2, 2);
        range2 = new Range(-4, -1);
        range3 = new Range(1, 4);
    }

    /**
     * This test tests the shift function with an input of a null range
     * Expected outcome: illegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void shiftWithIllegalRange() {
        Range.shift(null, 1);
    }


    // the following tests have allowZeroCrossing set to true

    /**
     * This test tests the shift function with an input of a range of [-2,2]
     * and a delta of 1
     * Expected outcome: returns a range of [-1, 3]
     */
    @Test
    public void positiveRangeShift() {
        assertEquals("Expected a range of [-1, 3]",
                new Range(-1,3), Range.shift(range1, 1, true));
    }

    /**
     * This test tests the shift function with an input of a range of [-2,2]
     * and a delta of Double.Max
     * Expected outcome: returns a range of [Double.MAX_VALUE, Double.MAX_VALUE]
     */
    @Test
    public void maxValueRangeShift() {
        assertEquals("Expected a range of [Double.MAX_VALUE, Double.MAX_VALUE]",
                new Range(Double.MAX_VALUE, Double.MAX_VALUE), Range.shift(range1, Double.MAX_VALUE, true));
    }

    /**
     * This test tests the shift function with an input of a range of [-2,2]
     * and a delta of -1
     * Expected outcome: returns a range of [-3, 1]
     */
    @Test
    public void negativeRangeShift() {
        assertEquals("Expected a range of [-3, 1]",
                new Range(-3,1), Range.shift(range1, -1, true));
    }

    /**
     * This test tests the shift function with an input of a range of [-2,2]
     * and a delta of -Double.MAX_VALUE
     * Expected outcome: returns a range of [-Double.MAX_VALUE, -Double.MAX_VALUE]
     */
    @Test
    public void minValueRangeShift() {
        assertEquals("Expected a range of [-Double.MIN_VALUE, -Double.MIN_VALUE]",
                new Range(-Double.MAX_VALUE, -Double.MAX_VALUE), Range.shift(range1, -Double.MAX_VALUE, true));
    }

    /**
     * This test tests the shift function with an input of a range of [-2,2]
     * and a delta of 0, using Double.MIN_VALUE is an equivalence class
     * Expected outcome: returns a range of [-2, 2]
     */
    @Test
    public void zeroRangeShift() {
        assertEquals("Expected a range of [-2, 2]",
                new Range(-2, 2), Range.shift(range1, 0, true));
    }

    // the following tests have allowZeroCrossing set to false

    /**
     * This test tests the shift function with an input of a range of [-4, -1]
     * and a delta of 2
     * Expected outcome: returns a range of [-2, 0]
     */
    @Test
    public void positiveRangeShiftUBNoZeroCrossing() {
        assertEquals("Expected a range of [-2, 0]",
                new Range(-2, 0), Range.shift(range2, 2));
    }

    /**
     * This test tests the shift function with an input of a range of [-4, -1]
     * and a delta of 5
     * Expected outcome: returns a range of [0, 0]
     */
    @Test
    public void positiveRangeShiftBothBoundsNoZeroCrossing() {
        assertEquals("Expected a range of [0, 0]",
                new Range(0, 0), Range.shift(range2, 5));
    }

    /**
     * This test tests the shift function with an input of a range of [1, 4]
     * and a delta of -2
     * Expected outcome: returns a range of [0, 2]
     */
    @Test
    public void negativeRangeShiftLBNoZeroCrossing() {
        assertEquals("Expected a range of [0, 2]",
                new Range(0, 2), Range.shift(range3, -2));
    }

    /**
     * This test tests the shift function with an input of a range of [1, 4]
     * and a delta of -5
     * Expected outcome: returns a range of [0, 0]
     */
    @Test
    public void negativeRangeShiftBothBoundsNoZeroCrossing() {
        assertEquals("Expected a range of [0, 0]",
                new Range(0, 0), Range.shift(range3, -5));
    }

    /**
     * This test tests the shift function with an input of a range of [0, 0]
     * and a delta of 1
     * Expected outcome: returns a range of [1, 1]
     */
    @Test
    public void rangeShiftBothBoundsAreZeroNoZeroCrossing() {
        assertEquals("Expected a range of [1, 1]",
                new Range(1, 1), Range.shift(new Range(0, 0), 1));
    }

}
