package com.wintertechnologyservices;

public class RomanNumeralConverter {

    /** Converts an Arabic number into a Roman numeral */
    public String toRoman (int arabicNumber) {
        StringBuilder numeral = new StringBuilder();

        // Reduce the input number as the output is being constructed
        while (arabicNumber > 0) {

            if (arabicNumber >= 50) {
                numeral.append("L");
                arabicNumber -= 50;
            } else if (arabicNumber >= 40 ) {
                numeral.append("XL");
                arabicNumber -= 40;
            } else if (arabicNumber >= 10) {
                numeral.append("X");
                arabicNumber -= 10;
            } else if (arabicNumber >= 9 ) {
                numeral.append("IX");
                arabicNumber -= 9;
            } else if (arabicNumber >= 5) {
                numeral.append("V");
                arabicNumber -= 5;
            } else if (arabicNumber >= 4 ) {
                numeral.append("IV");
                arabicNumber -= 4;
            } else if (arabicNumber > 0 ) {
                numeral.append("I");
                arabicNumber -= 1;
            }

        }

        return numeral.toString();
    }
}
