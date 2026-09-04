import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customers;

    public Bank() {
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer getCustomerById(int id) {
        for (int i = 0; i < customers.size(); i++) {
            if (id == customers.get(i).getId()) {
                return customers.get(i);
            }
        }

        return null;
    }

    public Customer createCustomer(int id, String name) {
        Customer customer = new Customer(id, name);
        customers.add(customer);

        return customer;
    }

    public Account createAccount(int customerId, int accountNum, double balance) {
        Customer customer = getCustomerById(customerId);

        if (customer != null) {
            Account account = new Account(accountNum, balance);
            customer.addAccount(account);
            return account;
        }

        return null;
    }

    public boolean transfer(Account from, Account to, double amount) {
        if (from.withdraw(amount)) {
            to.deposit(amount);
            return true;
        } else {
            return false;
        }
    }
}
