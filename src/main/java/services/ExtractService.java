package services;

import abstractions.CommandHandler;
import enums.InstanceRegistryHandler;
import enums.StatusImport;
import factories.FactoryRepository;
import models.CommandHandlerModel;
import models.CommandResult;
import repository.Repository;

import java.io.IOException;
import java.util.Optional;

public class ExtractService<T> implements Extractable<T> {
    private final CommandHandler<T> commandHandler;
    private final Repository repository;

    public ExtractService(CommandHandler<T> commandHandler) {
        this.commandHandler = commandHandler;
        this.repository = FactoryRepository.buildRepository();
    }

    @Override
    public CommandResult<T> loadDataFromFile(String filePath) throws IOException {
        CommandResult<T> result = new CommandResult<>();
        int cont = 0;
        try (commandHandler) {

            for (String line : repository.readAll(filePath)) {

                Optional<CommandHandlerModel> command = commandHandler.getCommands().stream()
                        .filter(cm -> cm.getCheckLineData().invoke(line)).findFirst();

                if (command.isPresent()) {
                    runCommand(result, cont, line, command.get());
                } else {
                    result.getMessages().add("Line " + cont + " not mapped to an entity, check if you set the command on package abstractions.buildCommands ");
                    result.setStatus(StatusImport.ALERTS);
                }
                cont++;
            }

            result.setData(commandHandler.getAll());
        }

        return result;
    }

    private void runCommand(CommandResult<T> result, int cont, String lineArchive, CommandHandlerModel command) {
        try {
            if (command.getInstanceRegistryHandler() == InstanceRegistryHandler.CREATE_NEW_REGISTRY_INSTANCE) {
                commandHandler.set(commandHandler::getNewInstance);
                commandHandler.add();
            }
            command.getFillObject().invoke(lineArchive);
        } catch (Exception ex) {
            result.setStatus(StatusImport.ALERTS);
            result.getMessages().add("Error to get line: " + cont + " - " + lineArchive + " - " + "Error: " + ex.getMessage());
        }
    }

}
