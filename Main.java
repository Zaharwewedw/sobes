package sobes;

import sobes.nominal.NominalDolor;
import sobes.nominal.NominalRub;
import sobes.bank.ATM;
import sobes.cupure.BankOperation;
import sobes.cupure.Dolor;
import sobes.cupure.Rubol;

/**
 * Банкомат.
 * Инициализируется набором купюр и умеет выдавать купюры (eng: withdraw) для заданной суммы, либо отвечать отказом.
 * При выдаче купюры списываются с баланса банкомата.
 * Допустимые номиналы: 50₽, 100₽, 500₽, 1000₽, 5000₽.
 */
public class Main {

    public static void main(String[] args) {
        //Dolor
        BankOperation operationDolor = new Dolor();
        ATM atmDolor = new ATM(operationDolor);

        atmDolor.setBank(NominalDolor.D100, 4);
        atmDolor.setBank(NominalDolor.D50, 4);
        atmDolor.setBank(NominalDolor.D20, 4);
        atmDolor.setBank(NominalDolor.D10, 4);
        atmDolor.setBank(NominalDolor.D5, 4);

        System.out.println(atmDolor.getBankResult(500));

        // Rubol
        BankOperation operationRub = new Rubol();
        ATM atmRub = new ATM(operationRub);

        atmRub.setBank(NominalRub.B5000, 3);
        atmRub.setBank(NominalRub.B1000, 4);
        atmRub.setBank(NominalRub.B500, 4);
        atmRub.setBank(NominalRub.B100, 3);
        atmRub.setBank(NominalRub.B50, 4);

        System.out.println(atmRub.getBankResult(11000));
    }
}
