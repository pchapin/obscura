package edu.vtc.obscura;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class String2KeyTest {

    @Test
    void iteratedAndSaltedTest()
    {
        byte [] salt = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        byte [] expectedResult = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
        int octetCount = 100_000;

        try {
            byte[] result = String2Key.iteratedAndSalted(2, 128, "Hello, World", salt, octetCount);
            Assertions.assertArrayEquals(expectedResult, result, "Bad key computed");
        }
        catch (String2Key.NotImplementedException ex) {
            Assertions.fail();
        }
    }

}
