package by.chybisau.firsttask.logic.sorter;

import by.chybisau.firsttask.entity.FlyingMashine;
import by.chybisau.firsttask.InitialDataForTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class FuelConsumptionComparatorTest extends InitialDataForTest {

    FuelConsumptionComparator sorter = new FuelConsumptionComparator();
    List<FlyingMashine> expected = new ArrayList<>();

    @Test(dataProvider = "compareData")
    public void testCompare(FlyingMashine flyingMashine, FlyingMashine flyingMashine2, double expected) {
        double actual = sorter.compare(flyingMashine, flyingMashine2);
        assertEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown() {
        expected.clear();
    }

    @Test
    public void testSortFuelConsumptionOfPlanes() {
        expected.add(flyingMashineList.get(3));
        expected.add(flyingMashineList.get(2));
        expected.add(flyingMashineList.get(4));
        expected.add(flyingMashineList.get(0));
        expected.add(flyingMashineList.get(1));
        List<FlyingMashine> copiedList = new ArrayList<>();
        copiedList.addAll(flyingMashineList);
        List<FlyingMashine> actual = sorter.sortFuelConsumptionOfPlanes(copiedList);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "compareData")
    public Object[][] dataProvider() {
        return new Object[][]{
                {flyingMashineList.get(0), flyingMashineList.get(1), -3300},
                {flyingMashineList.get(2), flyingMashineList.get(1), -13100},
        };
    }
}