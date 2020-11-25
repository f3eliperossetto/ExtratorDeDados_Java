package Tests.Service;

import Enums.ERegistryType;
import Abstractions.Handler;
import FileModels.BankDataFile;

public class BankDataHandler extends Handler<BankDataFile> {


    @Override
    public void setBuildingFile() {

        addCommand(this::ehTipoRegistroCliente,this::PopulaCliente, ERegistryType.MainObject);
        addCommand(this::ehTipoRegistroFinanceito,this::PopulaFinanceiro);
        addCommand(this::ehTipoRegistroDocumento,this::PopulaDocumento);

    }

    @Override
    public BankDataFile newInstance() {
        return new BankDataFile();
    }

    private boolean ehTipoRegistroCliente(String linhaArquivo){
        return linhaArquivo.startsWith("00");
    }

    private void PopulaCliente(String linha){
        currentRegistry.fillData(linha);
    }

    private boolean ehTipoRegistroFinanceito(String linhaArquivo){
        return linhaArquivo.startsWith("02");
    }

    private void PopulaFinanceiro(String linha){
       currentRegistry.addFinancialData(linha);
    }

    private boolean ehTipoRegistroDocumento(String linhaArquivo){
        return linhaArquivo.startsWith("01");
    }

    private void PopulaDocumento(String linha){
        currentRegistry.getDocument().fillData(linha);
    }
}
