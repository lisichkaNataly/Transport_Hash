package driver;

import transport.Truck;

public class DriverC extends Driver<Truck> {

    public DriverC(String fullName, String category, int drivingExperience, Truck car) {
        super(fullName, category, drivingExperience, car);
    }
}
