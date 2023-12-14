package org.example;

public class Initialization {
    public static char[][][] initializeHall(int numRows, int numSeats, int numHalls) {
        char[][][] halls = new char[numHalls][numRows][numSeats];

        for (int h = 0; h < numHalls; h++) {
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numSeats; j++) {
                    halls[h][i][j] = 'O';
                }
            }
        }

        return halls;
    }
}