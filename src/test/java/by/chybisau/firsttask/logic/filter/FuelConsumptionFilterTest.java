package by.chybisau.firsttask.logic.filter;

import by.chybisau.firsttask.entity.FlyingMashine;
import by.chybisau.firsttask.entity.PassangerPlane;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static by.chybisau.firsttask.entity.PlaneProducer.*;

public class FuelConsumptionFilterTest {
    FlyingMashinesSpecification<FlyingMashine> filter;

    @Test(dataProvider = "dataForTests")
    public void testTest(FlyingMashine flyingMashine, double minFuelConsumprion, double maxFuelConsumprion, boolean expected) {
        filter = new FuelConsumptionFilter(minFuelConsumprion, maxFuelConsumprion);
        boolean actual = filter.test(flyingMashine);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForTests")
    public Object[][] dataProvider() {
        PassangerPlane passangerPlane = new PassangerPlane (8400, 850,2800, BOEING, "737-500", 240);
        PassangerPlane passangerPlane2 = new PassangerPlane(5800,855,2700, BOEING, "737-900", 240);
        PassangerPlane passangerPlane3 = new PassangerPlane(6850,830,2500, AIRBUS, "A320neoNew", 330);
        return new Object[][]{
                {passangerPlane, 2500, 2650, false},
                {passangerPlane2, 2750, 2900, false},
                {passangerPlane3, 2400, 2600, true},
        };
    }
}