package FirstWindowpackage;

import java.util.ArrayList;
import java.util.List;

public class BankManager {
    private List<BankAccount> accounts = new ArrayList<>();

    public void addAccount(BankAccount a) {
        accounts.add(a);
    }

    public void updateAccount(int index, BankAccount a) {
        accounts.set(index, a);
    }

    public void deleteAccount(int index) {
        accounts.remove(index);
    }

    public List<BankAccount> getAllAccounts() {
        return accounts;
    }
}
