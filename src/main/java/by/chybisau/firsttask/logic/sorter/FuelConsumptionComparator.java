package by.chybisau.firsttask.logic.sorter;

import by.chybisau.firsttask.entity.FlyingMashine;

import java.util.Comparator;
import java.util.List;

/**
 * @author Maksim Chybisau
 * 03.05.2019
 * @project Aircompany3
 */
public class FuelConsumptionComparator implements Comparator<FlyingMashine> {
    @Override
    public int compare(FlyingMashine o1, FlyingMashine o2) {
        return (int) (o1.getFuelConsumption() - o2.getFuelConsumption());
    }

    public List<FlyingMashine> sortFuelConsumptionOfPlanes(List<FlyingMashine> flyingMashines) {
        flyingMashines.sort(new FuelConsumptionComparator());
        return flyingMashines;
    }
}
