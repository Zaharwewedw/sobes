package sobes.nominal;

import lombok.Getter;

@Getter
public enum NominalDolor implements Nominal {

    D100(100),
    D50(50),
    D20(20),
    D10(10),
    D5(5);

    private final int value;

    NominalDolor(int value) {
        this.value = value;
    }

    @Override
    public int get() {
        return value;
    }

    @Override
    public int length() {
        return NominalDolor.values().length;
    }
}
