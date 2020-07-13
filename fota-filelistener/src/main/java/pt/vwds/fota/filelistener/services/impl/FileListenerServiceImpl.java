package pt.vwds.fota.filelistener.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pt.vwds.fota.filelistener.services.FileListenerService;

@Slf4j
@Service
public class FileListenerServiceImpl implements FileListenerService {

    @Override
    public void handleFile(String folderPath, String filename) {
        log.info("Path: " + folderPath + ". File: " + filename);

        if (filename.startsWith("hard")) {
            log.info("I'm hardware!");
        } else if (filename.startsWith("soft")) {
            log.info("I'm software!");
        } else {
            log.info("I'm garbage!");
        }

    }

}
