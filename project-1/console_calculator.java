import java.util.Scanner;

public class console_calculator {

    static double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Первое цифра: ");
        double a = scanner.nextDouble();

        System.out.println("Второе цифра: ");
        double b = scanner.nextDouble();

        scanner.nextLine();

        System.out.println("Операция: ");
        String action = scanner.nextLine();


        double result = 0;

        switch (action) {
            case "+":
                result = add(a, b);
                System.out.println("Результат: " + result);
                break;
            case "-":
                result = a - b;
                System.out.println("Результат: " + result);
                break;
            case "*":
                result = a * b;
                System.out.println("Результат: " + result);
                break;
            case "/":
                if (b == 0) {
                    System.out.println("Нельзя делить на ноль!");
                } else {
                    result = a / b;
                    System.out.println("Результат: " + result);
                }
                break;
            default:
                System.out.println("Неизвестная операция");
        }

    }
}