package by.chybisau.firsttask.entity;

import java.util.Objects;

/**
 * Created by Maksim Chybisau on 02/05/19.
 * @version 0.0.2
 */
public abstract class FlyingMashine {

    private long flyingMashineId;
    private double flightRange;
    private double cruisingSpeed;
    private double fuelConsumption;

    public FlyingMashine(long flyingMashineId, double flightRange, double cruisingSpeed,
                         double fuelConsumption) {
       this.flyingMashineId=flyingMashineId;
        this.flightRange = flightRange;
        this.cruisingSpeed = cruisingSpeed;
        this.fuelConsumption = fuelConsumption;
    }

    public FlyingMashine( double flightRange, double cruisingSpeed, double fuelConsumption) {
        this.flightRange = flightRange;
        this.cruisingSpeed = cruisingSpeed;
        this.fuelConsumption = fuelConsumption;
    }

    public FlyingMashine() {
    }

    public long getFlyingMashineId() {
        return flyingMashineId;
    }

    public void setFlyingMashineId(long flyingMashineId) {
        this.flyingMashineId = flyingMashineId;
    }

    public double getFlightRange() {
        return flightRange;
    }

    public void setFlightRange(double flightRange) {
        this.flightRange = flightRange;
    }

    public double getCruisingSpeed() {
        return cruisingSpeed;
    }

    public void setCruisingSpeed(double cruisingSpeed) {
        this.cruisingSpeed = cruisingSpeed;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlyingMashine that = (FlyingMashine) o;
        return  Double.compare(that.flightRange, flightRange) == 0 &&
                Double.compare(that.cruisingSpeed, cruisingSpeed) == 0 &&
                Double.compare(that.fuelConsumption, fuelConsumption) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightRange, cruisingSpeed, fuelConsumption);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=").append(flyingMashineId);
        sb.append(", flightRange=").append(flightRange).append(" km ");
        sb.append(", cruisingSpeed=").append(cruisingSpeed).append(" km/h ");
        sb.append(", fuelConsumption=").append(fuelConsumption).append(" l ");
        return sb.toString();
    }
}
