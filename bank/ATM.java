package sobes.bank;

import sobes.handler.OperationSumException;
import sobes.handler.SumNullException;

import sobes.nominal.Nominal;
import sobes.nominal.NominalDolor;
import sobes.nominal.NominalRub;

import sobes.cupure.BankOperation;
import sobes.cupure.Dolor;
import sobes.cupure.Rubol;

import java.util.Map;

/**
 * Банкомат.
 * Инициализируется набором купюр и умеет выдавать купюры (eng: withdraw) для заданной суммы, либо отвечать отказом.
 * При выдаче купюры списываются с баланса банкомата.
 * Допустимые номиналы: 50₽, 100₽, 500₽, 1000₽, 5000₽.
 */

public class ATM extends Bank {

    public ATM (BankOperation bankOperation) {
        super(bankOperation);
    }

    @Override
    public Map<Enum, Integer> getBankResult(Integer sum) {

        if (sum == null)
            throw new SumNullException("Перейдате не пустоне значение");

        if (bankOperation.getClass() == Rubol.class)
           operation(sum, NominalRub.values());

        if (bankOperation.getClass() == Dolor.class)
           operation(sum, NominalDolor.values());

        return bankOperation.ResultOperation();
    }

    @Override
    protected void operation(int sum, Nominal[] nominal) {

        checkingPossibilityOperation(sum, nominal);

        for (Nominal value : nominal)
            sum = bankOperation.sumOperation(sum, value, bank);

        if (sum != 0)
            throw new OperationSumException("не возможно выдать купюры с таким номиналом");

        bank =  bankOperation.bankResultOperation(bank);
    }
}
