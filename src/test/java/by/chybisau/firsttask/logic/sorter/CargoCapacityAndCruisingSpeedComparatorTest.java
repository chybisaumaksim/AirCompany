package by.chybisau.firsttask.logic.sorter;

import by.chybisau.firsttask.entity.CargoPlane;
import by.chybisau.firsttask.entity.FlyingMashine;
import by.chybisau.firsttask.InitialDataForTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static by.chybisau.firsttask.entity.PlaneProducer.*;
import static org.testng.Assert.*;

public class CargoCapacityAndCruisingSpeedComparatorTest extends InitialDataForTest {

    CargoCapacityAndCruisingSpeedComparator sorter = new CargoCapacityAndCruisingSpeedComparator();
    List<CargoPlane> expected = new ArrayList<>();


    @Test(dataProvider = "compareData")
    public void testCompare(FlyingMashine flyingMashine, FlyingMashine flyingMashine2, double expected) {
        double actual = sorter.compare((CargoPlane) flyingMashine, (CargoPlane) flyingMashine2);
        assertEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown() {
        expected.clear();
    }

    @Test
    public void testGetAscendingOrderOfCargoCapacity() {
        expected.add(cargoPlanesList.get(0));
        expected.add(cargoPlanesList.get(2));
        expected.add(cargoPlanesList.get(1));
        List<CargoPlane> copiedList = new ArrayList<>(cargoPlanesList);
        List<CargoPlane> actual = sorter.getAscendingOrderOfCargoCapacity(copiedList);
        assertEquals(actual, expected);
    }

    @Test
    public void testThenComparing() {
        cargoPlanesList.add(new CargoPlane(5425, 860, 12_600, AN, "124", 120_000));
        expected.add(cargoPlanesList.get(0));
        expected.add(new CargoPlane(5425, 860, 12_600, AN, "124", 120_000));
        expected.add(cargoPlanesList.get(2));
        expected.add(cargoPlanesList.get(1));
        List<CargoPlane> copiedListTwo = new ArrayList<>(cargoPlanesList);
        List<CargoPlane> actual = sorter.getAscendingOrderOfCargoCapacity(copiedListTwo);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "compareData")
    public Object[][] dataProviderThree() {
        return new Object[][]{
                {cargoPlanesList.get(0), cargoPlanesList.get(1), -130_000},
                {cargoPlanesList.get(1), cargoPlanesList.get(0), 130_000},
        };
    }
}