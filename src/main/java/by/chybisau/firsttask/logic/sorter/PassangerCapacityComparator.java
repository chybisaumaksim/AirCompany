package by.chybisau.firsttask.logic.sorter;

import by.chybisau.firsttask.entity.PassangerPlane;

import java.util.Comparator;
import java.util.List;

/**
 * @author Maksim Chybisau
 * 03.05.2019
 * @project Aircompany3
 */
public class PassangerCapacityComparator implements Comparator<PassangerPlane> {


    @Override
    public int compare(PassangerPlane o1, PassangerPlane o2) {
        return (int) (o1.getPassangerCapacity() - o2.getPassangerCapacity());
    }

    public List<PassangerPlane> sortPassangerCapacityOfPlanes(List<PassangerPlane> planes) {
        planes.sort(new PassangerCapacityComparator());
        return planes;
    }


}
