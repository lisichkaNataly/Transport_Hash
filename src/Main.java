import driver.Driver;
import driver.DriverB;
import driver.DriverC;
import driver.DriverD;
import transport.*;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Mechanic<Car> ivan = new Mechanic<Car>("Иван", "Смирнов", "Nokian");
        Mechanic<Bus> maksim = new Mechanic<Bus>("Максим", "Пригожин", "Style");
        Mechanic<Truck> aleksei = new Mechanic<Truck>("Алексей", "Осокин", "VIP-сервис");
        Sponsor vtb = new Sponsor("ВТБ", 5_000_0000);
        Sponsor gazprom = new Sponsor("Газпром", 15_000_000);
        Sponsor rosneft = new Sponsor("Роснефть", 8_000_000);


        Car lada = new Car("Lada", "Vesta", 2.0, TypeOfBody.UNIVERSAL);
        lada.addDriver(new DriverB("Иванов Иван Иванович", "B", 5,lada));
        lada.addMechanic(ivan);
        lada.addSponsor(vtb,rosneft);
        Car kia = new Car("KIA", "Cerato", 2.5, TypeOfBody.SEDAN);
        kia.addDriver(new DriverB("Петров Петр Петрович", "B", 5,kia));
        kia.addMechanic(ivan);
        kia.addSponsor(rosneft,gazprom);
        Car skoda = new Car("Skoda", "Octavia", 3.0, TypeOfBody.SEDAN);
        skoda.addDriver(new DriverB("Соболев Вячеслав Геннадьевич", "B", 5, skoda));
        Car audi = new Car("Audi", "A3", 3.0, TypeOfBody.SEDAN);
        audi.addDriver(new DriverB("Спирин Юрий Николаевич", "B", 5, audi));
        lada.printCar();
        kia.printCar();
        skoda.printCar();
        audi.printCar();


        Bus man = new Bus("MAN", "Lion’s Coach", 5.0, PassengerCapacity.AVERAGE);
        man.addDriver(new DriverD("Сятчихин Андрей Петрович", "D", 6, man));
        man.addMechanic(maksim);
        man.addSponsor(vtb);
        Bus gaz = new Bus("GAZ", "Вектор Next", 3.3,PassengerCapacity.BIG);
        gaz.addDriver(new DriverD("Сятчихин Роман Петрович", "D", 2, gaz));
        gaz.addMechanic(maksim);
        gaz.addSponsor(gazprom,rosneft);
        Bus maz = new Bus("MAZ", "232", 3.5, PassengerCapacity.ESPECIALLY_SMALL);
        maz.addDriver(new DriverD("Сятчихин Олег Петрович", "D", 4, maz));
        Bus setra = new Bus("Setra", "Provate", 3.8, PassengerCapacity.ESPECIALLY_BIG);
        setra.addDriver(new DriverD("Сятчихин Николай Петрович", "D", 4, setra));
        man.printBus();
        gaz.printBus();
        maz.printBus();
        setra.printBus();


        Truck iveco = new Truck("Iveco", "MP 260E38 6x6", 12.0, CarriageCapacity.N3);
        iveco.addDriver(new DriverC("Нешатаев Роман Анатольевич", "C", 2, iveco));
        iveco.addMechanic(aleksei);
        iveco.addSponsor(rosneft);
        Truck mon = new Truck("MON", "41.410 8x4", 10.0, CarriageCapacity.N2);
        mon.addDriver(new DriverC("Измайлов Максим Андреевич", "C", 12, mon));
        Truck volvo = new Truck("VOLVO", "FMX-500-10X4", 13.0, CarriageCapacity.N1);
        volvo.addDriver(new DriverC("Сидоров Николай Иванович", "C", 15, volvo));
        volvo.addMechanic(aleksei);
        volvo.addSponsor(gazprom,vtb,rosneft);
        Truck mercedes = new Truck("Mercedes-Benz", "Atego 815", 4.2, CarriageCapacity.N2);
        mercedes.addDriver(new DriverC("Калыгин Герман Иванович", "C", 8, mercedes));
        iveco.printTruck();
        mon.printTruck();
        volvo.printTruck();
        mercedes.printTruck();
        mercedes.printType();


        Set<Transport> transports = Set.of(
                lada, kia,
                man, gaz,
                iveco,volvo);


        ServiceStation serviceStation = new ServiceStation();
        serviceStation.addCar(lada);
        serviceStation.addCar(audi);
        serviceStation.addTruck(iveco);
        serviceStation.service();
        serviceStation.service();
        serviceStation.service();

        for (Transport transport : transports) {
            printInfo(transport);
        }
    }

    private static void printInfo(Transport transport) {
        System.out.println("Информация по автомобилю: " + transport.getBrand() + " " + transport.getModel());
        System.out.println("Водители: ");
        for (Driver<?> driver : transport.getDrivers()) {
            System.out.println(driver.getFullName());
        }
        System.out.println("Механик: " + transport.getMechanics());
        System.out.println("Спонсоры: " + transport.getSponsors());
        System.out.println();
    }

    private static void service(Transport...transports) {
        for (Transport transport : transports) {
            serviceTransport(transport);
        }
    }

    private static void serviceTransport(Transport transport) {
        try {
            if (!transport.service()) {
                throw new RuntimeException("Автомобиль " +
                        transport.getBrand() + " " + transport.getModel() + " не прошел диагностику");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());

        }
    }


}