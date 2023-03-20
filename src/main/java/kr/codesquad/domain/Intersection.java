package kr.codesquad.domain;

public enum Intersection {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    public final int intersectionSize;
    public final long price;

    Intersection(int size, long price) {
        this.intersectionSize = size;
        this.price = price;
    }

    public static Intersection valueOf(int size, boolean bonus) {
        Intersection intersection;
        switch (size) {
            case 3 -> intersection = FIFTH;
            case 4 -> intersection = FOURTH;
            case 5 -> intersection = checkBonus(bonus);
            case 6 -> intersection = FIRST;
            default -> {
                return null;
            }
        }
        return intersection;
    }

    private static Intersection checkBonus(boolean bonus) {
        if (!bonus) return THIRD;
        return SECOND;
    }
}
