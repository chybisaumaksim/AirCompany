package by.chybisau.firsttask.logic.sorter;

import by.chybisau.firsttask.entity.PassangerPlane;
import by.chybisau.firsttask.InitialDataForTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class PassangerCapacityComparatorTest extends InitialDataForTest {

    PassangerCapacityComparator sorter = new PassangerCapacityComparator();
    List<PassangerPlane> expected = new ArrayList<>();

    @Test(dataProvider = "compareData")
    public void testCompare(PassangerPlane flyingMashine, PassangerPlane flyingMashine2, double expected) {
        double actual = sorter.compare(flyingMashine, flyingMashine2);
        assertEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown() {
        expected.clear();
    }

    @Test
    public void testSortPassangerCapacityOfPlanes() {
        expected.add(passangerPlanesList.get(0));
        expected.add(passangerPlanesList.get(1));
        List<PassangerPlane> copiedList = new ArrayList<>(passangerPlanesList);
        List<PassangerPlane> actual = sorter.sortPassangerCapacityOfPlanes(copiedList);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "compareData")
    public Object[][] dataProvider() {
        return new Object[][]{
                {passangerPlanesList.get(0), passangerPlanesList.get(1), -37},
                {passangerPlanesList.get(1), passangerPlanesList.get(0), 37},
        };
    }
}