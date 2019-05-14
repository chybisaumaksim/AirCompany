package by.chybisau.firsttask.factory;

import by.chybisau.firsttask.creator.CargoPlaneCreator;
import by.chybisau.firsttask.creator.Creator;
import by.chybisau.firsttask.creator.PassangerPlaneCreator;
import by.chybisau.firsttask.entity.FlyingMashine;
import by.chybisau.firsttask.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Maksim Chybisau on 02/05/19.
 * @version 0.0.2
 */
public class FlyingMachinesFactory {

    private static final Logger logger = LogManager.getLogger();

    public FlyingMashine create(String datesOfFlyingMachine) throws CustomException {
        Creator creator;
        String flyingMashine = datesOfFlyingMachine.split(",")[0].toUpperCase().trim();
        switch (flyingMashine) {
            case "PASSANGERPLANE":
                creator = new PassangerPlaneCreator();
                break;
            case "CARGOPLANE":
                creator = new CargoPlaneCreator();
                break;
            default:
                logger.error("Error in creation flying machines. Mismatch dates from file");
                throw new CustomException("Flying machine creating error");
        }
        return creator.create(datesOfFlyingMachine);
    }
}





