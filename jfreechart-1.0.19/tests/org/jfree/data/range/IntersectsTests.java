package org.jfree.data.range;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class IntersectsTests {

    // ****** next ten tests cover the intersects() function ****** //

    /**
     * This test tests intersects function
     * with does [-3,-2] intersect with [-1,1]
     * test case: lower < LB and upper < LB
     * Expected outcome: false
     */
    @Test
    public void intersects_FalseLeftTest() {
    	Range range = new Range(-1,1);
        assertFalse("Range [-3,-2] does not intersect [-1,1]",
               range.intersects(-3,-2));
    }

    /**
     * This test tests intersects function
     * with does [-1, 5] intersect with [1, 10]
     * test case: lower < LB and LB < upper < UB
     * Expected outcome: true
     */
    @Test
    public void intersects_Left() {
    	Range range = new Range(1, 10);
        assertTrue("Range [-1, 5] does intersect [1, 10]",
                range.intersects(-1, 5));
    }

    /**
     * This test tests intersects function
     * with does [2, 5] intersect with [1, 10]
     * test case: LB < lower < UB and LB < upper < UB
     * Expected outcome: true
     */
    @Test
    public void intersects_Encapsulation() {
    	Range range = new Range(1, 10);
        assertTrue("Range [2, 5] does intersect [1, 10]",
                range.intersects(2, 5));
    }

    /**
     * This test tests intersects function
     * with does [2, 11] intersect with [1, 10]
     * test case:  lower = LB and LB < upper < UB
     * Expected outcome: true
     */
    @Test
    public void intersects_Right() {
    	Range range = new Range(1, 10);
        assertTrue("Range [2, 11] does intersect [1, 10]",
                range.intersects(2, 11));
    }

    /**
     * This test tests intersects function
     * with does [2,3] intersect with [-1,1]
     * test case: lower > UB and upper > UB
     * Expected outcome: false
     */
    @Test
    public void intersects_FalseRightTest() {
    	Range range = new Range(-1, 1);
        assertFalse("Range [2,3] does not intersect [-1,1]",
                range.intersects(2,3));
    }

    /**
     * This test tests intersects function
     * with does [-3,-2] intersect with [-1,1]
     * test case: lower < LB and upper = LB
     * Expected outcome: false
     */
    @Test
    public void intersects_LeftEdgeBackwards() {
    	Range range = new Range(-1, 1);
        assertTrue("Range [-3,-1] does intersect [-1,1]",
                range.intersects(-3,-1));
    }

    /**
     * This test tests intersects function
     * with does [1, 5] intersect with [1, 10]
     * test case:  lower = LB and LB < upper < UB
     * Expected outcome: true
     */
    @Test
    public void intersects_LeftEdgeForward() {
    	Range range = new Range(1, 10);
        assertTrue("Range [1, 5] does intersect [1, 10]",
               range.intersects(1, 5));
    }

    /**
     * This test tests intersects function
     * with does [1, 10] intersect with [1, 10]
     * test case: lower = LB and upper = LB
     * Expected outcome: true
     */
    @Test
    public void intersects_Self() {
    	Range range = new Range(1, 10);
        assertTrue("Range [1, 10] does intersect [1, 10]",
                range.intersects(1, 10));
    }

    /**
     * This test tests intersects function
     * with does [2, 10] intersect with [1, 10]
     * test case: LB < lower < UB and upper = UB
     * Expected outcome: true
     */
    @Test
    public void intersects_RightEdgeBackward() {
    	Range range = new Range(1, 10);
        assertTrue("Range [2, 10] does intersect [1, 10]",
                range.intersects(2, 10));
    }    

    /**
     * This test tests intersects function
     * with  does [1,3] intersect with [-1,1]
     * test case: lower = UB and upper > UB
     * Expected outcome: true
     */
    @Test
    public void intersects_RightEdgeForwards() {
    	Range range = new Range(-1, 1);
        assertTrue("Range [1,3] does intersect [-1,1]",
        		range.intersects(1, 3));
    }

    /**
     * This test tests intersects(Range) function
     * with does Range[2,3] intersect with [-1,1]
     * Expected outcome: false
     */
    @Test
    public void intersectsRange() {
        Range test = new Range(2,3);
        Range range = new Range(-1, 1);
        assertFalse("Range [2,3] does not intersect [-1,1]",
                range.intersects(test));
    }
    
    /**
     * This test tests intersects(Range) function
     * with  does Range[1,3] intersect with [-1,1]
     * Expected outcome: true
     */
    @Test
    public void doesNotIntersectsRange() {
        Range test = new Range(1,3);
        Range range = new Range(-1, 1);
        assertTrue("Range [1,3] does intersect [-1,1]",
                range.intersects(test));
    }
    
    
    /**
     * This test tests intersects function
     * Range [0, -1] is an invalid range
     * test case: invalid range
     * Expected outcome: false
     */
    @Test
    public void  intersectsInvalidParameters() {
    	Range range = new Range(-1, 1);
    	assertFalse("Range [0, -1] is an invalid range",
                range.intersects(0, -1));
    }
    
    /**
     * This test tests intersects function
     * Range [1, 1] is a range with the same parameters
     * test case: range parameters are the same
     * Expected outcome: true
     */
    @Test
    public void  intersectsParametersAreTheSame() {
    	Range range = new Range(-1, 1);
    	assertTrue("Range [1, 1] is a range where upper and lower are the same",
                range.intersects(1, 1));
    }
}