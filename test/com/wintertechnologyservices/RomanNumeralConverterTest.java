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
    public void convertArabicNumber1 () {
        assertEquals("I", converter.toRoman(1));
    }

    @Test
    public void convertArabicNumber3 () {
        assertEquals("III", converter.toRoman(3));
    }

    @Test
    public void convertArabicNumber5 () {
        assertEquals("V", converter.toRoman(5));
    }
}
