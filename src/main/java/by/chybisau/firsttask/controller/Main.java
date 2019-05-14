package by.chybisau.firsttask.controller;

import by.chybisau.firsttask.entity.FlyingMashine;
import by.chybisau.firsttask.entity.Plane;
import by.chybisau.firsttask.entity.PlaneProducer;
import by.chybisau.firsttask.logic.filter.FuelConsumptionFilter;
import by.chybisau.firsttask.logic.filter.PlaneProducerFilter;
import by.chybisau.firsttask.logic.finder.FlightRangeFinder;
import by.chybisau.firsttask.logic.finder.capacityfinder.CargoCapacityFinder;
import by.chybisau.firsttask.receiver.DataReceiver;
import by.chybisau.firsttask.factory.FlyingMachinesFactory;
import by.chybisau.firsttask.exception.CustomException;
import by.chybisau.firsttask.repository.FleetRepository;
import by.chybisau.firsttask.validator.StringValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

/**
 * Created by Maksim Chybisau on 02/05/19.
 *
 * @version 0.0.2
 */

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws IOException, CustomException {

        FleetRepository fleet = new FleetRepository();
        try {
            logger.debug("Logic part");
            FlyingMachinesFactory flyingMachinesFactory = new FlyingMachinesFactory();
            for (String flyingMachinesFromFile : DataReceiver.obtainData("data/FlyingMachines.txt")) {
                if (StringValidator.validate(flyingMachinesFromFile)) {
                    fleet.add(flyingMachinesFactory.create(flyingMachinesFromFile));
                }
            }
            List<FlyingMashine> flyingMashines = fleet.getFlyingMashines();
            FuelConsumptionFilter fcf = new FuelConsumptionFilter(1200, 3000);
            for (FlyingMashine fm : flyingMashines) {
                System.out.println(fm);
            }
            PlaneProducerFilter ppf = new PlaneProducerFilter(PlaneProducer.BOEING);
            List<FlyingMashine> flyingMashines2 = fleet.getFlyingMashines();
            for (FlyingMashine fm : flyingMashines2) {
                if (ppf.test((Plane) fm)) {
                    System.out.println(fm);
                }
            }
            System.out.println(new FlightRangeFinder().getAverageFlightRange(fleet.getFlyingMashines()));
        } catch (CustomException e) {
            throw new CustomException("Error in creating flying machines. Reason: " + e.getMessage());
        }
    }
}


