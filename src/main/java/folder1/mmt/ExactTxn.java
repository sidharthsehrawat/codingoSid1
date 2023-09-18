package folder1.mmt;

import lombok.Data;

import java.util.Map;

@Data
public class ExactTxn extends TxnHandler {
    @Override
    public ExactTxn addTxnMode() {
        ExactTxn exactTxn = new ExactTxn();
        return exactTxn;
    }



    @Override
    public void txnCompute(Expense expense, Map<User, Double> expensedetails) {
        // txn logic
    }
}
