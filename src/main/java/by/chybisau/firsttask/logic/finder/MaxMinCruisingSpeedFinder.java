package by.chybisau.firsttask.logic.finder;

import by.chybisau.firsttask.entity.FlyingMashine;
import by.chybisau.firsttask.logic.sorter.CruisingSpeedComparator;

import java.util.Collections;
import java.util.List;

/**
 * Created by Maksim Chybisau on 06/05/19.
 * @version 0.0.1
 */
public class MaxMinCruisingSpeedFinder {

    public FlyingMashine getMaxCruisingSpeed(List<FlyingMashine> flyingMashines) {
        return Collections.max(flyingMashines, new CruisingSpeedComparator());
    }

    public FlyingMashine getMinCruisingSpeed(List<FlyingMashine> flyingMashines) {
        return Collections.min(flyingMashines, new CruisingSpeedComparator());
    }
}