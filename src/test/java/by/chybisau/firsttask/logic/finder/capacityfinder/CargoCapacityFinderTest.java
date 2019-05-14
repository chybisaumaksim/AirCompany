package by.chybisau.firsttask.logic.finder.capacityfinder;

import by.chybisau.firsttask.entity.CargoPlane;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static by.chybisau.firsttask.entity.PlaneProducer.*;
import static org.testng.Assert.*;
public class CargoCapacityFinderTest {

    List<CargoPlane> cargoPlaneList;
    List<CargoPlane> cargoPlaneList2;
    CargoPlane cargoPlane;
    CargoPlane cargoPlane2;
    CargoPlane cargoPlane3;
    CargoCapacityFinder finder;

    @BeforeClass
    public void setUp() {
        finder = new CargoCapacityFinder();
        cargoPlane = new CargoPlane(5425, 853, 12_600, AN, "124", 120_000);
        cargoPlane2 = new CargoPlane(15_400, 800, 15_900, AN, "225", 250_000);
        cargoPlane3 = new CargoPlane(8_800, 760, 7_200, AN, "127", 140_000);
        cargoPlaneList = new ArrayList<>();
        cargoPlaneList2 = new ArrayList<>();
        cargoPlaneList.add(cargoPlane);
        cargoPlaneList.add(cargoPlane2);
        cargoPlaneList.add(cargoPlane3);
        cargoPlaneList2.add(cargoPlane2);
        cargoPlaneList2.add(cargoPlane3);
    }

    @Test(dataProvider = "totalCargoCapacityFinderData")
    public void testCalculateTotalCargoCapacity(List<CargoPlane> planeList, double expected) {
        double actual = finder.calculateTotalCargoCapacity(planeList);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "maxCargoCapacityFinderData")
    public void testGetMaxCargoCapacityPlane(List<CargoPlane> planeList, CargoPlane expected) {
        CargoPlane actual = (CargoPlane) finder.getMaxCargoCapacityPlane(planeList);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "minCargoCapacityFinderData")
    public void testGetMinCargoCapacityPlane(List<CargoPlane> planeList, CargoPlane expected) {
        CargoPlane actual = (CargoPlane) finder.getMinCargoCapacityPlane(planeList);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "totalCargoCapacityFinderData")
    public Object[][] dataProvider() {
        return new Object[][]{
                {cargoPlaneList, 510_000},
                {cargoPlaneList2, 390_000},
        };
    }

    @DataProvider(name = "maxCargoCapacityFinderData")
    public Object[][] dataProviderTwo() {
        return new Object[][]{
                {cargoPlaneList, cargoPlane2},
                {cargoPlaneList2, cargoPlane2},
        };
    }

    @DataProvider(name = "minCargoCapacityFinderData")
    public Object[][] dataProviderThree() {
        return new Object[][]{
                {cargoPlaneList, cargoPlane},
                {cargoPlaneList2, cargoPlane3},
        };
    }
}