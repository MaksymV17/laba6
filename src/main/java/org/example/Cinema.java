package org.example;

public class Cinema {
    public static void bookSeats(char[][][] hall, int row, int[] seats, int hallNumber) {
        for (int seat : seats) {
            if (seat >= 0 && seat < hall[hallNumber][row].length) {
                hall[hallNumber][row][seat] = '1';
            } else {
                System.out.println("Помилка: Номер місця " + (seat + 1) + " знаходиться поза межами залу.");
            }
        }
    }

    public static void cancelBooking(char[][][] hall, int row, int[] seats, int hallNumber) {
        for (int seat : seats) {
            if (seat >= 0 && seat < hall[hallNumber][row].length) {
                hall[hallNumber][row][seat] = 'O';
            } else {
                System.out.println("Помилка: Номер місця " + (seat + 1) + " знаходиться за межами залу.");
            }
        }
    }

    public static boolean checkAvailability(char[][][] hall, int row, int numSeats, int hallNumber) {
        if (hallNumber < 0 || hallNumber >= hall.length || row < 0 || row >= hall[hallNumber].length) {
            System.out.println("Недійсні індекси номерів, рядків або залів.");
            return false;
        }

        int count = 0;
        for (int i = 0; i < hall[hallNumber][row].length; i++) {
            if (hall[hallNumber][row][i] == 'O') {
                count++;
                if (count == numSeats) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        return false;
    }
}