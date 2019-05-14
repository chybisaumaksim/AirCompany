//package by.chybisau.firsttask.logic.filter;
//
//import by.chybisau.firsttask.entity.FlyingMashine;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * Created by Maksim Chybisau on 08/05/19.
// * @version 0.0.1
// */
//public abstract class CruisingSpeedFilter2Realization implements Specification2<FlyingMashine> {
//
//    double cruisingSpeed;
//
//    public CruisingSpeedFilter2Realization(double cruisingSpeed) {
//        this.cruisingSpeed = cruisingSpeed;
//    }
//
//    @Override
//    public List<FlyingMashine> test(List<FlyingMashine> flyingMashines) {
//        return flyingMashines.stream().filter(flyingMashine -> flyingMashine.getCruisingSpeed() >= cruisingSpeed).
//                collect(Collectors.toList());
//    }
//}
