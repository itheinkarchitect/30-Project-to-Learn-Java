import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        boolean running = true;

        while (running) {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║          JAVA BANK           ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║ 1. Создать клиента           ║");
            System.out.println("║ 2. Создать счёт              ║");
            System.out.println("║ 3. Пополнить счёт            ║");
            System.out.println("║ 4. Снять деньги              ║");
            System.out.println("║ 5. Перевести деньги          ║");
            System.out.println("║ 6. Показать баланс           ║");
            System.out.println("║ 0. Выход                     ║");
            System.out.println("╚══════════════════════════════╝");

            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("ID клиента: ");
                    int customerId = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Имя клиента: ");
                    String name = scanner.nextLine();

                    bank.createCustomer(customerId, name);

                    System.out.println("Клиент создан!");
                    break;

                case 2:
                    System.out.print("ID клиента: ");
                    int ownerId = scanner.nextInt();

                    System.out.print("Номер счёта: ");
                    int accountNum = scanner.nextInt();

                    System.out.print("Начальный баланс: ");
                    double balance = scanner.nextDouble();

                    Account account = bank.createAccount(
                            ownerId,
                            accountNum,
                            balance
                    );

                    if (account != null) {
                        System.out.println("Счёт создан!");
                    } else {
                        System.out.println("Клиент не найден.");
                    }
                    break;

                case 3:
                    System.out.print("ID клиента: ");
                    int depositCustomerId = scanner.nextInt();

                    Customer depositCustomer =
                            bank.getCustomerById(depositCustomerId);

                    if (depositCustomer != null) {
                        System.out.print("Индекс счёта: ");
                        int depositAccountIndex = scanner.nextInt();

                        Account depositAccount =
                                depositCustomer.getAccount(depositAccountIndex);

                        System.out.print("Сумма: ");
                        double depositAmount = scanner.nextDouble();

                        depositAccount.deposit(depositAmount);

                        System.out.println("Счёт пополнен!");
                    } else {
                        System.out.println("Клиент не найден.");
                    }
                    break;

                case 4:
                    System.out.print("ID клиента: ");
                    int withdrawCustomerId = scanner.nextInt();

                    Customer withdrawCustomer =
                            bank.getCustomerById(withdrawCustomerId);

                    if (withdrawCustomer != null) {
                        System.out.print("Индекс счёта: ");
                        int withdrawAccountIndex = scanner.nextInt();

                        Account withdrawAccount =
                                withdrawCustomer.getAccount(withdrawAccountIndex);

                        System.out.print("Сумма: ");
                        double withdrawAmount = scanner.nextDouble();

                        if (withdrawAccount.withdraw(withdrawAmount)) {
                            System.out.println("Деньги сняты!");
                        } else {
                            System.out.println("Не удалось снять деньги.");
                        }
                    } else {
                        System.out.println("Клиент не найден.");
                    }
                    break;

                case 5:
                    System.out.print("ID отправителя: ");
                    int fromCustomerId = scanner.nextInt();

                    Customer fromCustomer =
                            bank.getCustomerById(fromCustomerId);

                    if (fromCustomer == null) {
                        System.out.println("Отправитель не найден.");
                        break;
                    }

                    System.out.print("Индекс счёта отправителя: ");
                    int fromIndex = scanner.nextInt();

                    System.out.print("ID получателя: ");
                    int toCustomerId = scanner.nextInt();

                    Customer toCustomer =
                            bank.getCustomerById(toCustomerId);

                    if (toCustomer == null) {
                        System.out.println("Получатель не найден.");
                        break;
                    }

                    System.out.print("Индекс счёта получателя: ");
                    int toIndex = scanner.nextInt();

                    System.out.print("Сумма перевода: ");
                    double transferAmount = scanner.nextDouble();

                    Account fromAccount = fromCustomer.getAccount(fromIndex);
                    Account toAccount = toCustomer.getAccount(toIndex);

                    if (bank.transfer(fromAccount, toAccount, transferAmount)) {
                        System.out.println("Перевод выполнен!");
                    } else {
                        System.out.println("Перевод не выполнен.");
                    }
                    break;

                case 6:
                    System.out.print("ID клиента: ");
                    int infoCustomerId = scanner.nextInt();

                    Customer infoCustomer =
                            bank.getCustomerById(infoCustomerId);

                    if (infoCustomer != null) {
                        System.out.print("Индекс счёта: ");
                        int infoAccountIndex = scanner.nextInt();

                        Account infoAccount =
                                infoCustomer.getAccount(infoAccountIndex);

                        System.out.println("\n--- Информация о счёте ---");
                        System.out.println(
                                "Номер: " + infoAccount.getAccountNum()
                        );
                        System.out.println(
                                "Баланс: " + infoAccount.getBalance()
                        );
                    } else {
                        System.out.println("Клиент не найден.");
                    }
                    break;

                case 0:
                    running = false;
                    System.out.println("Спасибо за использование Java Bank!");
                    break;

                default:
                    System.out.println("Неизвестная команда.");
            }
        }

        scanner.close();
    }
}