package by.chybisau.firsttask.creator;

import by.chybisau.firsttask.InitialDataForTest;
import by.chybisau.firsttask.entity.FlyingMashine;
import by.chybisau.firsttask.entity.PassangerPlane;
import by.chybisau.firsttask.exception.CustomException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PassangerPlaneCreatorTest extends InitialDataForTest {

    public PassangerPlaneCreatorTest() {
        super();
    }

    Creator creator = new PassangerPlaneCreator();

    @Test(dataProvider = "data")
    public void testCreate(FlyingMashine flyingMashine, String data, boolean expected) {
        FlyingMashine createdMashine = creator.create(data);
        boolean actual = createdMashine.equals(flyingMashine);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataTwo")
    public void testCreateTwo(String data, boolean expected) {
        boolean actual = true;
        try {
            creator.create(data);
        } catch (Exception e) {
            actual = false;
        }
        assertEquals(actual, expected);
    }

    @DataProvider(name = "data")
    public Object[][] dataProvider() {
        FlyingMashine planeOne = flyingMashineList.get(2);
        FlyingMashine planetwo = flyingMashineList.get(3);
        FlyingMashine planeThree = flyingMashineList.get(4);
        FlyingMashine plane = new PassangerPlane();
        FlyingMashine planeTwo = flyingMashineList.get(2);
        String flyingMashineOne = null;
        String flyingMashineTwo = "passangerPlane, 8400, 850, 2800, BOEING, 737-500, 240";
        String flyingMashineThree = "passangerPlane, 4400, 910, 2600, BOEING, 737-300, 277";
        String flyingMashineFour = "passangerPlane, 8400, 850, 2800, BOEING, 737-500, 240";
        String flyingMashineFive = "passangerPlane, 4400, 910, 2600, BOEING, 737500, 277";
        return new Object[][]{
                {planeOne, flyingMashineTwo, true},
                {planeThree, flyingMashineThree, false},
                {plane, flyingMashineOne, true},
                {planeTwo, flyingMashineFour, true},
                {planeTwo, flyingMashineFive, false},
        };
    }

    @DataProvider(name = "dataTwo")
    public Object[][] dataProviderTwo() {
        String flyingMashineOne = "passangerPlane, 8400km, 850, 2800, BOEING, 737-500, 240";
        String flyingMashineTwo = "passangerPlane, 4400, 910, 2600, BOEING747, 737500, 277";
        String flyingMashineThree = "passangerPlane, 4400, 910, 2600, BOEING, 737-300, 277 passangers";
        return new Object[][]{
                {flyingMashineOne, false},
                {flyingMashineTwo, false},
                {flyingMashineThree, false},
        };
    }
}