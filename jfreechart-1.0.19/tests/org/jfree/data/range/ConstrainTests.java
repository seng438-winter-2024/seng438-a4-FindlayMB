package org.jfree.data.range;

import org.jfree.data.Range;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstrainTests {


    // ****** next five tests cover the constrain() function ****** //

    /**
     * This test tests constrain function
     * with constraining 0 into [-1,1]
     * Expected outcome: 0
     */
    @Test
    public void constrain_InRange() {
    	Range range = new Range(-1, 1);
        assertEquals("Expected 0",
                0, range.constrain(0),.000000001d);
    }

    /**
     * This test tests constrain function
     * with constraining -5 into [-1,1]
     * Expected outcome: -1
     */
    @Test
    public void constrain_UnderRange() {
    	Range range = new Range(-1, 1);
        assertEquals("Expected -1",
                -1, range.constrain(-5),.000000001d);
    }
    
    /**
     * This test tests constrain function
     * with constraining 5 into [-1,1]
     * Expected outcome: 1
     */
    @Test
    public void constrain_OverRange() {
    	Range range = new Range(-1, 1);
        assertEquals("Expected 1",
                1, range.constrain(5),.000000001d);
    }
    
    /**
     * This test tests constrain function
     * with constraining -1 into [-1,1]
     * Expected outcome: -1
     */
    @Test
    public void constrain_IsLowerBound() {
    	Range range = new Range(-1, 1);
        assertEquals("Expected -1",
                -1, range.constrain(-1),.000000001d);
    }
    
    /**
     * This test tests constrain function
     * with constraining 1 into [-1,1]
     * Expected outcome: 1
     */
    @Test
    public void constrain_IsUpperBound() {
    	Range range = new Range(-1, 1);
        assertEquals("Expected 1",
                1, range.constrain(1),.000000001d);
    }
}
