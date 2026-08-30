import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {

            System.out.println("\n=== Менеджер задач ===");
            System.out.println("1. Добавить задачу");
            System.out.println("2. Показать задачи");
            System.out.println("3. Выполнить задачу");
            System.out.println("4. Удалить задачу");
            System.out.println("5. Выйти");

            System.out.print("Выберите действие: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Введите название: ");
                    String title = scanner.nextLine();

                    System.out.print("Введите описание: ");
                    String description = scanner.nextLine();

                    Task task = new Task(title, description);
                    manager.addTask(task);
                    break;

                case 2:
                    manager.showTasks();
                    break;

                case 3:
                    System.out.print("Номер задачи: ");
                    int complete_number = scanner.nextInt();
                    manager.completeTask(complete_number);
                    break;

                case 4:
                    System.out.print("Номер задачи: ");
                    int remove_number = scanner.nextInt();
                    manager.removeTask(remove_number);
                    break;

                case 5:
                    System.out.println("До свидания!");
                    return;

                default:
                    System.out.println("Неверный выбор.");
            }

        }

    }

}