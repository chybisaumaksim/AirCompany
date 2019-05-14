package by.chybisau.firsttask.logic.sorter;

import by.chybisau.firsttask.entity.CargoPlane;

import java.util.Comparator;
import java.util.List;

/**
 * @author Maksim Chybisau
 * 03.05.2019
 * @project Aircompany3
 */
public class CargoCapacityAndCruisingSpeedComparator implements Comparator<CargoPlane> {

    @Override
    public int compare(CargoPlane o1, CargoPlane o2) {
        return (int) (o1.getCargoCapacity() - o2.getCargoCapacity());
    }

    public List<CargoPlane> getAscendingOrderOfCargoCapacity(List<CargoPlane> cargoPlanes) {
        cargoPlanes.sort(new CargoCapacityAndCruisingSpeedComparator());
        return cargoPlanes;
    }

    public Comparator<CargoPlane> thenComparing() {
        return thenComparing(CargoPlane::getCruisingSpeed);
    }
}
