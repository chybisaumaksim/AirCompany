package by.chybisau.firsttask.creator;

import by.chybisau.firsttask.entity.CargoPlane;
import by.chybisau.firsttask.entity.FlyingMashine;
import by.chybisau.firsttask.entity.PlaneProducer;
import by.chybisau.firsttask.util.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Maksim Chybisau
 * 04.05.2019
 * @project Aircompany3
 */
public class CargoPlaneCreator implements Creator {

    private static final Logger logger = LogManager.getLogger();

    public FlyingMashine create(String datesOfFlyingMachine) {
        CargoPlane cargoPlane = new CargoPlane();
        if (datesOfFlyingMachine != null) {
            int count = 0;
            logger.debug("Creating cargo plane");
            String[] date = datesOfFlyingMachine.split(", ");
            cargoPlane.setFlyingMashineId(IdGenerator.generateId());
            cargoPlane.setFlightRange(Double.parseDouble(date[++count]));
            cargoPlane.setCruisingSpeed(Double.parseDouble(date[++count]));
            cargoPlane.setFuelConsumption(Double.parseDouble(date[++count]));
            cargoPlane.setProducer(PlaneProducer.valueOf(date[++count].toUpperCase().trim()));
            cargoPlane.setModel(date[++count].trim());
            cargoPlane.setCargoCapacity(Double.parseDouble(date[++count]));
        }
        return cargoPlane;
    }
}

