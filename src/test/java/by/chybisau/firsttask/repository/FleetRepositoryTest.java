package by.chybisau.firsttask.repository;

import by.chybisau.firsttask.entity.CargoPlane;
import by.chybisau.firsttask.entity.FlyingMashine;
import by.chybisau.firsttask.entity.PassangerPlane;
import by.chybisau.firsttask.logic.filter.CruisingSpeedFilter;
import by.chybisau.firsttask.logic.filter.FlyingMashinesSpecification;
import by.chybisau.firsttask.logic.filter.FuelConsumptionFilter;
import by.chybisau.firsttask.logic.filter.PlaneProducerFilter;
import by.chybisau.firsttask.util.IdGenerator;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static by.chybisau.firsttask.entity.PlaneProducer.AN;
import static by.chybisau.firsttask.entity.PlaneProducer.BOEING;
import static org.testng.Assert.*;

public class FleetRepositoryTest {
    private FleetRepository fleetRepository;
    private FlyingMashine flyingMashine;
    private FlyingMashine flyingMashine2;
    private FlyingMashine flyingMashine3;


    @BeforeMethod
    public void setUp() {
        fleetRepository = new FleetRepository();
        flyingMashine = new CargoPlane(IdGenerator.generateId(), 5425, 853, 12_600, AN, "124", 120_000);
        flyingMashine2 = new PassangerPlane(IdGenerator.generateId(), 8400, 850, 2800, BOEING, "737-500", 240);
        flyingMashine3 = new CargoPlane(IdGenerator.generateId(), 8_800, 760, 7_200, AN, "127", 140_000);
        fleetRepository.add(flyingMashine);
        fleetRepository.add(flyingMashine2);
        fleetRepository.add(flyingMashine3);
        for (int i = 0; i < 3; i++) {
            System.out.println(fleetRepository.get(i));
        }
    }

    @AfterMethod
    public void tearDown() {
        fleetRepository.clear();
    }

    @Test(dataProvider = "dataForAddAndDelete")
    public void testAdd(FlyingMashine flyingMashine) {
        boolean actual = fleetRepository.add(flyingMashine);
        assertTrue(actual);
    }

    @Test(dataProvider = "deleteSpecificationsData")
    public void testRemove(FlyingMashinesSpecification specification) {
        boolean actual = fleetRepository.remove(specification);
        assertTrue(actual);
    }

    @Test(dataProvider = "dataForAddAndDelete")
    public void testRemoveTwo(FlyingMashine flyingMashine) {
        boolean actual = fleetRepository.remove(flyingMashine);
        assertTrue(actual);
    }

    @Test
    public void testUpdate(){
        flyingMashine = new CargoPlane(1, 5425, 853, 12_600, AN, "124", 120_000);
        flyingMashine2 = new PassangerPlane(2, 8400, 850, 2800, BOEING, "737-500", 240);
        Optional<FlyingMashine> actual = fleetRepository.update(flyingMashine);
        Optional<FlyingMashine> expected = Optional.of(flyingMashine2);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "queryData")
    public void testQuery(FlyingMashinesSpecification specification, List actual) {
        List expected = fleetRepository.query(specification);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForAddAndDelete")
    public Object[][] dataProvider() {
        return new Object[][]{
                {flyingMashine},
                {flyingMashine2},
                {flyingMashine3}
        };
    }

    @DataProvider(name = "deleteSpecificationsData")
    public Object[][] dataProviderTwo() {
        CruisingSpeedFilter specification1 = new CruisingSpeedFilter(850);
        FuelConsumptionFilter specification2 = new FuelConsumptionFilter(2000, 2900);
        PlaneProducerFilter specification3 = new PlaneProducerFilter(BOEING);
        return new Object[][]{
                {specification1},
                {specification2},
                {specification3}
        };
    }

    @DataProvider(name = "queryData")
    public Object[][] dataProviderThree() {
        List<FlyingMashine> actual1 = new ArrayList<>();
        List<FlyingMashine> actual2 = new ArrayList<>();
        List<FlyingMashine> actual3 = new ArrayList<>();
        CruisingSpeedFilter specification1 = new CruisingSpeedFilter(850);
        FuelConsumptionFilter specification2 = new FuelConsumptionFilter(2000, 2900);
        PlaneProducerFilter specification3 = new PlaneProducerFilter(AN);
        actual1.add(flyingMashine);
        actual1.add(flyingMashine2);
        actual2.add(flyingMashine2);
        actual3.add(flyingMashine);
        actual3.add(flyingMashine3);
        return new Object[][]{
                {specification1, actual1},
                {specification2, actual2},
                {specification3, actual3}
        };
    }
}