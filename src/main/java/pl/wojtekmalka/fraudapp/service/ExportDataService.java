package pl.wojtekmalka.fraudapp.service;

import java.io.FileNotFoundException;

public interface ExportDataService {
    void createExportFile() throws FileNotFoundException;
}
