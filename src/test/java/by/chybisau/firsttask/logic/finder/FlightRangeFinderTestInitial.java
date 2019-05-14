package by.chybisau.firsttask.logic.finder;

import by.chybisau.firsttask.entity.FlyingMashine;
import by.chybisau.firsttask.InitialDataForTest;
import by.chybisau.firsttask.logic.sorter.FlightRangeComparator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static org.testng.Assert.*;

public class FlightRangeFinderTestInitial extends InitialDataForTest {

    FlightRangeFinder finder = new FlightRangeFinder();
    FlightRangeComparator comparator = new FlightRangeComparator();

    @Test(dataProvider = "averageFlightRangeData")
    public void testGetAverageFlightRange(List<FlyingMashine> planeList, double expected) {
        double actual = finder.getAverageFlightRange(planeList);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "maxFlightRangeData")
    public void testGetMaxFlightRange(List<FlyingMashine> planeList, FlyingMashine flyingMashine) {
        Optional<FlyingMashine> actual = finder.getMaxFlightRange(planeList, comparator);
        Optional<FlyingMashine> expected = Optional.ofNullable(flyingMashine);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "minFlightRangeData")
    public void testGetMinFlightRange(List<FlyingMashine> planeList, FlyingMashine flyingMashine) {
        Optional<FlyingMashine> actual = finder.getMinFlightRange(planeList, comparator);
        Optional<FlyingMashine> expected = Optional.ofNullable(flyingMashine);
        assertEquals(actual, expected);

    }

    @DataProvider(name = "averageFlightRangeData")
    public Object[][] dataProvider() {
        return new Object[][]{
                {flyingMashineList, 8485.0},
                {flyingMashineList2, 7200},
        };
    }

    @DataProvider(name = "maxFlightRangeData")
    public Object[][] dataProviderTwo() {
        return new Object[][]{
                {flyingMashineList, flyingMashineList.get(1)},
                {flyingMashineList2, flyingMashineList2.get(2)},
        };
    }

    @DataProvider(name = "minFlightRangeData")
    public Object[][] dataProviderThree() {
        return new Object[][]{
                {flyingMashineList, flyingMashineList.get(3)},
                {flyingMashineList2, flyingMashineList2.get(1)},
        };
    }
}