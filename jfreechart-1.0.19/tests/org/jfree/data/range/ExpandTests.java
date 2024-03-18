package org.jfree.data.range;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.jfree.data.Range;
public class ExpandTests {

    /**
     * This test tests expand function with null range
     * Expected outcome: throws IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void noRangeShouldThrowIllegalException() {
        Range.expand(null, 0.5, 0.5);
    }

    /**
     * This test tests expand function with inputs of a range
     * from [2, 6], lowerMargin of 0.25, and upperMargin of 0.5
     * Expected outcome: returns a Range object with a range of [1, 8]
     */
    @Test
    public void basicCase() {
    	Range range = new Range(2, 6);
        Range result = Range.expand(range, 0.25, 0.5);
        assertEquals("New Range should be [1, 8]", new Range(1, 8), result);
    }

    /**
     * This test tests expand function with inputs of a range
     * from [2, 6], lowerMargin of 1, and upperMargin of 1
     * Expected outcome: returns a Range object with a range of [-2, 10]
     */
    @Test
    public void maxPercentage() {
    	Range range = new Range(2, 6);
        Range result = Range.expand(range, 1, 1);
        assertEquals("New Range should be [-2, 10]", new Range(-2, 10), result);
    }

    /**
     * This test tests expand function with inputs of a range
     * from [2, 6], lowerMargin of 2, and upperMargin of 2
     * Expected outcome: returns a Range object with a range of [-6, 14]
     */
    @Test
    public void overMaxPercentage() {
    	Range range = new Range(2, 6);
        Range result = Range.expand(range, 2, 2);
        assertEquals("New Range should be [-6, 14]", new Range(-6, 14), result);
    }

    /**
     * This test tests expand function with inputs of a range
     * from [2, 6], lowerMargin of 0, and upperMargin of 0
     * Expected outcome: returns a Range object with a range of [2, 6]
     */
    @Test
    public void zeroPercentageCase() {
    	Range range = new Range(2, 6);
        Range result = Range.expand(range, 0, 0);
        assertEquals("New Range should be [2, 6]", new Range(2, 6), result);
    }

    /**
     * This test tests expand function with inputs of a range
     * from [2, 6], lowerMargin of -0.5, and upperMargin of -0.5
     * Expected outcome: throws IllegalArgumentException? Not specified in documents
     * but since it accepts a percentage, it shouldn't except negative values
     */
//    @Test(expected = IllegalArgumentException.class)
//    public void negativeMargins() {
//        Range result = Range.expand(range2, -1, -0.5);
//    }


}
