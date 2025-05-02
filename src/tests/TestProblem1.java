package tests;


import org.junit.Test;

import static challenges.Problem1.decodePassword;
import static org.junit.Assert.assertEquals;

public class TestProblem1 {
    @Test
    public void testBasicShifts() {
        assertEquals("bqqmf", decodePassword("apple", 1));
        assertEquals("crrng", decodePassword("apple", 2));
        assertEquals("apple", decodePassword("apple", 0));
    }

    @Test
    public void testNegativeShifts() {
        assertEquals("zookd", decodePassword("apple", -1));
        assertEquals("ynnjc", decodePassword("apple", -2));
        assertEquals("apple", decodePassword("apple", -26));
    }

    @Test
    public void testWrapAroundForward() {
        assertEquals("abc", decodePassword("xyz", 3));
        assertEquals("efg", decodePassword("zab", 5));
        assertEquals("zab", decodePassword("xyz", 2));
    }

    @Test
    public void testWrapAroundBackward() {
        assertEquals("xyz", decodePassword("abc", -3));
        assertEquals("vwx", decodePassword("abc", -5));
        assertEquals("tuv", decodePassword("abc", -7));
    }

    @Test
    public void testLargeShifts() {
        assertEquals("bqqmf", decodePassword("apple", 27));  // same as shift by 1
        assertEquals("crrng", decodePassword("apple", 54));  // same as shift by 2
        assertEquals("zookd", decodePassword("apple", -27)); // same as shift by -1
        assertEquals("ynnjc", decodePassword("apple", -54)); // same as shift by -2
    }

    @Test
    public void testSpecialCharactersPreserved() {
        assertEquals("crrng!", decodePassword("apple!", 2));
        assertEquals("bqqmf123", decodePassword("apple123", 1));
        assertEquals("zookd#%", decodePassword("apple#%", -1));
    }

    @Test
    public void testEmptyString() {
        assertEquals("", decodePassword("", 5));
        assertEquals("", decodePassword("", -5));
    }

    @Test
    public void ComplexLongString() {
        String input = "if he had anything confidential to say, he wrote it in cipher, that is, by so changing the order of the letters of the alphabet, that not a word could be made out.";
        int shift = 7;
        String expectedOutput = "pm ol ohk hufaopun jvumpkluaphs av zhf, ol dyval pa pu jpwoly, aoha pz, if zv johunpun aol vykly vm aol slaalyz vm aol hswohila, aoha uva h dvyk jvbsk il thkl vba.";
        assertEquals(expectedOutput, decodePassword(input, shift));

        String input1 = "pm ol ohk hufaopun jvumpkluaphs av zhf, ol dyval pa pu jpwoly, aoha pz, if zv johunpun aol vykly vm aol slaalyz vm aol hswohila, aoha uva h dvyk jvbsk il thkl vba.";
        String outpu1 = "if he had anything confidential to say, he wrote it in cipher, that is, by so changing the order of the letters of the alphabet, that not a word could be made out.";
        int shift2 = -7;
        assertEquals(outpu1, decodePassword(input1, shift2));
    }
    @Test
    public void testShiftByZero() {
        assertEquals("apple", decodePassword("apple", 0));
        assertEquals("banana", decodePassword("banana", 0));
        assertEquals("12345", decodePassword("12345", 0));
        assertEquals("!@#$%", decodePassword("!@#$%", 0));
    }

}
