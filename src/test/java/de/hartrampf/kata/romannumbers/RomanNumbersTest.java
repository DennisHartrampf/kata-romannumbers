package de.hartrampf.kata.romannumbers;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class RomanNumbersTest {
    private final int    givenArabicNumber;
    private final String expectedRomanNumber;

    @Parameterized.Parameters(name = "Arabic {0} is converted to roman {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
            new Object[] {   1, "I" },
            new Object[] {   2, "II" },
            new Object[] {   3, "III" },
            new Object[] {   5, "V" },
            new Object[] {   6, "VI" },
            new Object[] {   7, "VII" },
            new Object[] {  10, "X" },
            new Object[] {  20, "XX" },
            new Object[] {  50, "L" },
            new Object[] { 100, "C" },
            new Object[] { 500, "D" },
            new Object[] {1000, "M" },
            new Object[] {   4, "IV"},
            new Object[] {   9, "IX"},
            new Object[] {  40, "XL"},
            new Object[] { 400, "CD"},
            new Object[] { 900, "CM"},
            new Object[] { 3439, "MMMCDXXXIX"}
        );
    }

    public RomanNumbersTest(int givenArabicNumber, String expectedRomanNumber) {
        this.givenArabicNumber   = givenArabicNumber;
        this.expectedRomanNumber = expectedRomanNumber;
    }

    @Test
    public void testConvertToRomanNumber() {
        MatcherAssert.assertThat(RomanNumberConverter.convertToRomanNumber(givenArabicNumber), IsEqual.equalTo(expectedRomanNumber));
    }

}
