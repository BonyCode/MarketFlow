package com.marketflow;

import java.util.*;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Кембридж");
        Trader mario = new Trader("Mario", "Милан");
        Trader alan = new Trader("Alan", "Кембридж");
        Trader brian = new Trader("Brian", "Кембридж");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        Scanner scanner = new Scanner(System.in);
        int taskNumber = 0;

        while (taskNumber != 9) {
            // Выводим список доступных заданий:
            System.out.println("Выберите одно из следующих заданий:");
            System.out.println("1. Найти все транзакции за 2011 год и отсортировать их по сумме.");
            System.out.println("2. Вывести список неповторяющихся городов, в которых работают трейдеры.");
            System.out.println("3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.");
            System.out.println("4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.");
            System.out.println("5. Проверить, существует ли хотя бы один трейдер из Милана.");
            System.out.println("6. Вывести сумму всех транзакций трейдеров из Кембриджа.");
            System.out.println("7. Какова максимальная сумма среди всех транзакций?");
            System.out.println("8. Найти транзакцию с минимальной суммой.");
            System.out.println("9. Выйти из программы.");
            System.out.print("Введите номер задания (1-9), чтобы выполнить его: ");

            taskNumber = scanner.nextInt();

            switch (taskNumber) {
                case 1:
                    // Найти все транзакции за 2011 год и отсортировать их по сумме
                    List<Transaction> sortedTransactions2011 = transactions.stream()
                            .filter(transaction -> transaction.getYear() == 2011)
                            .sorted(Comparator.comparingInt(Transaction::getValue))
                            .collect(Collectors.toList());
                    System.out.println("Транзакции за 2011 год:");
                    sortedTransactions2011.forEach(transaction ->
                            System.out.printf("Трейдер: %s, город: %s, сумма: %d, год: %d%n",
                                    transaction.getTrader().getName(),
                                    transaction.getTrader().getCity(),
                                    transaction.getValue(),
                                    transaction.getYear()));
                    break;

                case 2:
                    // Вывести список неповторяющихся городов, в которых работают трейдеры
                    List<String> uniqueCities = transactions.stream()
                            .map(transaction -> transaction.getTrader().getCity())
                            .distinct()
                            .collect(Collectors.toList());
                    System.out.println("Города, в которых работают трейдеры: " + String.join(", ", uniqueCities));
                    break;

                case 3:
                    // Найти всех трейдеров из Кембриджа и отсортировать их по именам
                    List<Trader> cambridgeTraders = transactions.stream()
                            .map(Transaction::getTrader)
                            .filter(trader -> "Кембридж".equals(trader.getCity()))
                            .distinct()
                            .sorted(Comparator.comparing(Trader::getName))
                            .collect(Collectors.toList());
                    System.out.println("Трейдеры из Кембриджа:");
                    cambridgeTraders.forEach(trader -> System.out.println("Имя: " + trader.getName()));
                    break;

                case 4:
                    // Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке
                    String traderNames = transactions.stream()
                            .map(transaction -> transaction.getTrader().getName())
                            .distinct()
                            .sorted()
                            .collect(Collectors.joining(", "));
                    System.out.println("Имена всех трейдеров в алфавитном порядке: " + traderNames);
                    break;

                case 5:
                    // Проверить, существует ли хотя бы один трейдер из Милана
                    boolean isAnyTraderFromMilan = transactions.stream()
                            .anyMatch(transaction -> "Милан".equals(transaction.getTrader().getCity()));
                    System.out.println(isAnyTraderFromMilan ? "Есть трейдеры из Милана." : "Трейдеров из Милана нет.");
                    break;

                case 6:
                    // Вывести сумму всех транзакций трейдеров из Кембриджа
                    int cambridgeTransactionSum = transactions.stream()
                            .filter(transaction -> "Кембридж".equals(transaction.getTrader().getCity()))
                            .mapToInt(Transaction::getValue)
                            .sum();
                    System.out.println("Сумма всех транзакций трейдеров из Кембриджа: " + cambridgeTransactionSum);
                    break;

                case 7:
                    // Найти максимальную сумму среди всех транзакций
                    int maxTransactionValue = transactions.stream()
                            .mapToInt(Transaction::getValue)
                            .max()
                            .orElse(0);
                    System.out.println("Максимальная сумма транзакции: " + maxTransactionValue);
                    break;

                case 8:
                    // Найти транзакцию с минимальной суммой
                    Transaction minTransaction = transactions.stream()
                            .min(Comparator.comparingInt(Transaction::getValue))
                            .orElse(null);
                    if (minTransaction != null) {
                        System.out.printf("Транзакция с минимальной суммой: трейдер %s, город %s, сумма: %d, год: %d%n",
                                minTransaction.getTrader().getName(),
                                minTransaction.getTrader().getCity(),
                                minTransaction.getValue(),
                                minTransaction.getYear());
                    }
                    break;

                case 9:
                    // Выход из программы
                    System.out.println("Выход из программы...");
                    break;

                default:
                    System.out.println("Неверный номер задания. Пожалуйста, введите число от 1 до 9.");
            }
        }

        scanner.close();
    }
}
