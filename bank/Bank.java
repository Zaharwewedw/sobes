package sobes.bank;

import sobes.cupure.BankOperation;
import sobes.handler.BankEmptyException;
import sobes.nominal.Nominal;

import java.util.HashMap;
import java.util.Map;

public abstract class Bank {

    public BankOperation bankOperation;

    public Map<Enum, Integer> bank = new HashMap<>();

    public Bank (BankOperation bankOperation) {
        this.bankOperation = bankOperation;
    }

    public void setBank(Enum e, Integer sum) {
        bank.put(e, sum);
    }

    abstract public Map<Enum, Integer> getBankResult(Integer sum);

    abstract protected void operation(int sum, Nominal[] nominal);

    protected void checkingPossibilityOperation(int sum, Nominal[] nominal) {

        int res = 0;
        for (Nominal value : nominal)
            res += bank.get(value) * value.get();

        if (res < sum)
            throw new BankEmptyException("В банкомате не достаточно денег");
    }
}
