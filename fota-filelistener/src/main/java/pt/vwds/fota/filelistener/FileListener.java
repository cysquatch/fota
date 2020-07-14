package pt.vwds.fota.filelistener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import pt.vwds.fota.filelistener.services.FileListenerService;

import java.io.IOException;
import java.nio.file.*;

@Slf4j
@Component
public class FileListener implements ApplicationListener<ApplicationReadyEvent> {

    private final FileListenerService fileListenerService;

    public FileListener(FileListenerService fileListenerService) {
        this.fileListenerService = fileListenerService;
    }

    @Value("${targetFolder}")
    private String targetFolder;


    @Override
    public void onApplicationEvent(ApplicationReadyEvent e) {
        log.info("FileListener has started...");
        try {
            run();
        } catch (InterruptedException | IOException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    private void run() throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path = Paths.get(targetFolder);
        path.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE);
        WatchKey key;
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                fileListenerService.handleFile(path.toString(), event.context().toString());
            }
            key.reset();
        }
        watchService.close();
    }

}
