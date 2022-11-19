package driver;

import transport.Transport;

import java.util.Objects;

public abstract class Driver<T extends Transport> {
    private final String fullName;
    private String category;
    private final int drivingExperience;
    private final T car;



    public Driver(String fullName, String category, int drivingExperience, T car) {
        this.fullName = fullName;
        setCategory(category);
        this.drivingExperience = drivingExperience;
        this.car = car;
    }



    public String getFullName() {
        return fullName;
    }

    public void setCategory(String category) {
        if (category == null) {
            throw new IllegalArgumentException("Необходимо указать категорию прав");
        }
        this.category = category;
    }


    public String getCategory() {
        return category;
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public void startDriving() {
        System.out.printf("Водитель %s начал двигаться", this.fullName);
        this.car.startDriving();
    }

    public void finishDriving() {
        System.out.printf("Водитель %s закончил движение", this.fullName);
        this.car.finishDriving();
    }

    public void refill() {
        System.out.printf("Водитель %s заправляет  %s %s",
                this.fullName, this.car.getBrand(), this.car.getModel());
    }

    @Override
    public String toString() {
        return String.format(
                "Водитель %s управляет автомобилем %s %s и будет участвовать в заезде",
                this.fullName, this.car.getBrand(), this.car.getModel());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver<?> driver = (Driver<?>) o;
        return Objects.equals(fullName, driver.fullName) && Objects.equals(category, driver.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, category);
    }
}

