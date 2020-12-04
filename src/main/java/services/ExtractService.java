package services;

import enums.InstanceRegistryHandler;
import enums.EStatus;
import abstractions.Handler;
import models.CommandHandler;
import models.CommandResult;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Optional;

public class ExtractService<T> implements IExtract<T> {
    private final Handler<T> handler;

    public ExtractService(Handler<T> handler) {
        this.handler = handler;
    }

    @Override
    public CommandResult<T> loadDataFromFile(String path) {
        CommandResult<T> result = new CommandResult<>();
        int cont = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            if (!handler.getRegistries().isEmpty())
                handler.resetRecords();

            String lineArchive;

            while ((lineArchive = reader.readLine()) != null) {

                String finalLineArchive = lineArchive;

                Optional<CommandHandler> command = handler.getCommands().stream()
                        .filter(cm -> cm.getCheckLineData().test(finalLineArchive)).findFirst();

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
        result.setData(handler.getRegistries());
        return result;
    }

    private void runCommand(CommandResult<T> result, int cont, String lineArchive, CommandHandler command) {
        try {
            if (command.getRegistryType() == InstanceRegistryHandler.CREATE_NEW_REGISTRY_INSTANCE) {
                handler.setRegistry(handler::newInstance);
                handler.addRecord();
            }
            command.getFillObject().accept(lineArchive);
        } catch (Exception ex) {
            result.getResult().getAlerts().add("Error to get line: " + cont + " - " + lineArchive + "Error: " + ex.getMessage());
        }
    }

    private void setExtractionStatus(CommandResult<T> result) {
        if (!result.getResult().getErrors().isEmpty() || !result.getResult().getAlerts().isEmpty()) {
            if (!result.getResult().getErrors().isEmpty() || (result.getResult().getAlerts().isEmpty())) {
                result.getResult().setStatus(EStatus.ERROR);
                result.getResult().setReadingDone(false);
            } else {
                result.getResult().setStatus(EStatus.ALERTS);
                result.getResult().setReadingDone(true);
                result.getResult().getInformation().add("File read with alerts");
            }
        } else {
            result.getResult().setStatus(EStatus.SUCCESS);
            result.getResult().setReadingDone(true);
            result.getResult().getInformation().add("File read with success");
        }
    }
}
