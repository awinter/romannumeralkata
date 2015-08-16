package com.wintertechnologyservices;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RomanNumeralConverterTest {

    @Test
    public void convertArabicNumber1 () {
        RomanNumeralConverter converter = new RomanNumeralConverter();
        assertEquals("I", converter.toRoman(1));
    }

    @Test
    public void convertArabicNumber3 () {
        RomanNumeralConverter converter = new RomanNumeralConverter();
        assertEquals("III", converter.toRoman(3));
    }

    @Test
    public void convertArabicNumber5 () {
        RomanNumeralConverter converter = new RomanNumeralConverter();
        assertEquals("V", converter.toRoman(5));
    }
}
