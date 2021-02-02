package com.firstfewlines;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestStringBuilder {

    @Test
    public void stringBuilderAppendShouldConcatinate()  {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        stringBuilder.append("String");
        stringBuilder.append("Builder");
        stringBuilder.append("Test");

        assertEquals("StringBuilderTest", stringBuilder.toString());
    }
}
