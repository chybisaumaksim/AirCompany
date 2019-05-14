package by.chybisau.firsttask.logic.filter;

import by.chybisau.firsttask.entity.Plane;
import by.chybisau.firsttask.entity.PlaneProducer;

public class PlaneProducerFilter implements FlyingMashinesSpecification<Plane> {

    PlaneProducer producer;

    public PlaneProducerFilter(PlaneProducer producer) {
        this.producer = producer;
    }

    @Override
    public boolean test(Plane plane) {
        return plane.getProducer().equals(producer);
    }
}
