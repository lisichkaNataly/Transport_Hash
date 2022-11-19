package transport;

import driver.Driver;

import java.util.*;

public abstract class Transport {
    private String brand;
    private String model;
    private double engineVolume;

    private final Set<Driver<?>> drivers = new HashSet<>();
    private final Set<Mechanic<?>> mechanics = new HashSet<>();
    private final Set<Sponsor> sponsors = new HashSet<>();



    public Transport(
            String brand,
            String model,
            double engineVolume){
        this.brand = brand;
        this.model = model;
        this.engineVolume = engineVolume;
        if (model== null || model.isEmpty() || model.isBlank())
            System.out.println("Неверное значение");
        if (brand == null || brand.isEmpty() || brand.isBlank())
            System.out.println("Неверное значение");
        if (engineVolume <= 0 )
            System.out.println("Неверное значение");
    }

    public double getEngineVolume() {
        return engineVolume;
    }


    public String getBrand() {
        return brand;
    }


    public String getModel() {
        return model;
    }

    public Set<Driver<?>> getDrivers() {
        return drivers;
    }

    public Set<Mechanic<?>> getMechanics() {
        return mechanics;
    }

    public Set<Sponsor> getSponsors() {
        return sponsors;
    }

    public void addDriver(Driver<?>... drivers) {
        this.drivers.addAll(Arrays.asList(drivers));
    }

    public void addMechanic(Mechanic<?>...mechanics) {
        this.mechanics.addAll(Arrays.asList(mechanics));
    }

    public void addSponsor(Sponsor...sponsors) {
        this.sponsors.addAll(Arrays.asList(sponsors));
    }


    public abstract void startDriving();

    public abstract void finishDriving();

    public abstract void printType();

    public abstract boolean service();

    public abstract void repair();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return Objects.equals(brand, transport.brand) && Objects.equals(model, transport.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model);
    }
}
