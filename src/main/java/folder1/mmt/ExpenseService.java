package folder1.mmt;

import java.util.List;
import java.util.Map;

public class ExpenseService implements ExpenseInterface {


    private static Map<User, Double> sharesSheet;
    private static Map<User, Double> totalExpense;

    @Override
    public void recordExpense(double amount, String description, List<User> involvedUsers, User paid, TxnCase splitType) {
        Expense expense = new Expense();
        expense.setSplitType(splitType);
        expense.setDescription(description);
        expense.setPaid(paid);
        expense.setInvolvedUsers(involvedUsers);
        expense.setAmount(amount);

        EqualCase equalCase = new EqualCase();
        equalCase.txnCompute(expense, sharesSheet);
        sharesSheet.put(paid, amount);
    }
    //  meet.shah@go-mmt.com

    @Override
    public void recordExpense(double amount, String description, List<User> involvedUsers, User paid, TxnCase splitType, Map<User, Double> shareDetails) {

    }

    @Override
    public double getBalance(User user) {
        return 0;
    }

    @Override
    public double getBalanceSheet() {
        return 0;
    }
}
