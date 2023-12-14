package org.example;
import org.junit.Test;
import static org.junit.Assert.*;

public class  CinemaTest {

    @Test
    public void testBookSeats() {
        char[][][] hall = {
                {
                        {'O', 'O', 'O'},
                        {'O', 'O', 'O'},
                        {'O', 'O', 'O'}
                }
        };

        Cinema.bookSeats(hall, 0, new int[]{0, 1}, 0);

        assertEquals('1', hall[0][0][0]);
        assertEquals('1', hall[0][0][1]);
        assertEquals('O', hall[0][0][2]);
    }

    @Test
    public void testCancelBooking() {
        char[][][] hall = {
                {
                        {'1', '1', 'O'},
                        {'O', 'O', 'O'},
                        {'O', 'O', 'O'}
                }
        };

        Cinema.cancelBooking(hall, 0, new int[]{0, 1}, 0);

        assertEquals('O', hall[0][0][0]);
        assertEquals('O', hall[0][0][1]);
        assertEquals('O', hall[0][0][2]);
    }

    @Test
    public void testCheckAvailability() {
        char[][][] hall = {
                {
                        {'O', 'O', 'O'},
                        {'O', 'O', 'O'},
                        {'O', 'O', 'O'}
                }
        };

        assertTrue(Cinema.checkAvailability(hall, 0, 2, 0));
        assertFalse(Cinema.checkAvailability(hall, 0, 4, 0));
    }

    @Test
    public void testCheckAvailabilityInvalidIndices() {
        char[][][] hall = {
                {
                        {'O', 'O', 'O'},
                        {'O', 'O', 'O'},
                        {'O', 'O', 'O'}
                }
        };

        assertFalse(Cinema.checkAvailability(hall, -1, 2, 0));
        assertFalse(Cinema.checkAvailability(hall, 0, 2, 1));
    }
}