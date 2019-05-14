package by.chybisau.firsttask.logic.sorter;

import by.chybisau.firsttask.entity.FlyingMashine;

import java.util.Comparator;
import java.util.List;

/**
 * @author Maksim Chybisau
 * 03.05.2019
 * @project Aircompany3
 */
public class CruisingSpeedComparator implements Comparator<FlyingMashine> {

    @Override
    public int compare(FlyingMashine o1, FlyingMashine o2) {
        return (int) (o1.getCruisingSpeed() - o2.getCruisingSpeed());
    }

    public List<FlyingMashine> getAscendingOrderOfCruisingSpeed(List<FlyingMashine> flyingMashines) {
        flyingMashines.sort(new CruisingSpeedComparator());
        return flyingMashines;
    }

    public List<FlyingMashine> getDescendingOrderOfCruisingSpeed(List<FlyingMashine> flyingMashines) {
        flyingMashines.sort(new CruisingSpeedComparator().reversed());
        return flyingMashines;
    }

}
