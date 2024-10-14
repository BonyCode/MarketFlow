MarketFlow — это консольная Java-программа, которая выполняет анализ транзакций с использованием Stream API и лямбда-выражений. Программа предоставляет возможность интерактивного выбора и выполнения операций над списком транзакций трейдеров, включая сортировку, фильтрацию и агрегацию данных.

Основные функции:
Найти транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).

Программа фильтрует все транзакции, совершенные в 2011 году, и сортирует их по возрастанию суммы.
Вывести список неповторяющихся городов, в которых работают трейдеры.

Программа собирает уникальные города, где работают трейдеры, и выводит их список.
Найти всех трейдеров из Кембриджа и отсортировать их по именам.

Программа находит всех трейдеров, работающих в Кембридже, и сортирует их по алфавиту.
Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.

Программа выводит имена всех трейдеров в виде строки, отсортированной по алфавиту.
Проверить, существует ли хотя бы один трейдер из Милана.

Программа проверяет, есть ли среди трейдеров те, кто работает в Милане, и выводит соответствующий результат.
Вывести сумму всех транзакций трейдеров из Кембриджа.

Программа подсчитывает и выводит общую сумму всех транзакций, совершенных трейдерами из Кембриджа.
Найти максимальную сумму среди всех транзакций.

Программа находит и выводит максимальную сумму транзакции.
Найти транзакцию с минимальной суммой.

Программа находит и выводит информацию о транзакции с минимальной суммой.
Технологии:
Java 17 — для реализации основной логики программы.
Stream API и лямбда-выражения — для обработки, фильтрации и сортировки данных.
Maven — для управления сборкой проекта.
JUnit 5 — для написания тестов.
Запуск программы:
1. Склонируйте или загрузите проект в вашу рабочую директорию.
2. Соберите проект с помощью Maven:
mvn clean install
3. Запустите программу:
mvn exec:java -Dexec.mainClass="com.marketflow.PuttingIntoPractice"
4. Введите номер задачи (1-8) для выполнения соответствующего задания.

Тестирование:
Проект включает тесты для классов Trader, Transaction и основной логики программы:

Запуск тестов
mvn test

Программа разработана для практики работы со Stream API и лямбда-выражениями в Java.


