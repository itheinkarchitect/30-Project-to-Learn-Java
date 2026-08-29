import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {

        Random random = new Random();
        int number = random.nextInt(100) + 1;

        int attempts = 0;

        Scanner scanner = new Scanner(System.in);

        int guess = 0;

        while (guess != number) {

            guess = scanner.nextInt();
            attempts++;

            if (guess > number) {
                System.out.println("Меньше");
            } else if (guess < number) {
                System.out.println("Больше");
            } else {
                System.out.println("Поздравляю!");
                System.out.println("Количество попыток: " + attempts);
            }
        }
    }
}