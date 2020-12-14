package tests;

import enums.StatusImport;
import repository.ExtractRepository;
import services.Extractable;
import models.CommandResult;
import services.ExtractService;
import filemodels.BankDataFile;
import org.junit.Test;


import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class SampleTest {

    public SampleTest() {
        service = new ExtractService<>(new BankDataFileHandler());
    }

    private final String path = new File("src/test/resources").getAbsolutePath() + "\\";
    private final Extractable<BankDataFile> service;

    @Test
    public void ShouldExtractAllRecords() throws IOException {
        CommandResult<BankDataFile> result = service.loadDataFromFile(path + "Success.txt");
        assertNotNull(result);
        assertTrue(result.getIsReadingDone());
        assertEquals(StatusImport.SUCCESS, result.getStatus());
    }

    @Test
    public void ShouldExtractAllRecordsWithAlerts() throws IOException {
        CommandResult<BankDataFile> result = service.loadDataFromFile(path + "Alerts.txt");
        assertNotNull(result);
        assertTrue(result.getIsReadingDone());
        assertFalse(result.getMessages().isEmpty());
        assertEquals(StatusImport.ALERTS, result.getStatus());
    }
}
