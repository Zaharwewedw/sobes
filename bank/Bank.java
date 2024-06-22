package sobes.bank;

import sobes.cupure.BankOperation;

import java.util.HashMap;
import java.util.Map;

public abstract class Bank {

    public BankOperation bankOperation;
    public Map<Enum, Integer> bank = new HashMap<>();

    public Bank (BankOperation bankOperation) {
        this.bankOperation = bankOperation;
    }
    abstract public void setBank(Enum e, Integer sum);

}
