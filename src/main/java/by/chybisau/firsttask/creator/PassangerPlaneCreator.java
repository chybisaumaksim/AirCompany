package by.chybisau.firsttask.creator;

import by.chybisau.firsttask.entity.FlyingMashine;
import by.chybisau.firsttask.entity.PassangerPlane;
import by.chybisau.firsttask.entity.PlaneProducer;
import by.chybisau.firsttask.util.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Maksim Chybisau
 * 04.05.2019
 * @project Aircompany3
 */
public class PassangerPlaneCreator implements Creator {

    private static final Logger logger = LogManager.getLogger();

    public FlyingMashine create(String datesOfFlyingMachine) {
        logger.debug("Creating passanger plane");
        PassangerPlane passangerPlane = new PassangerPlane();
        if (datesOfFlyingMachine != null) {
            logger.debug("Creating cargo plane");
            int count = 0;
            String[] date = datesOfFlyingMachine.split(",");
            passangerPlane.setFlyingMashineId(IdGenerator.generateId());
            passangerPlane.setFlightRange(Double.parseDouble(date[++count].trim()));
            passangerPlane.setCruisingSpeed(Double.parseDouble(date[++count].trim()));
            passangerPlane.setFuelConsumption(Double.parseDouble(date[++count].trim()));
            passangerPlane.setProducer(PlaneProducer.valueOf(date[++count].toUpperCase().trim()));
            passangerPlane.setModel(date[++count].trim());
            passangerPlane.setPassangerCapacity(Double.parseDouble(date[++count].trim()));
        }
        return passangerPlane;
    }
}
