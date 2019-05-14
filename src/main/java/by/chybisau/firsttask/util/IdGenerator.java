package by.chybisau.firsttask.util;

public class IdGenerator {
    private static long id;

    public static long generateId() {
        return id+=1;
    }
}
