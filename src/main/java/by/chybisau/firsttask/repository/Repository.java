package by.chybisau.firsttask.repository;

import by.chybisau.firsttask.entity.FlyingMashine;
import by.chybisau.firsttask.logic.filter.FlyingMashinesSpecification;

import java.util.List;
import java.util.Optional;

/**
 * @author Maksim Chybisau
 * 04.05.2019
 * @project Aircompany3
 */
public interface Repository<T> {
    boolean add(T t);
    boolean remove(T t);
    boolean remove(FlyingMashinesSpecification<T> specification);
    Optional<T> update(FlyingMashine flyingMashineForUpdate, long id);
    List<T> query(FlyingMashinesSpecification<T> specification);
}
