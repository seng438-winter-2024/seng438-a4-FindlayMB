package org.jfree.data.test.range;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.jfree.data.Range;

public class HashCodeTests {
    private Range range1;

    private final double delta = 0.000000001d;

    @Before
    public void setUp() throws Exception {
        range1 = new Range(-1, 1);
    }

    /**
     * This test tests the hashcode function
     * Expected outcome: returns the hashcode for a range of [-1, 1], which is -31457280
     */
    @Test
    public void calculatesAndReturnsHashcodeForRange() {
        assertEquals("Should return a hashcode of -31457280",
                -31457280, range1.hashCode(), delta);
    }
}
