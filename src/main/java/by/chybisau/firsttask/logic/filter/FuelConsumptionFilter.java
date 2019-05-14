package by.chybisau.firsttask.logic.filter;

import by.chybisau.firsttask.entity.FlyingMashine;

public class FuelConsumptionFilter implements FlyingMashinesSpecification<FlyingMashine> {

    double minRangeFuelConsumption;
    double maxRangeFuelConsumption;

    public FuelConsumptionFilter(double minRangeFuelConsumption, double maxRangeFuelConsumption) {
        this.minRangeFuelConsumption = minRangeFuelConsumption;
        this.maxRangeFuelConsumption = maxRangeFuelConsumption;
    }

    @Override
    public boolean test(FlyingMashine flyingMashine) {
        return flyingMashine.getFuelConsumption() >= minRangeFuelConsumption
                && flyingMashine.getFuelConsumption() <= maxRangeFuelConsumption;
    }
}
