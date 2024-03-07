package org.jfree.data.test.datautilities;
import org.jfree.data.test.datautilities.calculate.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Run all Calculate column or row total tests
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        CalculateColumnTotalBaseTests.class,
        CalculateColumnTotalOverloadTests.class,
        CalculateRowTotalBaseTests.class,
        CalculateRowTotalOverloadTests.class,
})
public class CalculateTotalTests {
}
