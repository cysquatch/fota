package pt.vwds.fota.filelistener.services;

public interface FileListenerService {
    void handleFile(String folderPath, String filename);
}
