package edu.vermontstate.obscura;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TrivialTest {

    @Test
    void trivialTestMethod()
    {
        Assertions.assertEquals(1, 2 - 1, "Basic math has failed!");
    }

}
