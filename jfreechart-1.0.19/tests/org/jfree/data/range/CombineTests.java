package org.jfree.data.range;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CombineTests {
    private Range range1;
    private Range range2;
    private Range range3;
    private Range range4;
    private Range range5;
    private Range rangeNaN;

    
    @Before
    public void setUp() throws Exception { 
        // ranges to be used for testing
    	range1 = new Range(-1, 1);
    	range2 = new Range(-2, 2);
    	range3 = new Range(-2, 0);
    	range4 = new Range(0, 2);
    	range5 = new Range(1, 2);
        rangeNaN = new Range(Double.NaN, Double.NaN);
    }

    // ****** next nine tests cover the combine() function ****** //

    /**
     * This test tests the combine function with a range of null
     * and another range of null
     * Expected outcome: returns a Range object with a range of null
     */
    @Test
    public void combine_BothRangesAreNull() {
        assertEquals("The range null is combined with null to make a range of null",
        		null, Range.combine(null, null));
    }

    /**
     * This test tests the combine function with a range of null
     * and another range of [-2 , 2]
     * Expected outcome: returns a Range object with a range of [-2, 2]
     */
    @Test
    public void combine_Range1IsNull() {
        assertEquals("The range null is combined with [-2, 2] to make a range of [-2, 2]", 
        		range2, Range.combine(null, range2));
    }

    /**
     * This test tests the combine function with a range of [-2 , 2]
     * and another range of null
     * Expected outcome: returns a Range object with a range of [-2, 2]
     */
    @Test
    public void combine_Range2IsNull() {
        assertEquals("The range [-2 , 2] is combined with null to make a range of [-2, 2]",
                range2, Range.combine(range2, null));
    }

    /**
     * This test tests the combine function with a range of [-2, 0]
     * and another range of [-1, 1]
     * Expected outcome: returns a Range object with a range of [-2, 1]
     */
    @Test
    public void combine_Range1PartiallyInRange2() {
        assertEquals("The range [-2, 0] is combined with [-1, 1] to make a range of [-2, 1]", 
        		new Range(-2, 1), Range.combine(range3, range1));
    }

    /**
     * This test tests the combine function with a range of [-1, 1]
     * and another range of [0, 2]
     * Expected outcome: returns a Range object with a range of [-1, 2]
     */
    @Test
    public void combine_Range2PartiallyInRange1() {
        assertEquals("The range [-1, 1] is combined with [0, 2] to make a range of [-1, 2]", 
        		new Range(-1, 2), Range.combine(range1, range4));
    }

    /**
     * This test tests the combine function with a range of [-1, 1]
     * and another range of [-2 , 2]
     * Expected outcome: returns a Range object with a range of [-2, 2]
     */
    @Test
    public void combine_Range2EncapsulatesRange1() {
        assertEquals("The range [-1, 1] is combined with [-2, 2] to make a range of [-2, 2]", 
        		range2, Range.combine(range1, range2));
    }

    /**
     * This test tests the combine function with a range of [-2, 2]
     * and another range of [-1 , 1]
     * Expected outcome: returns a Range object with a range of [-2, 2]
     */
    @Test
    public void combine_Range1EncapsulatesRange2() {
        assertEquals("The range [-2, 2] is combined with [-1, 1] to make a range of [-2, 2]", 
        		range2, Range.combine(range2, range1));
    }

    /**
     * This test tests the combine function with a range of [-2, 0]
     * and another range of [1, 2]
     * Expected outcome: returns a Range object with a range of [-2, 2]
     */
    @Test
    public void combine_NoIntersection() {
        assertEquals("The range [-2, 0] is combined with [1, 2] to make a range of [-2, 2]", 
        		range2, Range.combine(range3, range5));
    }

    /**
     * This test tests the combine function with a range of [-2, 0]
     * and another range of [0, 2]
     * Expected outcome: returns a Range object with a range of [-2, 2]
     */
    @Test
    public void combine_IntersectsOnRange1UBandRange2LB() {
        assertEquals("The range [-2, 0] is combined with [0, 2] to make a range of [-2, 2]", 
        		range2, Range.combine(range3, range4));
    }
    
    /**
     * This test tests the combine function with a range of [0, 2]
     * and another range of [-2, 0]
     * Expected outcome: returns a Range object with a range of [-2, 2]
     */
    @Test
    public void combine_IntersectsOnRange2UBandRange1LB() {
        assertEquals("The range [0, 2] is combined with [-2, 0] to make a range of [-2, 2]", 
        		range2, Range.combine(range4, range3));
    }

    // the next 9 tests cover the combineIgnoringNan function

    /**
     * This test tests the combineIgnoringNaN function with ranges of Null
     * Expected outcome: returns a null Range
     */
    @Test
    public void ignoringNaNTwoNullRangesReturnsNull() {
        assertEquals("Combining 2 Null ranges should return a Null range",
                null, Range.combineIgnoringNaN(null, null));
    }

    /**
     * This test tests the combineIgnoringNaN function with a range of null
     * and another range of [-1, 1]
     * Expected outcome: returns the range [-1, 1]
     */
    @Test
    public void ignoringNaNRange1NullReturnsRange2() {
        assertEquals("Combining a null range with a range of [-1, 1] should return a range of [-1, 1]",
                range1, Range.combineIgnoringNaN(null, range1));
    }

    /**
     * This test tests the combineIgnoringNaN function with a range of [-1, 1]]
     * and another range of null
     * Expected outcome: returns the range [-1, 1]
     */
    @Test
    public void ignoringNaNRange2NullReturnsRange1() {
        assertEquals("Combining a range of [-1, 1] with null range should return a range of [-1, 1]",
                range1, Range.combineIgnoringNaN(range1, null));
    }

    /**
     * This test tests the combineIgnoringNaN function with ranges of NaN
     * Expected outcome: returns a null Range
     */
    @Test
    public void ignoringNaNTwoNaNRangesReturnsNull() {
        assertEquals("Combining 2 NaN ranges should return a Null range",
                null, Range.combineIgnoringNaN(rangeNaN, rangeNaN));
    }

    /**
     * This test tests the combineIgnoringNaN function with a range of NaN
     * and another range of [-1, 1]
     * Expected outcome: returns the range [-1, 1]
     */
    @Test
    public void ignoringNaNRange1NaNReturnsRange2() {
        assertEquals("Combining a NaN range with a range of [-1, 1] should return a range of [-1, 1]",
                range1, Range.combineIgnoringNaN(rangeNaN, range1));
    }

    /**
     * This test tests the combineIgnoringNaN function with a range of [-1, 1]
     * and another range of NaN
     * Expected outcome: returns the range [-1, 1]
     */
    @Test
    public void ignoringNaNRange2NaNReturnsRange1() {
        assertEquals("Combining a range of [-1, 1] with NaN range should return a range of [-1, 1]",
                range1, Range.combineIgnoringNaN(range1, rangeNaN));
    }

    /**
     * This test tests the combineIgnoringNaN function with a range of NaN
     * and another range Null
     * Expected outcome: returns the range Null
     */
    @Test
    public void ignoringNaNRange1NaNRange2NullReturnsNull() {
        assertEquals("Combining a NaN range with null range should return a range of null",
                null, Range.combineIgnoringNaN(rangeNaN, null));
    }

    /**
     * This test tests the combineIgnoringNaN function with a range of null
     * and another range of NaN
     * Expected outcome: returns the range null
     */
    @Test
    public void ignoringNaNRange2NaNRange1NullReturnsNull() {
        assertEquals("Combining a null range with NaN range should return a range of null",
                null, Range.combineIgnoringNaN(null, rangeNaN));
    }

    /**
     * This test tests the combineIgnoringNaN function with a range [-2, 0]
     * and another range of [0, 2]
     * Expected outcome: returns the range [-2, 2]
     */
    @Test
    public void ignoringNaNBothRangesAreValidReturnsCombinedRange() {
        assertEquals("Combining a range of [-2, 0] and a range of [0, 2] should return a range of [-2, 2]",
                new Range(-2, 2), Range.combineIgnoringNaN(range3, range4));
    }
}
