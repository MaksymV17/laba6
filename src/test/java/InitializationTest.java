package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class InitializationTest {

    @Test
    public void testInitializeHall() {
        int numRows = 3;
        int numSeats = 4;
        int numHalls = 2;

        char[][][] halls = Initialization.initializeHall(numRows, numSeats, numHalls);

        assertEquals(numHalls, halls.length);
        assertEquals(numRows, halls[0].length);
        assertEquals(numSeats, halls[0][0].length);

        for (int h = 0; h < numHalls; h++) {
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numSeats; j++) {
                    assertEquals('O', halls[h][i][j]);
                }
            }
        }
    }
}