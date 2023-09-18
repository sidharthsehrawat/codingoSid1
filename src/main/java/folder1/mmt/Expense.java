package folder1.mmt;

import lombok.Data;

import java.util.List;

@Data
public class Expense {
    Double amount;
    String description;
    List<User> involvedUsers;
    User paid;
    TxnCase splitType;
}
