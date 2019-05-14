package by.chybisau.firsttask.validator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringValidatorTest {

    @Test(dataProvider = "compareData")
    public void testValidate(String flyingMashineData, boolean expected) {
        boolean actual = StringValidator.validate(flyingMashineData);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "compareData")
    public Object[][] dataProvider() {
        String flyingMashineOne = "passangerPlane, 8400, 850, 2800, BOEING, 737-600, 250";
        String flyingMashineTwo = "passangerPlane, 5648, 852, 2700, BOEING, 737-700, 126";
        String flyingMashineThree = "passangerPlane, 852, 2700, BOEING, 737-700, 126";
        String flyingMashineFour = "PaSsAnGerPlAnE, 8400, 852, 2700, BoeiNG, 456-96f, 126";
        String flyingMashineFive = "paSsAnGerPlaNe,  5648,  852,  2700,  Boeing,  737-700,   126";
        String flyingMashineSix = "CargoPlanE,   5425,   853,   12600,   AN,  124,   120000";
        return new Object[][]{
                {flyingMashineOne, true},
                {flyingMashineTwo, true},
                {flyingMashineThree, false},
                {flyingMashineFour, true},
                {flyingMashineFive, true},
                {flyingMashineSix, true},
        };
    }
}