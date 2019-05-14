package by.chybisau.firsttask.logic.finder;

import by.chybisau.firsttask.entity.FlyingMashine;
import by.chybisau.firsttask.logic.sorter.FlightRangeComparator;

import java.util.List;
import java.util.Optional;

/**
 * Created by Maksim Chybisau on 06/05/19.
 * @version 0.0.1
 */
public class FlightRangeFinder {

    /**
     * with stream realization
     */
    public double getAverageFlightRange(List<FlyingMashine> flyingMashines) {
        return flyingMashines.stream().mapToDouble(FlyingMashine::getFlightRange).average().orElse(-1);
    }

    public Optional<FlyingMashine> getMaxFlightRange(List<FlyingMashine> flyingMashines, FlightRangeComparator comparator) {
        return flyingMashines.stream().max(comparator);
    }

    public Optional<FlyingMashine> getMinFlightRange(List<FlyingMashine> flyingMashines, FlightRangeComparator comparator) {
        return flyingMashines.stream().min(comparator);
    }
}
