package Tests.Service;

import enums.StatusImport;
import services.Extractable;
import models.CommandResult;
import services.ExtractService;
import FileModels.BankDataFile;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class Tests {
    public Tests() {
        service = new ExtractService<>(new BankCommandHandler());
    }

    private final String path = new File("src/test/resources").getAbsolutePath() + "\\";
    private final Extractable<BankDataFile> service;

    @Test
    public void ShouldExtractAllRecords() {
        CommandResult<BankDataFile> result = service.loadDataFromFile(path + "Success.txt");
        assertNotNull(result);
        assertTrue(result.getResult().getIsReadingDone());
        assertEquals(4, result.getData().size());
        assertEquals(0, result.getResult().getAlerts().size());
        assertEquals(0, result.getResult().getErrors().size());
        assertEquals(1, (result.getResult().getInformation().size()));
        assertEquals(StatusImport.SUCCESS,result.getResult().getStatus());
    }

}
