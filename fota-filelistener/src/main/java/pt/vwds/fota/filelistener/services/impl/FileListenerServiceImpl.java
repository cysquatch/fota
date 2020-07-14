package pt.vwds.fota.filelistener.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import pt.vwds.fota.core.model.HardwareComponent;
import pt.vwds.fota.core.model.SoftwareComponent;
import pt.vwds.fota.core.services.VehicleService;
import pt.vwds.fota.filelistener.model.ProcessedCsvConfiguration;
import pt.vwds.fota.filelistener.services.FileListenerService;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ref.SoftReference;
import java.util.*;

@Slf4j
@Service
public class FileListenerServiceImpl implements FileListenerService {

    private final VehicleService vehicleService;

    public FileListenerServiceImpl(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Override
    public void handleFile(String folderPath, String filename) {
        log.info("Path: " + folderPath + ". File: " + filename);

        if (filename.startsWith("hard") && filename.endsWith(".csv")) {
            log.info("New Hardware configuration found");
            log.info("Path: " + folderPath + ". File: " + filename);
            handleHardwareConfiguration(buildFullPath(folderPath, filename));

        } else if (filename.startsWith("soft") && filename.endsWith(".csv")) {
            log.info("New Software configuration found");
            log.info("Path: " + folderPath + ". File: " + filename);
            handleSoftwareConfiguration(buildFullPath(folderPath, filename));

        } else {
            log.info("I'm garbage!");


        }
    }

    private void handleHardwareConfiguration(String path) {
        ProcessedCsvConfiguration processedCsvConfiguration = scanCsv(path);
        processedCsvConfiguration.getVinToComponents()
                .forEach((vin, components) ->
                        vehicleService.addHardwareConfiguration(vin, HardwareComponent.convertStringsToHardwareComponents(components)));
    }

    private void handleSoftwareConfiguration(String path) {
        ProcessedCsvConfiguration processedCsvConfiguration = scanCsv(path);
        processedCsvConfiguration.getVinToComponents()
                .forEach((vin, components) ->
                        vehicleService.addSoftwareConfiguration(vin, SoftwareComponent.convertStringsToSoftwareComponents(components)));
    }

    private ProcessedCsvConfiguration scanCsv(String path) {
        ProcessedCsvConfiguration processedCsvConfiguration = new ProcessedCsvConfiguration();
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                processedCsvConfiguration.add(parseLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return processedCsvConfiguration;
    }

    private Pair<String, String> parseLine(String line) {
        Pair<String, String> pairVinComponent;
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            pairVinComponent = Pair.of(rowScanner.next(), rowScanner.next());
        }
        return pairVinComponent;
    }

    private String buildFullPath(String folderPath, String filename) {
        return folderPath + "\\" + filename;
    }

}
