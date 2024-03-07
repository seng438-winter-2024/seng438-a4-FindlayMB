package org.jfree.data.test;

import org.jfree.data.test.datautilities.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Run all tests that are related to DataUtilities
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        CalculateTotalTests.class,
        CreateNumberArrayTests.class,
        CreateNumberArray2DTests.class,
        GetCumulativePercentagesTests.class,
        EqualTests.class,
        CloneTests.class})
public class DataUtilitiesTest {

}
