package by.chybisau.firsttask.logic.sorter;

import by.chybisau.firsttask.entity.FlyingMashine;
import by.chybisau.firsttask.InitialDataForTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CruisingSpeedComparatorTest extends InitialDataForTest {

    CruisingSpeedComparator sorter = new CruisingSpeedComparator();
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
    public void testGetAscendingOrderOfCruisingSpeed() {
        expected.add(flyingMashineList.get(4));
        expected.add(flyingMashineList.get(1));
        expected.add(flyingMashineList.get(2));
        expected.add(flyingMashineList.get(0));
        expected.add(flyingMashineList.get(3));
        List<FlyingMashine> copiedList = new ArrayList<>(flyingMashineList);
        List<FlyingMashine> actual = sorter.getAscendingOrderOfCruisingSpeed(copiedList);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetDescendingOrderOfCruisingSpeed() {
        expected.add(flyingMashineList.get(3));
        expected.add(flyingMashineList.get(0));
        expected.add(flyingMashineList.get(2));
        expected.add(flyingMashineList.get(1));
        expected.add(flyingMashineList.get(4));
        List<FlyingMashine> copiedListTwo = new ArrayList<>(flyingMashineList);
        List<FlyingMashine> actual = sorter.getDescendingOrderOfCruisingSpeed(copiedListTwo);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "compareData")
    public Object[][] dataProviderThree() {
        return new Object[][]{
                {flyingMashineList.get(0), flyingMashineList.get(1), 53},
                {flyingMashineList.get(2), flyingMashineList.get(1), 50},
        };
    }
}