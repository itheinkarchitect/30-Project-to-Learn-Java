import java.util.ArrayList;

public class TaskManager {

    ArrayList<Task> tasks = new ArrayList<>();


    public void addTask(Task task) {
        tasks.add(task);
    }

    public void showTasks() {
        for (Task task : tasks) {
            task.printInfo();
        }
    }

    public void removeTask(int number) {
        if (number >= 1 && number <= tasks.size()) {
            tasks.remove(number - 1);
        }
    }

    public void completeTask(int number) {
    if (number >= 1 && number <= tasks.size()) {
        Task task = tasks.get(number - 1);
        task.complete();
    }
}
}