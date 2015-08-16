package com.wintertechnologyservices;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RomanNumeralConverterTest {

    @Test
    public void convertArabicNumber1 () {
        RomanNumeralConverter converter = new RomanNumeralConverter();
        assertEquals("I", converter.toRoman(1));
    }

}
