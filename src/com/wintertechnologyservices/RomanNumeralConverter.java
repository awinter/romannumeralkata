package com.wintertechnologyservices;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This converter handles the conversion of Arabic Numbers to Roman Numerals.
 * @author Adam Winter <adam.e.winter@gmail.com></adam.e.winter@gmail.com>
 */
public class RomanNumeralConverter {

    // Arabic to Roman Conversion Dictionary
    private static final Map<Integer, String> CONVERSIONS_TO_ROMAN;

    static {

        // Populate the Arabic to Roman Conversion Dictionary
        Map<Integer, String> conversionsMap = new LinkedHashMap<Integer, String>();
        conversionsMap = new LinkedHashMap<Integer, String>();
        conversionsMap.put(1000,"M");
        conversionsMap.put(900,"CM");
        conversionsMap.put(500,"D");
        conversionsMap.put(400,"CD");
        conversionsMap.put(100,"C");
        conversionsMap.put(90,"XC");
        conversionsMap.put(50,"L");
        conversionsMap.put(40,"XL");
        conversionsMap.put(10,"X");
        conversionsMap.put(9,"IX");
        conversionsMap.put(5,"V");
        conversionsMap.put(4,"IV");
        conversionsMap.put(1,"I");
        CONVERSIONS_TO_ROMAN = Collections.unmodifiableMap(conversionsMap);
    }

    /** Converts an Arabic number into a Roman numeral
     * @param arabicNumber Any positive Arabic number
     * @throws IllegalArgumentException if the number to be converted is not greater than zero
     * @return the corresponding Roman numeral
     */
    public String toRoman (int arabicNumber) {

        if (arabicNumber <= 0) throw new IllegalArgumentException("Supplied Arabic number must be postive.");

        StringBuilder outputNumeral = new StringBuilder();

        // Reduce the input number as the output is being constructed
        while (arabicNumber > 0) {

            // Iterate through the conversion map, key = arabic number, value = roman numeral character(s)
            for (Map.Entry<Integer, String> entry : CONVERSIONS_TO_ROMAN.entrySet()) {
                if (arabicNumber >= entry.getKey()) {
                    outputNumeral.append(entry.getValue());
                    arabicNumber -= entry.getKey();

                    // found a matching character conversion, break out of for loop
                    break;
                };
            }
        }

        return outputNumeral.toString();
    }

    public int toArabic(String romanNumeral) {
        int outputNumber = 0;

        char[] charArray = romanNumeral.toCharArray();

        for (int i=0; i < charArray.length; i++) {

            if (i+2 <= romanNumeral.length()) {
                if (romanNumeral.substring(i,i+2) == "IV") {
                    outputNumber += 4;
                    i++;
                    continue;
                }
            }
            if (charArray[i] == 'I') {
                outputNumber += 1;
            } else if (charArray[i] == 'V') {
                outputNumber += 5;
            }
        }

        return outputNumber;
    }
}
