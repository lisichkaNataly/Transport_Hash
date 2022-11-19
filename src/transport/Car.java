package transport;

import java.util.concurrent.ThreadLocalRandom;

public class Car extends Transport implements Competing{
    private final TypeOfBody typeOfBody;
    public Car(String brand, String model, double engineVolume, TypeOfBody typeOfBody) {
        super(brand, model, engineVolume);
        this.typeOfBody = typeOfBody;
    }

    public TypeOfBody getTypeOfBody() {
        return typeOfBody;
    }

    @Override
    public void printType() {
        if (this.typeOfBody == null) {
            System.out.println("Информации недостаточно");
        } else {
            System.out.println("Тип кузова авто: " + this.typeOfBody);
        }
    }

    @Override
    public boolean service() {
        return Math.random()> 0.7;
    }

    public void startDriving() {
        System.out.printf("Автомобиль %s %s начни движение",
                this.getBrand(),
                this.getModel());
    }
    public void finishDriving() {
        System.out.printf("Автомобиль %s %s закончи движение",
                this.getBrand(),
                this.getModel());
    }

    @Override
    public void pitStop() {
        System.out.printf("Автомобиль %s %s Пит-Стоп! ",
                this.getBrand(),
                this.getModel());
    }

    @Override
    public int bestLapTime() {return ThreadLocalRandom.current().nextInt(1, 10);
    }

    @Override
    public int maximumSpeed() {return  ThreadLocalRandom.current().nextInt(1,400);
    }

    public void printCar() {
        System.out.println("Легковой автомобиль: " + getBrand()+
                ", модель: " + getModel() +
                ", объем двигателя: " + getEngineVolume() + " л");
    }

    @Override
    public void repair() {
        System.out.println("Машина " + getBrand() + " " + getModel() + " починена!");
    }
}
