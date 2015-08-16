package com.wintertechnologyservices;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeralConverter {

    private static final Map<Integer, String> CONVERSIONS_TO_ROMAN;

    static {
        CONVERSIONS_TO_ROMAN = new LinkedHashMap<Integer, String>();
        CONVERSIONS_TO_ROMAN.put(500,"D");
        CONVERSIONS_TO_ROMAN.put(400,"CD");
        CONVERSIONS_TO_ROMAN.put(100,"C");
        CONVERSIONS_TO_ROMAN.put(90,"XC");
        CONVERSIONS_TO_ROMAN.put(50,"L");
        CONVERSIONS_TO_ROMAN.put(40,"XL");
        CONVERSIONS_TO_ROMAN.put(10,"X");
        CONVERSIONS_TO_ROMAN.put(9,"IX");
        CONVERSIONS_TO_ROMAN.put(5,"V");
        CONVERSIONS_TO_ROMAN.put(4,"IV");
        CONVERSIONS_TO_ROMAN.put(1,"I");
    }

    /** Converts an Arabic number into a Roman numeral */
    public String toRoman (int arabicNumber) {

        StringBuilder numeral = new StringBuilder();

        // Reduce the input number as the output is being constructed
        while (arabicNumber > 0) {

            // Iterate through the conversion map
            for (Map.Entry<Integer, String> entry : CONVERSIONS_TO_ROMAN.entrySet()) {
                if (arabicNumber >= entry.getKey()) {
                    numeral.append(entry.getValue());
                    arabicNumber -= entry.getKey();

                    // found a matching character conversion, break out of for loop
                    break;
                };
            }
        }

        return numeral.toString();
    }
}
