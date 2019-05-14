package by.chybisau.firsttask.logic.filter;

import by.chybisau.firsttask.entity.FlyingMashine;
import by.chybisau.firsttask.entity.PassangerPlane;
import by.chybisau.firsttask.entity.PlaneProducer;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static by.chybisau.firsttask.entity.PlaneProducer.AIRBUS;
import static by.chybisau.firsttask.entity.PlaneProducer.BOEING;

public class PlaneProducerFilterTest {

    @Test(dataProvider = "planeProducerFilterData")
    public void testTest(FlyingMashine flyingMashine, PlaneProducer planeProducer, boolean expected) {
        FlyingMashinesSpecification filter = new PlaneProducerFilter(planeProducer);
        boolean actual = filter.test(flyingMashine);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "planeProducerFilterData")
    public Object[][] dataProvider() {
        PassangerPlane passangerPlane = new PassangerPlane(8400, 850, 2800, BOEING, "737-500", 240);
        PassangerPlane passangerPlane2 = new PassangerPlane(6850,830,2700, AIRBUS, "A320neo", 330);
        return new Object[][]{
                {passangerPlane, BOEING, true},
                {passangerPlane, AIRBUS, false},
                {passangerPlane2, BOEING, false},
        };
    }
}