package by.chybisau.firsttask.receiver;

import by.chybisau.firsttask.entity.FlyingMashine;
import by.chybisau.firsttask.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Maksim Chybisau on 02/05/19.
 *
 * @version 0.0.2
 */

public class DataReceiver {

    private static final Logger logger = LogManager.getLogger();

    public static List<String> obtainData(String path) throws CustomException, IOException {
        logger.debug("Getting dates from file");
        File f = new File(path);
        if (path == null || !f.exists()) {
            throw new CustomException("File with input dates not found");
        }
        return Files.lines(Paths.get(path)).collect(Collectors.toList());
    }
}

