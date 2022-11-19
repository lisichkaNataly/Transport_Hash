package transport;

public enum PassengerCapacity {
    ESPECIALLY_SMALL(null, 10),
    SMALL(null, 25),
    AVERAGE(40,50),
    BIG(60,80),
    ESPECIALLY_BIG(100,120);

    private final Integer capacityFrom;
    private final Integer capacityTo;

    PassengerCapacity(Integer capacityFrom, int capacityTo) {
        this.capacityFrom = capacityFrom;
        this.capacityTo = capacityTo;
    }


    @Override
    public String toString() {
        String capacityFromString = capacityFrom != null
                ? "от " + capacityFrom : "";
        String capacityToString = capacityTo != null
                ? "до " + capacityTo + "мест" : "";
        return "Вместимость" + capacityFromString + capacityToString;
    }
}
