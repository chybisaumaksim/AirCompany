package by.chybisau.firsttask.logic.filter;

import by.chybisau.firsttask.entity. FlyingMashine;

/**
 * Created by Maksim Chybisau on 03/05/19.
 *
 * @version 0.0.1
 */
public class CruisingSpeedFilter implements FlyingMashinesSpecification<FlyingMashine> {

    double cruisingSpeed;

    public CruisingSpeedFilter(double cruisingSpeed) {
        this.cruisingSpeed = cruisingSpeed;
    }

    @Override
    public boolean test(FlyingMashine flyingMashine) {
        return flyingMashine.getCruisingSpeed() >= cruisingSpeed;
    }
}