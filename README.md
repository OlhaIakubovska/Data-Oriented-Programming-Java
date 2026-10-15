# Лабораторна робота: Data-Oriented Programming у Java

## Опис проєкту

Система управління замовленнями, реалізована за підходом Data-Oriented Programming (DOP):

- дані змодельовані незмінними типами: `sealed interface OrderStatus` і чотири `record` (`Pending`, `Paid`, `Shipped`, `Cancelled`);
- валідація виконується в компактних конструкторах records і кидає `IllegalArgumentException`;
- бізнес-логіка винесена в окремий клас `OrderProcessor`, який використовує `switch` expression з pattern matching без `default` та Text Blocks для формування результату.

Усі класи знаходяться в пакеті `ua.kpi.comsys.dop`.

## Розрахунок варіанта

Варіант визначається остачею від ділення номера залікової книжки студента на 3:

V = N mod 3,

де V — номер варіанта завдання, N — номер залікової книжки студента.

N = 4518, тому V = 4518 mod 3 = 0.

Варіант V = 0: «Система управління замовленнями».

## Реалізаційні рішення

- Назва поля оплати: `paymentID`.
- Сума друкується через `BigDecimal.toString()`, наприклад `$100.50`.
- Дата друкується у форматі ISO (`LocalDate.toString()`), наприклад `2026-10-15`.
- Рядок результату `process()` не містить завершального переносу рядка.
- У `Paid` суму `null` також відхиляє `IllegalArgumentException`.

## Вимоги

- JDK 21 або новіший (проєкт компілюється з `release 21`)
- Apache Maven 3.9+ (або Maven, вбудований в IntelliJ IDEA)

## Запуск тестів

З командного рядка в корені проєкту:

```bash
mvn clean test
```

В IntelliJ IDEA: панель **Maven** → `dop-lab` → **Lifecycle** → двічі клікнути **test**.

Очікуваний результат: 18 тестів, `BUILD SUCCESS`.

## Структура

```
src/main/java/ua/kpi/comsys/dop/   OrderStatus, Pending, Paid, Shipped, Cancelled, OrderProcessor
src/test/java/ua/kpi/comsys/dop/   OrderStatusTest, OrderProcessorTest
```

## Автор

IO-45 Якубовська Ольга Василівна