package Tests.Service;

import Enums.ERegistryType;
import Abstractions.Handler;
import FileModels.BankDataFile;

public class BankDataHandler extends Handler<BankDataFile> {


    @Override
    public void setBuildingFile() {

        addCommand(this::isClientRegistry, this::fillClient, ERegistryType.MainObject);
        addCommand(this::isFinancialRegistry, this::fillFinancialRegistry);
        addCommand(this::isDocumentRegistry, this::fillDocumentRegistry);

    }

    @Override
    public BankDataFile newInstance() {
        return new BankDataFile();
    }

    private boolean isClientRegistry(String line) {
        return line.startsWith("00");
    }

    private void fillClient(String line) {
        currentRegistry.fillData(line);
    }

    private boolean isFinancialRegistry(String line) {
        return line.startsWith("02");
    }

    private void fillFinancialRegistry(String line) {
        currentRegistry.addFinancialData(line);
    }

    private boolean isDocumentRegistry(String line) {
        return line.startsWith("01");
    }

    private void fillDocumentRegistry(String line) {
        currentRegistry.getDocument().fillData(line);
    }
}
