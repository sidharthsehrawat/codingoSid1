package folder1.mmt;

import java.util.List;
import java.util.Map;

public class EqualCase extends TxnHandler {
    @Override
    public EqualCase addTxnMode() {
        return new EqualCase();
    }


    @Override
    public void txnCompute(Expense expense, Map<User, Double> expensedetails) {
        // txn logic
        if (expense.splitType.equals(TxnCase.SPLIT_EQUAL)) {
            double amount = expense.getAmount();
            List<User> invUsers = expense.getInvolvedUsers();
            User payee = expense.getPaid();
            int total = invUsers.size();
            double amt = amount / total;
            for (User inuser : invUsers) {
                expensedetails.put(inuser, amt);
            }

        } else if (expense.splitType.equals(TxnCase.SHARE)) {


        } else if (expense.splitType.equals(TxnCase.EXACT)) {

        }
    }
}
