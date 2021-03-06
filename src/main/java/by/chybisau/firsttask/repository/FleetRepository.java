package by.chybisau.firsttask.repository;

import by.chybisau.firsttask.entity.FlyingMashine;
import by.chybisau.firsttask.logic.filter.FlyingMashinesSpecification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Maksim Chybisau
 * 04.05.2019
 * @project Aircompany3
 */
public class FleetRepository implements Repository<FlyingMashine> {

    private List<FlyingMashine> flyingMashines;

    public FleetRepository() {
        this.flyingMashines = new ArrayList<>();
    }

    public List<FlyingMashine> getFlyingMashines() {
        return flyingMashines;
    }

    public void setFlyingMashines(List<FlyingMashine> flyingMashines) {
        this.flyingMashines = flyingMashines;
    }

    @Override
    public boolean add(FlyingMashine flyingMashine) {
        return flyingMashines.add(flyingMashine);
    }

    @Override
    public boolean remove(FlyingMashinesSpecification<FlyingMashine> specification) {
        return flyingMashines.removeIf(specification);
    }

    @Override
    public boolean remove(FlyingMashine flyingMashine) {
        return flyingMashines.remove(flyingMashine);
    }

    @Override
    public Optional<FlyingMashine> update(FlyingMashine flyingMashineForUpdate, long id) {
        FlyingMashine resultFlyingTransport = null;
        if (flyingMashines.get((int) id).getFlyingMashineId() == flyingMashineForUpdate.getFlyingMashineId()) {
            resultFlyingTransport = flyingMashines.get((int) id);
            flyingMashines.set((int) id, flyingMashineForUpdate);
        }
        return Optional.ofNullable(resultFlyingTransport);
    }

    @Override
    public List<FlyingMashine> query(FlyingMashinesSpecification<FlyingMashine> specification) {
        return flyingMashines.stream().filter(specification).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (FlyingMashine fm : flyingMashines) {
            sb.append(fm).append("\n");
        }
        return sb.toString();
    }

    public FlyingMashine get(int a) {
        return flyingMashines.get(a);
    }

    public void clear() {
        flyingMashines.clear();
    }

}
