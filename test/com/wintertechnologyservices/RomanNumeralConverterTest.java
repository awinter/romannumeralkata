package com.wintertechnologyservices;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class RomanNumeralConverterTest {

    private RomanNumeralConverter converter;

    @Before
    public void setUp() {
        converter = new RomanNumeralConverter();
    }

    @Test
    public void convertArabicNumbersDefinedTestCases () {
        assertEquals("I",           converter.toRoman(1));
        assertEquals("III",         converter.toRoman(3));
        assertEquals("IX",          converter.toRoman(9));
        assertEquals("MLXVI",       converter.toRoman(1066));
        assertEquals("MCMLXXXIX",   converter.toRoman(1989));
    }

    @Test
    public void convertRomanNumeralsDefinedTestCases () {
        assertEquals(1,    converter.toArabic("I"));
        assertEquals(3,    converter.toArabic("III"));
        assertEquals(9,    converter.toArabic("IX"));
        assertEquals(1066, converter.toArabic("MLXVI"));
        assertEquals(1989, converter.toArabic("MCMLXXXIX"));
    }

    @Test
    public void invalidNegativeNumber () {
        boolean thrown = false;
        try {
            converter.toRoman(-5);
        } catch (IllegalArgumentException iae) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void invalidBlankString () {
        boolean thrown = false;
        try {
            converter.toArabic("");
        } catch (IllegalArgumentException iae) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void invalidUnknownRomanDigit () {
        boolean thrown = false;
        try {
            converter.toArabic("Z");
        } catch (IllegalArgumentException iae) {
            thrown = true;
        }
        assertTrue(thrown);
    }
}
