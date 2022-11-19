package transport;

import java.util.concurrent.ThreadLocalRandom;

public class Bus extends Transport implements Competing{
    private final PassengerCapacity passengerCapacity;

    public Bus(String brand, String model, double engineVolume, PassengerCapacity passengerCapacity) {
        super(brand, model, engineVolume);
        this.passengerCapacity = passengerCapacity;
    }

    public PassengerCapacity getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public void printType() {
        if (this.passengerCapacity == null) {
            System.out.println("Информации недостаточно");
        } else {
            System.out.println("Вместимость автобуса: " + this.passengerCapacity);
        }
    }

    @Override
    public boolean service() {
        System.out.println("Автобус " + getBrand() + " " + getModel() + " в диагностике не требуется");
        return true;
    }

    @Override
    public void repair() {
        System.out.println("Автобус " + getBrand() + " " + getModel() + " починен!");
    }

    @Override
    public void startDriving() {
        System.out.printf("Автобус %s %s начни движение",
                this.getBrand(),
                this.getModel());
    }

    @Override
    public void finishDriving() {
        System.out.printf("Автобус %s %s закончи движение",
                this.getBrand(),
                this.getModel());
    }

    @Override
    public void pitStop() {
        System.out.printf("Автобус!  %s %s Пит-Стоп! ",
                this.getBrand(),
                this.getModel());
    }

    @Override
    public int bestLapTime() {return ThreadLocalRandom.current().nextInt(1, 15);
    }

    @Override
    public int maximumSpeed() { return ThreadLocalRandom.current().nextInt(1, 300);
    }

    public void printBus() {
        System.out.println("Автобус: " + getBrand()+
                ", модель: " + getModel() +
                ", объем двигателя: " + getEngineVolume() + " л");
    }
}
