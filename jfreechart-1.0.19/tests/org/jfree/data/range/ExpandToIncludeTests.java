package org.jfree.data.range;

import org.jfree.data.Range;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpandToIncludeTests {

    // ****** next six tests cover the expandToInclude() function ****** //

    /**
     * This test tests expandToInclude function with inputs of a range
     * from [-2, 2] and a value to include of 0
     * Expected outcome: returns a Range object with a range of [-2, 2]
     */
    @Test
    public void expandToInclude_ExpandRangeWithin() {
    	Range range = new Range(-2, 0);
        assertEquals("Range [-2, 0] expanded to a range of [-2, 0]",
        		range, Range.expandToInclude(range, 0));
    }
    
    /**
     * This test tests expandToInclude function with inputs of a range
     * from [-2, 2] and a value to include of -5
     * Expected outcome: returns a Range object with a range of [-5, 2]
     */
    @Test
    public void expandToInclude_ExpandRangeDown() {
    	Range range = new Range(-2, 0);
        assertEquals("Range [-2, 0] expanded to a range of [-5, 0]",
        		new Range(-5, 0), Range.expandToInclude(range, -5));
    }

    /**
     * This test tests expandToInclude function with inputs of a range
     * from [-2, 2] and a value to include of 5
     * Expected outcome: returns a Range object with a range of [-2, 5]
     */
    @Test
    public void expandToInclude_ExpandRangeUp() {
    	Range range = new Range(-2, 0);
        assertEquals("Range [-2, 0] expanded to a range of [-2, 5]",
        		new Range(-2, 5), Range.expandToInclude(range, 5));
    }
    
    /**
     * This test tests expandToInclude function with inputs of a range
     * of Null and a value to include of 2
     * Expected outcome: returns a Range object with a range of [2, 2]
     */
    @Test
    public void expandToInclude_ExpandRangeNull() {
        assertEquals("Range Null expanded to a range of [2, 2]",
        		new Range(2, 2), Range.expandToInclude(null, 2));
    }

    /**
     * This test tests expandToInclude function with inputs of a range
     * from [-2, 2] and a value to include of -2
     * Expected outcome: returns a Range object with a range of [2, 2]
     */
    @Test
    public void expandToInclude_ExpandRangeIsLB() {
        assertEquals("Range [-2, 2] expanded to a range of [-2, 2]",
        		new Range(-2, 2), Range.expandToInclude(new Range(0, 2), -2));
    }
    
    /**
     * This test tests expandToInclude function with inputs of a range
     * from [-2, 2] and a value to include of 2
     * Expected outcome: returns a Range object with a range of [2, 2]
     */
    @Test
    public void expandToInclude_ExpandRangeIsUB() {
    	Range range = new Range(-2, 0);
        assertEquals("Range [-2, 2] expanded to a range of [-2, 2]",
        		new Range(-2, 2), Range.expandToInclude(range, 2));
    }
}
