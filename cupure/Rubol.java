package sobes.cupure;

import sobes.nominal.Nominal;
import sobes.nominal.NominalRub;

import java.util.HashMap;
import java.util.Map;

public class Rubol implements BankOperation {

    private final Map<Enum, Integer> result = new HashMap<>();
    public Rubol() {
        for (int i = 0; i <= NominalRub.values().length - 1; i++)
            result.put(NominalRub.values()[i], 0);
    }

    @Override
    public int sumOperation(Integer sum, Nominal nominalRub, Map<Enum, Integer> bank) {

        if (sum >= nominalRub.get()) {
            Integer res = sum / nominalRub.get();
            if (bank.get((NominalRub) nominalRub) < res)
                res = bank.get((NominalRub) nominalRub);

            result.put((NominalRub)nominalRub, res);
            sum -= nominalRub.get() * res;
        }
        return sum;
    }

    @Override
    public Map<Enum, Integer> ResultOperation() {
        return result;
    }

    @Override
    public Map<Enum, Integer> bankResultOperation(Map<Enum, Integer> bank) {
        for (int i = 0; i <= bank.size() - 1; i++)
            bank.put(NominalRub.values()[i],
                    bank.get(NominalRub.values()[i]) - bank.get(NominalRub.values()[i]));

        return bank;
    }
}
