package by.chybisau.firsttask.logic.filter;

import by.chybisau.firsttask.entity.FlyingMashine;
import by.chybisau.firsttask.entity.PassangerPlane;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static by.chybisau.firsttask.entity.PlaneProducer.BOEING;

public class CruisingSpeedFilterTest {
    FlyingMashinesSpecification<FlyingMashine> filter;

    @Test(dataProvider = "cruisingSpeedFilterData")
    public void testTest(FlyingMashine flyingMashine, double cruisingSpeed, boolean expected) {
        filter = new CruisingSpeedFilter(cruisingSpeed);
        boolean actual = filter.test(flyingMashine);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "cruisingSpeedFilterData")
    public Object[][] dataProvider() {
        PassangerPlane passangerPlane = new PassangerPlane(8400, 850, 2800, BOEING, "737 - 500", 240);
        return new Object[][]{
                {passangerPlane, 910, false},
                {passangerPlane, 852, false},
                {passangerPlane, 800, true},
                {passangerPlane, 850, true}
        };
    }
}