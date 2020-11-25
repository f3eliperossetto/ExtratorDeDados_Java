package Tests.Service;

import Services.IExtract;
import Models.CommandResult;
import Services.ExtractService;
import FileModels.BankDataFile;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class Tests {
    public Tests() {
        service = new ExtractService<>(new BankDataHandler());
    }

    private String path = new File("src/test/resources").getAbsolutePath() + "\\";
    private final IExtract<BankDataFile> service;

    @Test
    public void ShouldExtractAllRecords() {
        CommandResult<BankDataFile> result = service.loadDataFromFile(path + "Success.txt");
        assertNotNull(result);
        assertEquals(4, result.getData().size());
        assertEquals(0, result.getResult().getAlerts().size());
        assertEquals(0, result.getResult().getErrors().size());
        assertEquals(1, (result.getResult().getInformation().size()));
    }

}
