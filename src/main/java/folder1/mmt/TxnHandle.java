package folder1.mmt;

import java.util.Map;

public interface TxnHandle {
    public void txnCompute(Expense expense , Map<User, Double> expensedetails);
}
