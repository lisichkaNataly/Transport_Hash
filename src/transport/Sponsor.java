package transport;

import java.util.Objects;

public class Sponsor {
    private final String name;
    private final int amount;

    public Sponsor(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void sponsorTheRace() {
        System.out.printf("Спонсор %s проспонсировал заезд %d%n", name, amount);
    }

    @Override
    public String toString() {
        return name + " сумма: " + amount + " рублей";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sponsor sponsor = (Sponsor) o;
        return Objects.equals(name, sponsor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
