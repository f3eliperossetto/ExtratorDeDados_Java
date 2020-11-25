package Services;

import Enums.ERegistryType;
import Enums.EStatus;
import Abstractions.Handler;
import Models.CommandHandler;
import Models.CommandResult;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Optional;

public class ExtractService<TFileRegistry> implements IExtract<TFileRegistry> {
    private final Handler<TFileRegistry> _handler;

    public ExtractService(Handler<TFileRegistry> handler) {
        _handler = handler;
    }

    @Override
    public CommandResult<TFileRegistry> loadDataFromFile(String path) {
        CommandResult<TFileRegistry> result = new CommandResult<>();
        int cont = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            if (_handler.getRegistry().size() > 0)
                _handler.resetRecords();

            String lineArchive;

            while ((lineArchive = reader.readLine()) != null) {
                String finalLineArchive = lineArchive;
                Optional<CommandHandler> command = _handler.getCommands().stream()
                        .filter(cm -> cm.getCheckLineData().test(finalLineArchive)).findFirst();

                if (command.isPresent()) {
                    try {
                        if (command.get().getRegistryType() == ERegistryType.MainObject) {
                            _handler.setCurrentRegistry(_handler.newInstance());
                            _handler.addRecord();
                        }
                        command.get().getFillObject().accept(lineArchive);
                    } catch (Exception ex) {
                        result.getResult().getAlerts().add("Error to get line: " + cont + " - " + lineArchive + "Error: " + ex.getMessage());
                    }
                } else {
                    result.getResult().getAlerts().add("Line " + cont + " - " + lineArchive + ", not mapped to an entity");
                }
                cont++;
            }
        } catch (Exception ex) {
            result.getResult().getErrors().add("Line " + cont + ex.getMessage());
        }
        setExtractionStatus(result);
        result.setData(_handler.getRegistry());
        return result;
    }

    private void setExtractionStatus(CommandResult<TFileRegistry> result) {
        if (!(result.getResult().getErrors().size() > 0) && !(result.getResult().getAlerts().size() > 0)) {
            result.getResult().setStatus(EStatus.Success);
            result.getResult().setReadingDone(true);
            result.getResult().getInformation().add("File read with success");
        } else if (!(result.getResult().getErrors().size() > 0) && (result.getResult().getAlerts().size() > 0)) {
            result.getResult().setStatus(EStatus.Alerts);
            result.getResult().setReadingDone(true);
            result.getResult().getInformation().add("File read with alerts");
        } else {
            result.getResult().setStatus(EStatus.Error);
            result.getResult().setReadingDone(false);
        }
    }
}
