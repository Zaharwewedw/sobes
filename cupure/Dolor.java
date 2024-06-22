package sobes.cupure;

import sobes.nominal.Nominal;
import sobes.nominal.NominalDolor;

import java.util.HashMap;
import java.util.Map;

public class Dolor implements BankOperation {

    private Map<Enum, Integer> result = new HashMap<>();

    public Dolor() {
        for (int i = 0; i <= NominalDolor.values().length - 1; i++)
            result.put(NominalDolor.values()[i], 0);
    }

    @Override
    public int sumOperation(Integer sum, Nominal nominalDolor, Map<Enum, Integer> bank) {

        if (sum >= nominalDolor.get()) {
            Integer res = sum / nominalDolor.get();
            if (bank.get((NominalDolor)nominalDolor) >= res) {
                result.put((NominalDolor)nominalDolor, res);
                sum -= nominalDolor.get() * res;
            } else {
                res = bank.get((NominalDolor)nominalDolor);
                result.put((NominalDolor)nominalDolor, res);
                sum -= nominalDolor.get() * res;
            }
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
            bank.put(NominalDolor.values()[i],  bank.get(NominalDolor.values()[i]) - bank.get(NominalDolor.values()[i]));
        return bank;
    }


}
