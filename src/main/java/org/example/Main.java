package org.example;

import java.util.Scanner;

public class Main {
    private static char[][][] hall;
    private static int numRows = 10;
    private static int numSeats = 20;

    public static void main(String[] args) {
        int numHalls = 5;

        hall = Initialization.initializeHall(numRows, numSeats, numHalls);

        Scanner scanner = new Scanner(System.in);

        int selectedHall = selectHall(scanner, numHalls);
        printSeatingArrangement(selectedHall);

        while (true) {
            System.out.println("\nВас вітає наш кінотеатр. Виберіть дію:");
            System.out.println("1. Змінити зал");
            System.out.println("2. Забронювати місце");
            System.out.println("3. Скасувати бронювання");
            System.out.println("4. Перевірити наявність місць");
            System.out.println("5. Роздрукувати розташування місць");
            System.out.println("0. Вихід");

            int choice;

            while (!scanner.hasNextInt()) {
                System.out.println("Невірні дані. Будь ласка спробуйте ще раз: ");
                scanner.next();
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    selectedHall = switchHall(scanner, numHalls);
                    break;
                case 2:
                    bookSeats(scanner, selectedHall);
                    break;
                case 3:
                    cancelBooking(scanner, selectedHall);
                    break;
                case 4:
                    checkAvailability(scanner, selectedHall);
                    break;
                case 5:
                    printSeatingArrangement(selectedHall);
                    break;
                case 0:
                    System.out.println("Дякуємо за використання нашого кінотеатру. До побачення!");
                    System.exit(0);
                default:
                    System.out.println("Невірний вибір. Будь ласка спробуйте ще раз.");
            }
        }
    }

    private static int switchHall(Scanner scanner, int numHalls) {
        int selectedHall = selectHall(scanner, numHalls);
        printSeatingArrangement(selectedHall);
        return selectedHall;
    }

    private static int selectHall(Scanner scanner, int numHalls) {
        System.out.println("Виберіть номер залу (1-" + numHalls + "): ");

        while (!scanner.hasNextInt()) {
            System.out.println("Неправильні дані. Введіть номер залу ще раз: ");
            scanner.next();
        }

        int selectedHall = scanner.nextInt();

        while (selectedHall < 1 || selectedHall > numHalls) {
            System.out.println("Недійсний номер залу. Будь ласка спробуйте ще раз: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Неправильні дані. Введіть номер залу ще раз: ");
                scanner.next();
            }

            selectedHall = scanner.nextInt();
        }

        return selectedHall - 1;
    }

    private static void bookSeats(Scanner scanner, int selectedHall) {
        System.out.println("Введіть номер ряду та кількість місць для бронювання:");

        while (!scanner.hasNextInt()) {
            System.out.println("Невірний ввід. Введіть номер ряду знову: ");
            scanner.next();
        }

        int row = scanner.nextInt() - 1;

        while (!scanner.hasNextInt()) {
            System.out.println("Невірний ввід. Введіть кількість місць знову: ");
            scanner.next();
        }

        int numSeats = scanner.nextInt();

        if (Cinema.checkAvailability(hall, row, numSeats, selectedHall)) {
            int[] seats = new int[numSeats];

            // Автоматично генеруємо номери місць
            for (int i = 0; i < numSeats; i++) {
                seats[i] = i;
            }

            Cinema.bookSeats(hall, row, seats, selectedHall);
            System.out.println("Місця успішно заброньовано.");

            System.out.println("Після бронювання:");
            printSeatingArrangement(selectedHall);
        } else {
            System.out.println("Недостатньо місць для бронювання.");
        }
    }
    private static void cancelBooking(Scanner scanner, int selectedHall) {
        System.out.println("Введіть номери рядів і місць, щоб скасувати бронювання:");

        while (!scanner.hasNextInt()) {
            System.out.println("Неправильні дані. Введіть ряд ще раз: ");
            scanner.next();
        }

        int row = scanner.nextInt() - 1;

        while (!scanner.hasNextInt()) {
            System.out.println("Неправильні дані. Введіть кількість місць ще раз: ");
            scanner.next();
        }

        int numSeats = scanner.nextInt();

        int[] seats = new int[numSeats];
        System.out.println("Введіть номери місць:");

        for (int i = 0; i < numSeats; i++) {
            while (!scanner.hasNextInt()) {
                System.out.println("Неправильні дані. Введіть номер місця ще раз: ");
                scanner.next();
            }

            seats[i] = scanner.nextInt() - 1;
        }

        Cinema.cancelBooking(hall, row, seats, selectedHall);
        System.out.println("Бронювання успішно скасовано.");

        System.out.println("Після скасування:");
        printSeatingArrangement(selectedHall);
    }

    private static void checkAvailability(Scanner scanner, int selectedHall) {
        System.out.println("Введіть ряд і кількість місць:");

        while (!scanner.hasNextInt()) {
            System.out.println("Неправильні дані. Введіть номер ряду ще раз: ");
            scanner.next();
        }

        int row = scanner.nextInt() - 1;

        while (!scanner.hasNextInt()) {
            System.out.println("Неправильні дані. Введіть кількість місць ще раз: ");
            scanner.next();
        }

        int numSeats = scanner.nextInt();

        boolean availability = Cinema.checkAvailability(hall, row, numSeats, selectedHall);

        if (availability) {
            System.out.println("Наявність " + numSeats + " місць у ряду " + (row + 1) + ": Так, є вільні місця.");
        } else {
            System.out.println("\"Наявність " + numSeats + " місць у ряду " + (row + 1) + ": Ні, всі місця зарезервовані.");
        }
    }

    private static void printSeatingArrangement(int hallNumber) {
        System.out.println("Розсадка для залу " + (hallNumber + 1) + ":");
        System.out.print("    ");

        for (int i = 1; i <= numSeats; i++) {
            if (i < 10) {
                System.out.print("   " + i);
            } else {
                System.out.print("  " + i);
            }
        }

        System.out.println();

        for (int i = 0; i < numRows; i++) {
            System.out.print((i + 1) + "  |");

            for (int j = 0; j < numSeats; j++) {
                System.out.print("   " + getSeatStatus(hall[hallNumber][i][j]));
            }

            System.out.println();
        }
    }

    private static String getSeatStatus(char seat) {
        return seat == 'O' ? "O" : "X";
    }
}