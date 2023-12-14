# Опис проекту
Цей проект реалізує систему бронювання квитків для кінотеатру, яка включає в себе створення та управління залами, резервування та скасування бронювань. Програма взаємодіє з користувачем через консольний інтерфейс, дозволяючи зручно вибирати опції та виконувати необхідні дії.

## Клас `Main`
Клас `Main` є основним класом програми, який керує всією логікою системи бронювання квитків та взаємодіє з користувачем.

### Методи
- `switchHall(Scanner scanner, int numHalls) → int`: Змінює активний кінозал за допомогою введення користувача.
- `selectHall(Scanner scanner, int numHalls) → int`: Вибирає номер кінозалу для подальших операцій.
- `bookSeats(Scanner scanner, int selectedHall)`: Здійснює резервування місць у вибраному кінозалі.
- `cancelBooking(Scanner scanner, int selectedHall)`: Скасовує резервування місць у вибраному кінозалі.
- `checkAvailability(Scanner scanner, int selectedHall)`: Перевіряє доступність місць у вибраному кінозалі.
- `printSeatingArrangement(int hallNumber)`: Виводить розташування місць у вказаному кінозалі.

## Клас `Cinema`
Клас `Cinema` відповідає за обробку операцій з резервування та скасування бронювань місць, а також перевірку доступності місць.

### Методи
- `bookSeats(char[][][] hall, int row, int[] seats, int hallNumber)`: Здійснює резервування вказаних місць у вибраному кінозалі.
- `cancelBooking(char[][][] hall, int row, int[] seats, int hallNumber)`: Скасовує резервування вказаних місць у вибраному кінозалі.
- `checkAvailability(char[][][] hall, int row, int numSeats, int hallNumber) → boolean`: Перевіряє доступність вказаної кількості місць у вибраному кінозалі.

## Клас `Initialization`
Клас `Initialization` відповідає за ініціалізацію кінозалів та їхніх розташувань місць.

### Метод
- `initializeHall(int numRows, int numSeats, int numHalls) → char[][][]`: Створює та ініціалізує кінозали заданого розміру та кількості місць.

# Тести
## Клас `CinemaTest`
Клас `CinemaTest` використовує бібліотеку JUnit для тестування класу `Cinema` та його методів.

### Методи тесту:
1. `testBookSeats()`: Перевіряє, чи вірно працює метод `bookSeats` при резервуванні місць у кінозалі.
2. `testCancelBooking()`: Перевіряє, чи вірно працює метод `cancelBooking` при скасуванні резервування місць у кінозалі.
3. `testCheckAvailability()`: Перевіряє, чи вірно працює метод `checkAvailability` при перевірці доступності місць у кінозалі.
4. `testCheckAvailabilityInvalidIndices()`: Перевіряє, чи вірно обробляються невірні індекси при виклику методу `checkAvailability`.

## Клас `InitializationTest`
Клас `InitializationTest` використовує бібліотеку JUnit для тестування класу `Initialization` та його методів.

### Метод тесту:
 `testInitializeHall()`: Перевіряє, чи вірно працює метод `initializeHall` при ініціалізації кінозалів з заданими параметрами.
