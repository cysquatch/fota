package pt.vwds.fota.filelistener.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import pt.vwds.fota.filelistener.model.ProcessedCsv;
import pt.vwds.fota.filelistener.services.FileListenerService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Slf4j
@Service
public class FileListenerServiceImpl implements FileListenerService {

    @Override
    public void handleFile(String folderPath, String filename) {
        log.info("Path: " + folderPath + ". File: " + filename);



        if (filename.startsWith("hard") && filename.endsWith(".csv")) {
            log.info("I'm hardware!");
        } else if (filename.startsWith("soft") && filename.endsWith(".csv")) {
            log.info("I'm software!");
        } else {
            log.info("I'm garbage!");
        }
    }

    private ProcessedCsv scanCsv(String path) {
        ProcessedCsv processedCsv = new ProcessedCsv();
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                processedCsv.add(parseLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return processedCsv;
    }

    private Pair<String, String> parseLine(String line) {
        Pair<String, String> pairVinComponent;
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            pairVinComponent = Pair.of(rowScanner.next(), rowScanner.next());
        }
        return pairVinComponent;
    }

}
