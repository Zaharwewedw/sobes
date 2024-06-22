package sobes.cupure;

import sobes.nominal.Nominal;

import java.util.Map;

public interface BankOperation {

    int sumOperation(Integer sum, Nominal nominalRub, Map<Enum, Integer> res);

    Map<Enum, Integer> ResultOperation();

    Map<Enum, Integer> bankResultOperation(Map<Enum, Integer> bank);
}
