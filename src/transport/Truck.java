package transport;

import java.util.concurrent.ThreadLocalRandom;

public class Truck extends Transport implements Competing {
    private final CarriageCapacity carriageCapacity;




    public Truck(String brand, String model, double engineVolume, CarriageCapacity carriageCapacity) {
        super(brand, model, engineVolume);
        this.carriageCapacity = carriageCapacity;
    }

    public CarriageCapacity getCarriageCapacity() {
        return carriageCapacity;
    }

    @Override
    public void printType() {
        if (this.carriageCapacity == null) {
            System.out.println("Информации недостаточно");
        } else {
            System.out.println("Грузоподъемность авто: " + this.carriageCapacity);
        }
    }

    @Override
    public boolean service() {
        return Math.random() > 0.75;
    }

    @Override
    public void repair() {
        System.out.println("Грузовой автомобиль " + getBrand() + " " + getModel() + " починен!");
    }

    @Override
    public void startDriving() {
        System.out.printf("Грузовик %s %s начни движение",
                this.getBrand(),
                this.getModel());
    }

    @Override
    public void finishDriving() {
        System.out.printf("Грузовик %s %s закончи движение",
                this.getBrand(),
                this.getModel());
    }

    @Override
    public void pitStop() {
        System.out.printf("Грузовик! %s %s Пит-Стоп! ",
                this.getBrand(),
                this.getModel());
    }


    @Override
    public int bestLapTime() {
        return ThreadLocalRandom.current().nextInt(1, 20);
    }

    @Override
    public int maximumSpeed() {
        return ThreadLocalRandom.current().nextInt(1, 250);
    }

    public void printTruck() {
        System.out.println("Грузовик: " + getBrand() +
                ", модель: " + getModel() +
                ", объем двигателя: " + getEngineVolume() + " л");
    }
}
