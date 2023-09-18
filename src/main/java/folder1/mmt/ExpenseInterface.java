package folder1.mmt;

import java.util.List;
import java.util.Map;

public interface ExpenseInterface {

    public void recordExpense(double amount, String description, List<User> involvedUsers, User paid, TxnCase splitType);
    public void recordExpense(double amount, String description, List<User> involvedUsers, User paid, TxnCase splitType, Map<User, Double> shareDetails);
    public double  getBalance(User user);
    public double getBalanceSheet();

}
