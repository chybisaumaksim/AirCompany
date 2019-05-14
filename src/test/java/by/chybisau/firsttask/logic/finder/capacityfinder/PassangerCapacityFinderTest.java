package by.chybisau.firsttask.logic.finder.capacityfinder;

import by.chybisau.firsttask.entity.PassangerPlane;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static by.chybisau.firsttask.entity.PlaneProducer.*;
import static org.testng.Assert.assertEquals;

public class PassangerCapacityFinderTest {

    List<PassangerPlane> passangerPlaneList;
    List<PassangerPlane> passangerPlaneList2;
    PassangerPlane passangerPlane;
    PassangerPlane passangerPlane2;
    PassangerPlane passangerPlane3;
    PassangerCapacityFinder finder;

    @BeforeClass
    public void setUp() {
        passangerPlane = new PassangerPlane(8400, 850, 2800, BOEING, "737-500", 240);
        passangerPlane2 = new PassangerPlane(5800, 855, 2700, BOEING, "737-900", 250);
        passangerPlane3 = new PassangerPlane(6850, 830, 2500, AIRBUS, "A320neoNew", 330);
        finder = new PassangerCapacityFinder();
        passangerPlaneList = new ArrayList<>();
        passangerPlaneList2 = new ArrayList<>();
        passangerPlaneList.add(passangerPlane);
        passangerPlaneList.add(passangerPlane2);
        passangerPlaneList.add(passangerPlane3);
        passangerPlaneList2.add(passangerPlane2);
        passangerPlaneList2.add(passangerPlane3);
    }

    @Test(dataProvider = "totalPassangerCapacityFinderData")
    public void testCalculateTotalPassangerCapacity(List<PassangerPlane> planeList, double expected) {
        double actual = finder.calculateTotalPassangerCapacity(planeList);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "maxPassangerCapacityFinderData")
    public void testGetMaxPassangerCapacityPlane(List<PassangerPlane> planeList, PassangerPlane expected) {
        PassangerPlane actual = (PassangerPlane) finder.getMaxPassangerCapacityPlane(planeList);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "minPassangerCapacityFinderData")
    public void testGetMinPassangerCapacityPlane(List<PassangerPlane> planeList, PassangerPlane expected) {
        PassangerPlane actual = (PassangerPlane) finder.getMinPassangerCapacityPlane(planeList);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "totalPassangerCapacityFinderData")
    public Object[][] dataProvider() {
        return new Object[][]{
                {passangerPlaneList, 820},
                {passangerPlaneList2, 580},
        };
    }

    @DataProvider(name = "maxPassangerCapacityFinderData")
    public Object[][] dataProviderTwo() {
        return new Object[][]{
                {passangerPlaneList, passangerPlane3},
                {passangerPlaneList2, passangerPlane3},
        };
    }

    @DataProvider(name = "minPassangerCapacityFinderData")
    public Object[][] dataProviderThree() {
        return new Object[][]{
                {passangerPlaneList, passangerPlane},
                {passangerPlaneList2, passangerPlane2},
        };
    }
}