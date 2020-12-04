package services;

import abstractions.DataFileHandler;
import enums.InstanceRegistryHandler;
import enums.StatusImport;
import models.CommandHandler;
import models.CommandResult;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Optional;

public class ExtractService<T> implements Extractable<T> {
    private final DataFileHandler<T> dataFileHandler;

    public ExtractService(DataFileHandler<T> dataFileHandler) {
        this.dataFileHandler = dataFileHandler;
    }

    @Override
    public CommandResult<T> loadDataFromFile(String path) {
        CommandResult<T> result = new CommandResult<>();
        int cont = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            if (!dataFileHandler.getAll().isEmpty())
                dataFileHandler.dispose();


            String lineArchive;

            while ((lineArchive = reader.readLine()) != null) {

                String finalLineArchive = lineArchive;

                Optional<CommandHandler> command = dataFileHandler.getCommands().stream()
                        .filter(cm -> cm.getCheckLineData().invoke(finalLineArchive)).findFirst();

                if (command.isPresent())
                    runCommand(result, cont, lineArchive, command.get());
                else
                    result.getResult().getAlerts().add("Line " + cont + " - " + lineArchive + ", not mapped to an entity");

                cont++;
            }
        } catch (Exception ex) {
            result.getResult().getErrors().add("Line " + cont + ex.getMessage());
        }
        setExtractionStatus(result);
        result.setData(dataFileHandler.getAll());
        return result;
    }

    private void runCommand(CommandResult<T> result, int cont, String lineArchive, CommandHandler command) {
        try {
            if (command.getInstanceRegistryHandler() == InstanceRegistryHandler.CREATE_NEW_REGISTRY_INSTANCE) {
                dataFileHandler.set(dataFileHandler::getNewInstance);
                dataFileHandler.add();
            }
            command.getFillObject().invoke(lineArchive);
        } catch (Exception ex) {
            result.getResult().getAlerts().add("Error to get line: " + cont + " - " + lineArchive + "Error: " + ex.getMessage());
        }
    }

    private void setExtractionStatus(CommandResult<T> result) {
        if (!result.getResult().getErrors().isEmpty() || !result.getResult().getAlerts().isEmpty()) {
            if (!result.getResult().getErrors().isEmpty() || (result.getResult().getAlerts().isEmpty())) {
                result.getResult().setStatus(StatusImport.ERROR);
                result.getResult().setReadingDone(false);
            } else {
                result.getResult().setStatus(StatusImport.ALERTS);
                result.getResult().setReadingDone(true);
                result.getResult().getInformation().add("File read with alerts");
            }
        } else {
            result.getResult().setStatus(StatusImport.SUCCESS);
            result.getResult().setReadingDone(true);
            result.getResult().getInformation().add("File read with success");
        }
    }
}
