package driver;

import transport.Car;

public class DriverB extends Driver <Car> {

    public DriverB(String fullName, String category, int drivingExperience, Car car) {
        super(fullName, category, drivingExperience, car);
    }
}
