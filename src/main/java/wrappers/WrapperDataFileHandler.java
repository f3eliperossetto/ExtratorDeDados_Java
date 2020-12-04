package wrappers;

import abstractions.DataFileHandler;
import delegators.Func;
import enums.InstanceRegistryHandler;
import models.CommandHandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public abstract class WrapperDataFileHandler<T> implements DataFileHandler<T> {

    protected T registry;
    private List<T> registries;
    private final List<CommandHandler> commands;

    @Override
    public List<T> getAll() {
        return registries;
    }

    @Override
    public Collection<CommandHandler> getCommands() {
        return commands;
    }

    @Override
    public void set(Func<T> func) {
        this.registry = func.invoke();
    }

    protected WrapperDataFileHandler() {
        registries = new ArrayList<>();
        commands = new ArrayList<>();
        setBuildingFile();
    }

    @Override
    public void add() {
        registries.add(registry);
    }

    @Override
    public void dispose() {
        registries = new ArrayList<>();
    }

    @Override
    public void addCommand(Predicate<String> checkLineData, Consumer<String> getRecordsFromLine, InstanceRegistryHandler instanceRegistryHandler) {
        commands.add(new CommandHandler(checkLineData, getRecordsFromLine, instanceRegistryHandler));
    }

    @Override
    public void addCommand(Predicate<String> checkKineData, Consumer<String> getRecordsFromLine) {
        commands.add(new CommandHandler(checkKineData, getRecordsFromLine, InstanceRegistryHandler.DO_NOT_CREATE_INSTANCE));
    }
}
