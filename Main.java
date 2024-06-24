package sobes;

import sobes.handler.BankEmptyException;
import sobes.handler.OperationSumException;
import sobes.handler.SumNullException;
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


        //Dolor null
        BankOperation operationDolorNull = new Dolor();
        ATM atmDolorNull = new ATM(operationDolorNull);

        try {
            atmDolorNull.getBankResult(null);
        } catch (SumNullException e) {
            System.out.println(e.getMessage());
        }

        //An empty bank dolor
        BankOperation operationDolorEmpty = new Dolor();
        ATM atmDolorEmpty = new ATM(operationDolorEmpty);

        atmDolorEmpty.setBank(NominalDolor.D100, 0);
        atmDolorEmpty.setBank(NominalDolor.D50, 0);
        atmDolorEmpty.setBank(NominalDolor.D20, 0);
        atmDolorEmpty.setBank(NominalDolor.D10, 0);
        atmDolorEmpty.setBank(NominalDolor.D5, 0);

        try {
            atmDolorEmpty.getBankResult(500);
        } catch (BankEmptyException e) {
            System.out.println(e.getMessage());
        }

        // Dolor not naminal
        BankOperation operationDolorNotNominal = new Dolor();
        ATM atmDolorNotNominal = new ATM(operationDolorNotNominal);

        atmDolorNotNominal.setBank(NominalDolor.D100, 32);
        atmDolorNotNominal.setBank(NominalDolor.D50, 1);
        atmDolorNotNominal.setBank(NominalDolor.D20, 4);
        atmDolorNotNominal.setBank(NominalDolor.D10, 1);
        atmDolorNotNominal.setBank(NominalDolor.D5, 42);

        try {
            atmDolorNotNominal.getBankResult(501);
        } catch (OperationSumException e) {
            System.out.println(e.getMessage());
        }

        // Rubol
        BankOperation operationRub = new Rubol();
        ATM atmRub = new ATM(operationRub);

        atmRub.setBank(NominalRub.B5000, 3);
        atmRub.setBank(NominalRub.B1000, 4);
        atmRub.setBank(NominalRub.B500, 4);
        atmRub.setBank(NominalRub.B100, 3);
        atmRub.setBank(NominalRub.B50, 4);

        System.out.println(atmRub.getBankResult(11000));

        // Rubol not naminal
        BankOperation operationRubNotNominal = new Rubol();
        ATM atmRubNotNominal = new ATM(operationRubNotNominal);

        atmRubNotNominal.setBank(NominalRub.B5000, 3);
        atmRubNotNominal.setBank(NominalRub.B1000, 4);
        atmRubNotNominal.setBank(NominalRub.B500, 4);
        atmRubNotNominal.setBank(NominalRub.B100, 3);
        atmRubNotNominal.setBank(NominalRub.B50, 4);

        try {
            atmRubNotNominal.getBankResult(501);
        } catch (OperationSumException e) {
            System.out.println(e.getMessage());
        }
        // и так далее с "рублем"
    }
}
