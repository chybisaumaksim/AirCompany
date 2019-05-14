package by.chybisau.firsttask.entity;

import java.util.Objects;

/**
 * Created by Maksim Chybisau on 02/05/19.
 *
 * @version 0.0.2
 */

public class Plane extends FlyingMashine {

    private PlaneProducer producer;
    private String model;

    public Plane(long flyingMashineId, double flightRange, double cruisingSpeed,
                 double fuelConsumption, PlaneProducer producer, String model) {
        super(flyingMashineId, flightRange, cruisingSpeed, fuelConsumption);
        this.producer = producer;
        this.model = model;
    }

    public Plane(double flightRange, double cruisingSpeed,
                 double fuelConsumption, PlaneProducer producer, String model) {
        super(flightRange, cruisingSpeed, fuelConsumption);
        this.producer = producer;
        this.model = model;
    }

    public Plane() {
    }

    public PlaneProducer getProducer() {
        return producer;
    }

    public void setProducer(PlaneProducer producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Plane plane = (Plane) o;
        return producer == plane.producer &&
                Objects.equals(model, plane.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), producer, model);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("producer=").append(producer);
        sb.append(", model='").append(model).append(", ");
        return sb.toString();
    }
}

