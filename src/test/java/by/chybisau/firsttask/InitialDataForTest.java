package by.chybisau.firsttask;

import by.chybisau.firsttask.entity.CargoPlane;
import by.chybisau.firsttask.entity.FlyingMashine;
import by.chybisau.firsttask.entity.PassangerPlane;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

import static by.chybisau.firsttask.entity.PlaneProducer.*;

public class InitialDataForTest {
    public List<FlyingMashine> flyingMashineList;
    public List<FlyingMashine> flyingMashineList2;
    public List<CargoPlane> cargoPlanesList;
    public List<PassangerPlane> passangerPlanesList;

    @BeforeClass
    public void setUp() {
        CargoPlane flyingMashine = new CargoPlane(5425, 853, 12_600, AN, "124", 120_000);
        CargoPlane flyingMashine2 = new CargoPlane(15_400, 800, 15_900, AN, "225", 250_000);
        PassangerPlane flyingMashine3 = new PassangerPlane(8400, 850, 2800, BOEING, "737-500", 240);
        PassangerPlane flyingMashine4 = new PassangerPlane(4400, 910, 2600, BOEING, "737500", 277);
        CargoPlane flyingMashine5 = new CargoPlane(8_800, 760, 7_200, AN, "127", 140_000);
        flyingMashineList = new ArrayList<>();
        flyingMashineList2 = new ArrayList<>();
        cargoPlanesList = new ArrayList<>();
        passangerPlanesList = new ArrayList<>();

        flyingMashineList.add(flyingMashine);
        flyingMashineList.add(flyingMashine2);
        flyingMashineList.add(flyingMashine3);
        flyingMashineList.add(flyingMashine4);
        flyingMashineList.add(flyingMashine5);

        flyingMashineList2.add(flyingMashine3);
        flyingMashineList2.add(flyingMashine4);
        flyingMashineList2.add(flyingMashine5);

        cargoPlanesList.add(flyingMashine);
        cargoPlanesList.add(flyingMashine2);
        cargoPlanesList.add(flyingMashine5);

        passangerPlanesList.add(flyingMashine3);
        passangerPlanesList.add(flyingMashine4);
    }

    @AfterClass
    public void tearDown() {
        flyingMashineList = null;
        flyingMashineList2 = null;
        cargoPlanesList = null;
        passangerPlanesList = null;
    }

    public List<FlyingMashine> getFlyingMashineList() {
        return flyingMashineList;
    }
}
