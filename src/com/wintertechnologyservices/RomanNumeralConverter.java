package com.wintertechnologyservices;

public class RomanNumeralConverter {

    /** Converts an Arabic number into a Roman numeral */
    public String toRoman (int arabicNumber) {
        StringBuilder numeral = new StringBuilder();

        // One I for each number
        for (int i = 0; i < arabicNumber; i++) {
            numeral.append("I");
        }

        return numeral.toString();
    }

}
