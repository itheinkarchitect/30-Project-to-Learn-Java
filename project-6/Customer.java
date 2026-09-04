import java.util.ArrayList;

public class Customer {
    private int id;
    private String name;
    private ArrayList<Account> accounts;

    public Customer(int id, String name) {
        this.name = name;
        this.id = id;

        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Account getAccount(int index) {
        return accounts.get(index);
    }
}
