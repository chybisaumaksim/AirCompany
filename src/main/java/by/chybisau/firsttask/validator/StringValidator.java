package by.chybisau.firsttask.validator;

import java.util.regex.Pattern;

/**
 * @author Maksim Chybisau
 * 04.05.2019
 * @project Aircompany3
 */
public class StringValidator {

    private static final String REGEX_FOR_NUMBER = "([\\d ]+)";
    private static final String REGEX_FOR_PLANE = "([\\w ]+)";
    private static final String REGEX_FOR_MODEL = "([\\w- ]+)";
    private static final String REGEX_FOR_PRODUCER = "+(BOEING|AIRBUS|AN)";
    private static final String COMMA = ", ";

    public static boolean validate(String stringOfDates) {
        return Pattern.matches(REGEX_FOR_PLANE + COMMA
                + REGEX_FOR_NUMBER + COMMA
                + REGEX_FOR_NUMBER + COMMA
                + REGEX_FOR_NUMBER + COMMA
                + REGEX_FOR_PRODUCER + COMMA
                + REGEX_FOR_MODEL + COMMA
                + REGEX_FOR_NUMBER, stringOfDates.toUpperCase());
    }
}
