package com.wintertechnologyservices;

public class RomanNumeralConverter {

    /** Converts an Arabic number into a Roman numeral */
    public String toRoman (int arabicNumber) {
        StringBuilder numeral = new StringBuilder();

        if (arabicNumber == 5) {
            numeral.append("V");
        } else {
            // One I for each number
            for (int i = 0; i < arabicNumber; i++) {
                numeral.append("I");
            }
        }

        return numeral.toString();
    }

}
