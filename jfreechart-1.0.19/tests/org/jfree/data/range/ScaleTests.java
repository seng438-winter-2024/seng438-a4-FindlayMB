package org.jfree.data.range;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ScaleTests {
    private Range range1;

    @Before
    public void setUp() throws Exception {
        // range for tests
        range1 = new Range(-2, 2);
    }


    /**
     * This test tests the scale function with an input of a null range
     * Expected outcome: illegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void nullRange() {
        Range.scale(null, 0);
    }

    /**
     * This test tests the scale function with an input of a valid range of [-2, 2]
     * and an invalid input (negative number) -2
     * Expected outcome: illegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void validRangeNegativeFactor() {
        Range.scale(range1, -2);
    }

    /**
     * This test tests the scale function with an input of a valid range of [-2, 2]
     * and a valid input 0
     * Expected outcome: returns a range of [0, 0]
     */
    @Test
    public void validRangeZeroFactor() {
        assertEquals("Expected a range of [0, 0]",
                new Range(0,0), Range.scale(range1, 0));
    }

    /**
     * This test tests the scale function with an input of a valid range of [-2, 2]
     * and a valid input 2
     * Expected outcome: returns a range of [-4, 4]
     */
    @Test
    public void validRangePositiveFactor() {
        assertEquals("Expected a range of [-4, 4]",
                new Range(-4,4), Range.scale(range1, 2));
    }


    /**
     * This test tests the scale function with an input of a valid range of [-2, 2]
     * and a valid input max double value
     * Expected outcome: a range of [-inf, inf]
     */
    @Test
    public void validRangePositiveFactorMAX() {
        assertEquals("Expected a range of [Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY]",
                new Range(Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY),
                Range.scale(range1, Double.MAX_VALUE));
    }

}
