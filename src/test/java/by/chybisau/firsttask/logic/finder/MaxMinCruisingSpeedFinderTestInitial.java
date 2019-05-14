package by.chybisau.firsttask.logic.finder;

import by.chybisau.firsttask.entity.FlyingMashine;
import by.chybisau.firsttask.InitialDataForTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class MaxMinCruisingSpeedFinderTestInitial extends InitialDataForTest {

    MaxMinCruisingSpeedFinder finder = new MaxMinCruisingSpeedFinder();

    @Test(dataProvider = "maxCruisingSpeedData")
    public void testGetMaxCruisingSpeed(List<FlyingMashine> planeList, FlyingMashine expected) {
        FlyingMashine actual = finder.getMaxCruisingSpeed(planeList);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "minCruisingSpeedData")
    public void testGetMinCruisingSpeed(List<FlyingMashine> planeList, FlyingMashine expected) {
        FlyingMashine actual = finder.getMinCruisingSpeed(planeList);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "maxCruisingSpeedData")
    public Object[][] dataProviderTwo() {
        return new Object[][]{
                {flyingMashineList, flyingMashineList.get(3)},
                {flyingMashineList2, flyingMashineList2.get(1)},
        };
    }

    @DataProvider(name = "minCruisingSpeedData")
    public Object[][] dataProviderThree() {
        return new Object[][]{
                {flyingMashineList, flyingMashineList.get(4)},
                {flyingMashineList2,flyingMashineList2.get(2)},
        };
    }
}