public class Task {

    String title;
    String description;
    boolean status;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void complete() {
        this.status = true;
    }

    public void printInfo() {
        System.out.println("Название: " + title);
        System.out.println("Описание: " + description);

        if (status == true) {
            System.out.println("Статус: Выполнена");
        } else {
            System.out.println("Статус: Не выполнена");
        }
    }

}