package folder1.mmt;


import lombok.Data;

@Data
public abstract class TxnHandler implements TxnHandle{

    public abstract TxnHandler addTxnMode();

}
