package org.jfree.data.range;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class ToStringTests {
	
	private Range range1;

	@Before
    public void setUp() throws Exception {
        range1 = new Range(-1, 1);
    }

	@Test
	public void test() {
		assertEquals("Returns Range[-1,1]", "Range[-1.0,1.0]", range1.toString());
	}

}
