package by.chybisau.firsttask.receiver;

import by.chybisau.firsttask.exception.CustomException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class DataReceiverTest {

    static final String PATH = "data/dataForTest.txt";
    List<String> expectedList = new ArrayList<>();

    @Test
    public void testObtainData() {
        String stringOne = "passangerPlane, 8400, 850, 2800, BOEING, 737-500, 240";
        String stringTwo = "passangerPlane,   6850,    830,    2700,   AIRBUS,    A320neo,   330";
        String stringThree = "cargoPlane, 5425, 853, 12600, AN, 124, 120000";
        expectedList.add(stringOne);
        expectedList.add(stringTwo);
        expectedList.add(stringThree);
        try {
            List actualList =DataReceiver.obtainData(PATH);
            assertEquals(actualList, expectedList);
        } catch (CustomException | IOException e) {
            e.printStackTrace();
        }
    }
}