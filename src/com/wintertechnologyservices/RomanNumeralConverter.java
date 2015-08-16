package com.wintertechnologyservices;

public class RomanNumeralConverter {

    /** Converts an Arabic number into a Roman numeral */
    public String toRoman (int arabicNumber) {
        StringBuilder numeral = new StringBuilder();

        // Reduce the input number as the output is being constructed
        while (arabicNumber > 0) {

            if (arabicNumber == 5) {
                numeral.append("V");
                arabicNumber -= 5;
            } else if (arabicNumber == 4 ) {
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
