package folder1.mmt;

import java.util.Map;

public class SharedCase extends TxnHandler {
    @Override
    public SharedCase addTxnMode() {
       return new SharedCase();
    }


    @Override
    public void txnCompute(Expense expense, Map<User, Double> expensedetails) {
        // txn logic
    }
}
