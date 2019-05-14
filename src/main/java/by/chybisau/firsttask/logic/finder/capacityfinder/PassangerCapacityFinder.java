package by.chybisau.firsttask.logic.finder.capacityfinder;

import by.chybisau.firsttask.entity.PassangerPlane;
import by.chybisau.firsttask.entity.Plane;
import by.chybisau.firsttask.logic.sorter.PassangerCapacityComparator;

import java.util.Collections;
import java.util.List;
/**
 * Created by Maksim Chybisau on 06/05/19.
 * @version 0.0.1
 */
public class PassangerCapacityFinder {

//    public double calculateTotalPassangerCapacity(List<PassangerPlane> passangerPlanes) {
//        double result = 0;
//        for (PassangerPlane passangerPlane : passangerPlanes) {
//            result += passangerPlane.getPassangerCapacity();
//        }
//        return result;
//    }

     double calculateTotalPassangerCapacity(List<PassangerPlane> passangerPlanes) {
       return passangerPlanes.stream().mapToDouble(PassangerPlane::getPassangerCapacity).sum();
    }

    public Plane getMaxPassangerCapacityPlane(List<PassangerPlane> passangerPlanes) {
        return Collections.max(passangerPlanes, new PassangerCapacityComparator());
    }

    public Plane getMinPassangerCapacityPlane(List<PassangerPlane> passangerPlanes) {
        return Collections.min(passangerPlanes, new PassangerCapacityComparator());
    }
}
