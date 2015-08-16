package com.wintertechnologyservices;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This converter handles the conversion of Arabic Numbers to Roman Numerals, as well as the reverse.
 * @author Adam Winter <adam.e.winter@gmail.com>
 */
public class RomanNumeralConverter {

    // Arabic to Roman Conversion Dictionary
    private static final Map<Integer, String> CONVERSIONS_TO_ROMAN;

    // Roman to Arabic Converstion Dictionaries
    private static final Map<String, Integer> CONVERSIONS_TO_ARABIC_SUBTRACTIVE; // eg IV, IX, XL, LC
    private static final Map<Character, Integer> CONVERSIONS_TO_ARABIC_ADDITIVE; // eg I, V, X, C, L

    static {

        // Populate the Arabic to Roman Conversion Dictionary
        Map<Integer, String> romanConversionsMap = new LinkedHashMap<Integer, String>();
        romanConversionsMap = new LinkedHashMap<Integer, String>();
        romanConversionsMap.put(1000, "M");
        romanConversionsMap.put(900, "CM");
        romanConversionsMap.put(500, "D");
        romanConversionsMap.put(400, "CD");
        romanConversionsMap.put(100, "C");
        romanConversionsMap.put(90, "XC");
        romanConversionsMap.put(50, "L");
        romanConversionsMap.put(40, "XL");
        romanConversionsMap.put(10, "X");
        romanConversionsMap.put(9, "IX");
        romanConversionsMap.put(5, "V");
        romanConversionsMap.put(4, "IV");
        romanConversionsMap.put(1, "I");
        CONVERSIONS_TO_ROMAN = Collections.unmodifiableMap(romanConversionsMap);

        // Construct the Roman to Arabic conversion dictionaries from the Arabic to Roman one (just reversing it)
        Map<Character, Integer> arabicConversionsMapAdditive = new LinkedHashMap<Character, Integer>();
        Map<String, Integer> arabicConversionsMapSubtractive = new LinkedHashMap<String, Integer>();
        for (Map.Entry<Integer, String> entry : CONVERSIONS_TO_ROMAN.entrySet()) {
            // Intentionally swapping key/value since this a reverse conversion
            if (entry.getValue().length() == 2) {
                arabicConversionsMapSubtractive.put(entry.getValue(), entry.getKey());
            } else if (entry.getValue().length() == 1) {
                arabicConversionsMapAdditive.put(entry.getValue().charAt(0), entry.getKey());
            }
        }
        CONVERSIONS_TO_ARABIC_SUBTRACTIVE = Collections.unmodifiableMap(arabicConversionsMapSubtractive);
        CONVERSIONS_TO_ARABIC_ADDITIVE = Collections.unmodifiableMap(arabicConversionsMapAdditive);
    }

    /** Converts an Arabic number into a Roman numeral
     * @param arabicNumber Any positive Arabic number
     * @throws IllegalArgumentException if the number to be converted is not greater than zero
     * @return the corresponding Roman numeral
     */
    public String toRoman (int arabicNumber) {

        // Verify the input before processing
        if (arabicNumber <= 0) throw new IllegalArgumentException("Supplied Arabic number must be positive.");

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

    /**
     * Converts a roman numeral into an arabic number
     * @param romanNumeral A valid roman numeral. Characters supported are I, V, X, L, C, D, M
     * @throws IllegalArgumentException if the romanNumeral doesn't appear valid
     * @return the arabic number equivalent
     */
    public int toArabic(String romanNumeral) {

        // Verify the input before processing
        if (!validRomanNumeral(romanNumeral)) throw new IllegalArgumentException("This is not a valid roman numeral");

        int outputNumber = 0;

        char[] charArray = romanNumeral.toCharArray();

        for (int i=0; i < charArray.length; i++) {

            // Handle 2 character subtraction cases
            // Are there two characters left in the string? (NOTE: using the length test to short circuit the substring call)
            if (i+2 <= romanNumeral.length() && CONVERSIONS_TO_ARABIC_SUBTRACTIVE.containsKey(romanNumeral.substring(i,i+2))) {
                for (Map.Entry<String, Integer> entry : CONVERSIONS_TO_ARABIC_SUBTRACTIVE.entrySet()) {
                    if (entry.getKey().equals(romanNumeral.substring(i,i+2))) {
                        outputNumber += entry.getValue(); // process the match
                        i++; // advance the counter an extra spot for the extra character since we peeked forward
                        break; // two character numeral was found no need to process more
                    }
                }
            } else {
                // Handle the single character cases
                for (Map.Entry<Character, Integer> entry : CONVERSIONS_TO_ARABIC_ADDITIVE.entrySet()) {
                    if (entry.getKey().equals(charArray[i])) {
                        outputNumber += entry.getValue(); // process the match
                        break; // character numeral was found no need to process more
                    }
                }
            }
        }

        return outputNumber;
    }

    /**
     * Basic checks to see if this is a valid roman numeral
     * @param romanNumeral input numeral
     * @return if it is valid or not
     */
    protected boolean validRomanNumeral (String romanNumeral) {
        boolean isValid = true;
        if (romanNumeral.length() == 0) {
            isValid = false; // cannot convert empty strings
        } else {
            for (Character c : romanNumeral.toCharArray()) {
                // Verify every character is a known roman character
                if (!CONVERSIONS_TO_ARABIC_ADDITIVE.containsKey(c)) {
                    isValid = false;
                }
            }
        }
        return isValid;
    }
}
