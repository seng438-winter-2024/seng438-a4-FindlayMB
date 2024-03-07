package org.jfree.data.test.range;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.jfree.data.Range;

public class AllGetterTests {
    private Range range1;
    private Range range2;

    private final double delta = 0.000000001d;

    @Before
    public void setUp() throws Exception {
        range1 = new Range(2, 9);
        range2 = new Range(-2, 3.5);

    }

    /**
     * Test getLength for a range of [2,9]
     * Expected outcome: returns a length of 7.
     */
    @Test
    public void getLength_Basic() {
        assertEquals("Expected 7",
                7, range1.getLength(), delta);
    }

    /**
     * Test getLength for a range of [-2, 3.5]
     * Expected outcome: returns a length of 5.5.
     */
    @Test
    public void getLength_NegativeAndPositive() {
        assertEquals("Expected 5.5",
                5.5, range2.getLength(), delta);
    }

    /**
     * This test tests getLength function with inputs of a range
     * from [5.0, 2.0]
     * Expected outcome: throws IllegalArgumentException.
     *
     * This does not cover the illegalException thrown in the getLength function
     * because the object of Range lower > upper will not be created
     */
    @Test(expected = IllegalArgumentException.class)
    public void getLength_ShouldThrowException() {
        Range range = new Range(5.0, 2.0);
        range.getLength();
    }

    /**
     * Test getCentralValue for a range of [2,9]
     * Expected outcome: returns a value of 5.5.
     */
    @Test
    public void getCentral_ValueShouldReturn5_5() {
        assertEquals("Expected 5.5",
                5.5, range1.getCentralValue(), delta);
    }

}
