package org.jfree.data.test.range;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.jfree.data.Range;

public class EqualsTests {
    private Range range1;

    @Before
    public void setUp() throws Exception {
        range1 = new Range(-1, 1);
    }

    /**
     * Test equals with a null object
     * Expected outcome: false.
     */
    @Test
    public void equalsNull() {
        assertEquals("False",
                false, range1.equals(null));
    }

    /**
     * Test equals with a non range object
     * Expected outcome: false.
     */
    @Test
    public void equalsNonRangeObject() {
        assertEquals("False",
                false, range1.equals(new Object()));
    }

    /**
     * Test equals with an equal range object
     * Expected outcome: true.
     */
    @Test
    public void equalsRangeObject() {
        assertEquals("True",
                true, range1.equals(new Range(-1, 1)));
    }

    /**
     * Test equals with an unequal LB range object
     * Expected outcome: false.
     */
    @Test
    public void notEqualsLBRangeObject() {
        assertEquals("False",
                false, range1.equals(new Range(-2, 1)));
    }

    /**
     * Test equals with an unequal UB range object
     * Expected outcome: false.
     */
    @Test
    public void notEqualsUBRangeObject() {
        assertEquals("False",
                false, range1.equals(new Range(-1, 4)));
    }

    /**
     * Test equals with both bounds unequal range object
     * Expected outcome: false.
     */
    @Test
    public void notEqualsBothBoundsRangeObject() {
        assertEquals("False",
                false, range1.equals(new Range(-3, 4)));
    }
}
