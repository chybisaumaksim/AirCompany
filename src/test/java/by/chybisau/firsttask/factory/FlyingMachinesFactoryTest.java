package by.chybisau.firsttask.factory;

import by.chybisau.firsttask.InitialDataForTest;
import by.chybisau.firsttask.entity.CargoPlane;
import by.chybisau.firsttask.entity.FlyingMashine;
import by.chybisau.firsttask.entity.PassangerPlane;
import by.chybisau.firsttask.exception.CustomException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static by.chybisau.firsttask.entity.PlaneProducer.AN;
import static by.chybisau.firsttask.entity.PlaneProducer.BOEING;
import static org.testng.Assert.*;

public class FlyingMachinesFactoryTest extends InitialDataForTest {
    FlyingMachinesFactory flyingMachinesFactory = new FlyingMachinesFactory();

    @Test(dataProvider = "data")
    public void testCreate(FlyingMashine flyingMashine, String data) {
        try {
            FlyingMashine expected = flyingMachinesFactory.create(data);
            assertEquals(flyingMashine, expected);
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

    @Test(dataProvider = "dataTwo")
    public void testCreateTwo(String data, boolean expected) {
        boolean actual = true;
        try {
            flyingMachinesFactory.create(data);
        } catch (CustomException e) {
            actual = false;
        }
        assertEquals(actual, expected);
    }

    @DataProvider(name = "data")
    public Object[][] dataProvider() {
        FlyingMashine planeOne = new PassangerPlane(8400, 850, 2800, BOEING, "737-500", 240);
        FlyingMashine planeTwo = new PassangerPlane(4400, 910, 2600, BOEING, "737-300", 277);
        FlyingMashine planeThree = new CargoPlane(5425, 853, 12600, AN, "124", 120000);
        FlyingMashine planeFour = new CargoPlane(15400, 800, 15900, AN, "225", 250000);

        String flyingMashineOne = "passangerPlane, 8400, 850, 2800, BOEING, 737-500, 240";
        String flyingMashineTwo = "passangerPlane, 4400, 910, 2600, BOEING, 737-300, 277";
        String flyingMashineThree = "cargoPlane,   5425,   853,   12600,   AN,  124,   120000";
        String flyingMashineFour = "cargoPlane, 15400, 800, 15900, AN, 225, 250000";

        return new Object[][]{
                {planeOne, flyingMashineOne},
                {planeTwo, flyingMashineTwo},
                {planeThree, flyingMashineThree},
                {planeFour, flyingMashineFour},
        };
    }

    @DataProvider(name = "dataTwo")
    public Object[][] dataProviderTwo() {

        String flyingMashineOne = "passangerPlane1, 8400, 850, 2800, BOEING, 737-500, 240";
        String flyingMashineTwo = "passanger Plane, 4400, 910, 2600, BOEING, 737-300, 277";
        String flyingMashineThree = "cargoPlaneAN,   5425,   853,   12600,   AN,  124,   120000";

        return new Object[][]{
                {flyingMashineOne, false},
                {flyingMashineTwo, false},
                {flyingMashineThree, false},
        };

    }
}