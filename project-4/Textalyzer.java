import java.util.Scanner;

public class Textalyzer {

    static int countVowels(String text) {
    int count = 0;

    for (int i = 0; i < text.length(); i++) {
        char symbol = text.charAt(i);

        if (symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u') {
            count++;
        }
    }

    return count;
}

    static void typeText(String text) {
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < text.length(); i++) {
        builder.append(text.charAt(i));
        System.out.print("\r" + builder);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Печать прервана");
            return;
        }
    }
}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите текст: ");
        String text = scanner.nextLine();

        String[] words = text.split(" ");
        String longestWord = "";
        int vowels = countVowels(text);
        

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > longestWord.length()) {
                longestWord = words[i];
            }
        }

        System.out.println("Длина: " + text.length());
        System.out.println("Первый символ: " + text.charAt(0));
        System.out.println("Последний символ: " + text.charAt(text.length() - 1));
        System.out.println("Верхний регистр: " +text.toUpperCase());
        System.out.println("Нижний регистр: " + text.toLowerCase());
        System.out.println("Содержит \"Java\": " + text.contains("Java"));
        System.out.println("Количество слов: " + words.length);
        System.out.println("Самое длинное слово: " + longestWord);
        System.out.println("Количество гласных: " + vowels);
        typeText(text);

        scanner.close();
    }     
}
