package org.jfree.data.range;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntersectsTests {
    private Range range1;
    private Range range2;

    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    
    @Before
    public void setUp() throws Exception { 
        // ranges to be used for testing
    	range1 = new Range(-1, 1);
    	range2 = new Range(1, 10);
    }

    // ****** next ten tests cover the intersects() function ****** //

    /**
     * This test tests intersects function
     * with does [-3,-2] intersect with [-1,1]
     * test case: lower < LB and upper < LB
     * Expected outcome: false
     */
    @Test
    public void intersects_FalseLeftTest() {
        assertFalse("Range [-3,-2] does not intersect [-1,1]",
                range1.intersects(-3,-2));
    }

    /**
     * This test tests intersects function
     * with does [-1, 5] intersect with [1, 10]
     * test case: lower < LB and LB < upper < UB
     * Expected outcome: true
     */
    @Test
    public void intersects_Left() {
        assertTrue("Range [-1, 5] does intersect [1, 10]",
                range2.intersects(-1, 5));
    }

    /**
     * This test tests intersects function
     * with does [2, 5] intersect with [1, 10]
     * test case: LB < lower < UB and LB < upper < UB
     * Expected outcome: true
     */
    @Test
    public void intersects_Encapsulation() {
        assertTrue("Range [2, 5] does intersect [1, 10]",
                range2.intersects(2, 5));
    }

    /**
     * This test tests intersects function
     * with does [2, 11] intersect with [1, 10]
     * test case:  lower = LB and LB < upper < UB
     * Expected outcome: true
     */
    @Test
    public void intersects_Right() {
        assertTrue("Range [2, 11] does intersect [1, 10]",
                range2.intersects(2, 11));
    }

    /**
     * This test tests intersects function
     * with does [2,3] intersect with [-1,1]
     * test case: lower > UB and upper > UB
     * Expected outcome: false
     */
    @Test
    public void intersects_FalseRightTest() {
        assertFalse("Range [2,3] does not intersect [-1,1]",
                range1.intersects(2,3));
    }

    /**
     * This test tests intersects function
     * with does [-3,-2] intersect with [-1,1]
     * test case: lower < LB and upper = LB
     * Expected outcome: false
     */
    @Test
    public void intersects_LeftEdgeBackwards() {
        assertFalse("Range [-3,-2] does intersect [-1,1]",
                range1.intersects(-3,-1));
    }

    /**
     * This test tests intersects function
     * with does [1, 5] intersect with [1, 10]
     * test case:  lower = LB and LB < upper < UB
     * Expected outcome: true
     */
    @Test
    public void intersects_LeftEdgeForward() {
        assertTrue("Range [1, 5] does intersect [1, 10]",
                 range2.intersects(1, 5));
    }

    /**
     * This test tests intersects function
     * with does [1, 10] intersect with [1, 10]
     * test case: lower = LB and upper = LB
     * Expected outcome: true
     */
    @Test
    public void intersects_Self() {
        assertTrue("Range [1, 10] does intersect [1, 10]",
                range2.intersects(1, 10));
    }

    /**
     * This test tests intersects function
     * with does [2, 10] intersect with [1, 10]
     * test case: LB < lower < UB and upper = UB
     * Expected outcome: true
     */
//    @Test
//    public void intersects_RightEdgeBackward() {
//        assertTrue("Range [2, 10] does intersect [1, 10]",
//                range2.intersects(2, 10));
//    }    

    /**
     * This test tests intersects function
     * with  does [1,3] intersect with [-1,1]
     * test case: lower = UB and upper > UB
     * Expected outcome: true
     */
    @Test
    public void intersects_RightEdgeForwards() {
        assertTrue("Range [1,3] does intersect [-1,1]",
        		range1.intersects(1,3));
    }

    /**
     * This test tests intersects(Range) function
     * with  does Range[2,3] intersect with [-1,1]
     * test case: lower > UB and upper > UB
     * Expected outcome: false
     */
    @Test
    public void intersectsRange() {
        Range test = new Range(2,3);
        assertFalse("Range [2,3] does not intersect [-1,1]",
                range1.intersects(test));
    }
    
    
    /**
     * This test tests intersects(Range) function
     * Range [0, -1] is an invalid range
     * test case: invalid range
     * Expected outcome: false
     */
    @Test
    public void  intersectsInvalidParameters() {
    	assertFalse("Range [0, -1] is an invalid range",
                range1.intersects(0, -1));
    }
    

}