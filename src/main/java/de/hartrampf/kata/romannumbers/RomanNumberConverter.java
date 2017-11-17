package de.hartrampf.kata.romannumbers;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class RomanNumberConverter {

    private static final Map<Integer, String> ROMAN_DIGITS;

    static {
        TreeMap<Integer, String> romanDigits = new TreeMap<>((o1, o2) -> Integer.compare(o2, o1));
        romanDigits.put(1, "I");
        romanDigits.put(4, "IV");
        romanDigits.put(5, "V");
        romanDigits.put(9, "IX");
        romanDigits.put(10, "X");
        romanDigits.put(40, "XL");
        romanDigits.put(50, "L");
        romanDigits.put(100, "C");
        romanDigits.put(400, "CD");
        romanDigits.put(500, "D");
        romanDigits.put(900, "CM");
        romanDigits.put(1000, "M");
        ROMAN_DIGITS = Collections.unmodifiableMap(romanDigits);
    }

    public static String convertToRomanNumber(int arabicNumber) {
        StringBuilder romanNumber = new StringBuilder();

        for (Map.Entry<Integer, String> entry : ROMAN_DIGITS.entrySet()) {
            while (arabicNumber >= entry.getKey()) {
                romanNumber.append(entry.getValue());
                arabicNumber -= entry.getKey();
            }
        }

        return romanNumber.toString();
    }
}
