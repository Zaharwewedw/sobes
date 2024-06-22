package sobes.bank;

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

    public Map<Enum, Integer> getBankResult(Integer sum) {

        if (bankOperation.getClass() == Rubol.class) {
            for (int i = 0; i < NominalRub.values().length; i++ )
                sum  =  bankOperation.sumOperation(sum, NominalRub.values()[i], bank);

            if (sum != 0)
                throw new RuntimeException();

            bank =  bankOperation.bankResultOperation(bank);
        }

        if (bankOperation.getClass() == Dolor.class) {

            for (int i = 0; i < NominalDolor.values().length; i++ )
                sum  =  bankOperation.sumOperation(sum, NominalDolor.values()[i], bank);

            if (sum != 0)
                throw new RuntimeException();

            bank =  bankOperation.bankResultOperation(bank);
        }


        return bankOperation.ResultOperation();
    }

    @Override
    public void setBank(Enum e, Integer sum) {
        bank.put(e, sum);
    }
}
