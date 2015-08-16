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

    // Roman to Arabic Converstion Dictionaries
    private static final Map<String, Integer> CONVERSIONS_TO_ARABIC_SUBTRACTIVE; // eg IV, IX, XL, LC
    private static final Map<String, Integer> CONVERSIONS_TO_ARABIC_ADDITIVE; // eg I, V, X, C, L

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
        Map<String, Integer> arabicConversionsMapAdditive = new LinkedHashMap<String, Integer>();
        Map<String, Integer> arabicConversionsMapSubtractive = new LinkedHashMap<String, Integer>();
        for (Map.Entry<Integer, String> entry : CONVERSIONS_TO_ROMAN.entrySet()) {
            // Intentionally swapping key/value since this a reverse conversion
            if (entry.getValue().length() == 2) {
                arabicConversionsMapSubtractive.put(entry.getValue(), entry.getKey());
            } else if (entry.getValue().length() == 1) {
                arabicConversionsMapAdditive.put(entry.getValue(), entry.getKey());
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

            // Handle 2 character subtraction cases
            // Are there two characters left in the string?
            if (i+2 <= romanNumeral.length() && CONVERSIONS_TO_ARABIC_SUBTRACTIVE.containsKey(romanNumeral.substring(i,i+2))) {
                for (Map.Entry<String, Integer> entry : CONVERSIONS_TO_ARABIC_SUBTRACTIVE.entrySet()) {
                    if (entry.getKey().equals(romanNumeral.substring(i,i+2))) {
                        outputNumber += entry.getValue(); // process the match
                        i++; // advance the counter an extra spot for the extra character since we peeked forward
                        break; // two character number was found no need to process more
                    }
                }
            } else {
                // Handle additive cases
                if (charArray[i] == 'I') {
                    outputNumber += 1;
                } else if (charArray[i] == 'V') {
                    outputNumber += 5;
                } else if (charArray[i] == 'X') {
                    outputNumber += 10;
                }
            }
        }

        return outputNumber;
    }
}
