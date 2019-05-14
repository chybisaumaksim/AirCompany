package by.chybisau.firsttask.logic.finder;

import by.chybisau.firsttask.entity.FlyingMashine;
import by.chybisau.firsttask.InitialDataForTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class MaxMinFuelConsumptionFinderTestInitial extends InitialDataForTest {

    MaxMinFuelConsumptionFinder finder = new MaxMinFuelConsumptionFinder();

    @Test(dataProvider = "maxFuelConsumptionData")
    public void getMaxFuelConsumption(List<FlyingMashine> planeList, FlyingMashine expected) {
        FlyingMashine actual = finder.getMaxFuelConsumption(planeList);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "minFuelConsumptionData")
    public void getMinFuelConsumption(List<FlyingMashine> planeList, FlyingMashine expected) {
        FlyingMashine actual = finder.getMinFuelConsumption(planeList);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "maxFuelConsumptionData")
    public Object[][] dataProviderTwo() {
        return new Object[][]{
                {flyingMashineList, flyingMashineList.get(1)},
                {flyingMashineList2, flyingMashineList2.get(2)},
        };
    }

    @DataProvider(name = "minFuelConsumptionData")
    public Object[][] dataProviderThree() {
        return new Object[][]{
                {flyingMashineList, flyingMashineList.get(3)},
                {flyingMashineList2,flyingMashineList2.get(1)},
        };
    }
}