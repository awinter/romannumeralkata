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
        assertEquals("I",    converter.toRoman(1));
        assertEquals("III",  converter.toRoman(3));
        assertEquals("IV",   converter.toRoman(4));
        assertEquals("V",    converter.toRoman(5));
    }

    @Test
    public void convertArabicNumbers6to11 () {
        assertEquals("VI",   converter.toRoman(6));
        assertEquals("VIII", converter.toRoman(8));
        assertEquals("IX",   converter.toRoman(9));
        assertEquals("X",    converter.toRoman(10));
        assertEquals("XI",   converter.toRoman(11));
    }

    @Test
    public void convertArabicNumbers12to60 () {
        assertEquals("XII",    converter.toRoman(12));
        assertEquals("XIV",    converter.toRoman(14));
        assertEquals("XVI",    converter.toRoman(16));
        assertEquals("XX",     converter.toRoman(20));
        assertEquals("XXX",    converter.toRoman(30));
        assertEquals("XXXIX",  converter.toRoman(39));
        assertEquals("XL",     converter.toRoman(40));
        assertEquals("XLI",    converter.toRoman(41));
        assertEquals("L",      converter.toRoman(50));
        assertEquals("LX",     converter.toRoman(60));
    }

    @Test
    public void convertArabicNumbers99to600 () {
        assertEquals("XCIX",   converter.toRoman(99));
        assertEquals("C",      converter.toRoman(100));
        assertEquals("CD",     converter.toRoman(400));
        assertEquals("D",      converter.toRoman(500));
        assertEquals("DC",     converter.toRoman(600));
    }

    @Test
    public void convertArabicNumbersLargeMisc () {
        assertEquals("MLXVI",       converter.toRoman(1066));
        assertEquals("MCMLXXXIX",   converter.toRoman(1989));
    }

    @Test
    public void convertRomanNumeralsItoVI () {
        assertEquals(1,    converter.toArabic("I"));
        assertEquals(3,    converter.toArabic("III"));
        assertEquals(4,    converter.toArabic("IV"));
        assertEquals(5,    converter.toArabic("V"));
        assertEquals(6,    converter.toArabic("VI"));
    }

}
