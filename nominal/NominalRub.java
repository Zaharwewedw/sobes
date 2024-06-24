package sobes.nominal;

import lombok.Getter;

@Getter
public enum NominalRub implements Nominal {
    B5000(5000),
    B1000(1000),
    B500(500),
    B100(100),
    B50(50);

    private final int value;

    NominalRub(int value) {
        this.value = value;
    }

    @Override
    public int get() {
        return value;
    }

    @Override
    public int length() {
        return NominalRub.values().length;
    }
}
