package by.chybisau.firsttask.logic.finder.capacityfinder;

import by.chybisau.firsttask.entity.CargoPlane;
import by.chybisau.firsttask.entity.Plane;
import by.chybisau.firsttask.logic.sorter.CargoCapacityAndCruisingSpeedComparator;

import java.util.Collections;
import java.util.List;
/**
 * Created by Maksim Chybisau on 06/05/19.
 * @version 0.0.1
 */
public class CargoCapacityFinder {

//    public double calculateTotalCargoCapacity(List<CargoPlane> cargoPlanes) {
//        double result = 0;
//        for (CargoPlane cargoPlane : cargoPlanes) {
//            result += cargoPlane.getCargoCapacity();
//        }
//        return result;
//    }

    public double calculateTotalCargoCapacity(List<CargoPlane> cargoplanes) {
        return cargoplanes.stream().mapToDouble(CargoPlane::getCargoCapacity).sum();
    }

    public Plane getMaxCargoCapacityPlane(List<CargoPlane> cargoplanes) {
        return Collections.max(cargoplanes, new CargoCapacityAndCruisingSpeedComparator());
    }

    public Plane getMinCargoCapacityPlane(List<CargoPlane> cargoplanes) {
        return Collections.min(cargoplanes, new CargoCapacityAndCruisingSpeedComparator());
    }


}
