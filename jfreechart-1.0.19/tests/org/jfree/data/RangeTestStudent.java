package org.jfree.data;

import org.jfree.data.range.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.security.InvalidParameterException;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        IntersectsTests.class,
        CombineTests.class,
        ContainsTests.class,
        ConstrainTests.class,
        ExpandTests.class,
        ExpandToIncludeTests.class,
        AllGetterTests.class,
        HashCodeTests.class,
        ScaleTests.class,
        ShiftTests.class,
        EqualsTests.class,
        IsNaNRangeTests.class})
public class RangeTestStudent {
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void rangeConstructorInvalidParameters() {
        exceptionRule.expect(IllegalArgumentException.class);
    }

}
