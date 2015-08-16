package com.wintertechnologyservices;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RomanNumeralConverterTest {

    private RomanNumeralConverter converter;

    @Before
    public void setUp() {
        converter = new RomanNumeralConverter();
    }

    @Test
    public void convertArabicNumbers1to5 () {
        assertEquals("I", converter.toRoman(1));
        assertEquals("III", converter.toRoman(3));
        assertEquals("IV", converter.toRoman(4));
        assertEquals("V", converter.toRoman(5));
    }

}
