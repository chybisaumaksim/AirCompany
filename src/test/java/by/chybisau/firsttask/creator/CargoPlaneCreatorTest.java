package by.chybisau.firsttask.creator;

import by.chybisau.firsttask.entity.FlyingMashine;
import by.chybisau.firsttask.InitialDataForTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CargoPlaneCreatorTest extends InitialDataForTest {

    public CargoPlaneCreatorTest() {
        super();
    }
    Creator creator =new CargoPlaneCreator();

    @Test(dataProvider = "data")
    public void testCreate(FlyingMashine flyingMashine, String data, boolean expected) {
        FlyingMashine createdMashine = creator.create(data);
        boolean actual=createdMashine.equals(flyingMashine);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "data")
    public Object[][] dataProvider() {
        FlyingMashine planeOne=flyingMashineList.get(0);
        FlyingMashine planetwo=flyingMashineList.get(1);
        FlyingMashine planeThree=flyingMashineList.get(3);

        String flyingMashineOne = "cargoPlane,   5425,   853,   12600,   AN,  124,   120000";
        String flyingMashineTwo = "cargoPlane, 15400, 800, 15900, AN, 225, 250000";
        String flyingMashineThree = "passangerPlane, 4400, 910, 2600, BOEING, 737, 300, 277";
        return new Object[][]{
                {planeOne, flyingMashineOne, true},
                {planetwo, flyingMashineTwo, true},
                {planeThree, flyingMashineThree, false},
        };
    }
}