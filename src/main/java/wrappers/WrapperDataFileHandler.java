package wrappers;

import delegators.Action;
import delegators.Predicate;
import abstractions.DataFileHandler;
import delegators.Func;
import enums.InstanceRegistryHandler;
import models.CommandHandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    public void addCommand(Predicate<String> checkLineData, Action<String> getRecordsFromLine, InstanceRegistryHandler instanceRegistryHandler) {
        commands.add(new CommandHandler(checkLineData, getRecordsFromLine, instanceRegistryHandler));
    }

    @Override
    public void addCommand(Predicate<String> checkKineData, Action<String> getRecordsFromLine) {
        commands.add(new CommandHandler(checkKineData, getRecordsFromLine, InstanceRegistryHandler.DO_NOT_CREATE_INSTANCE));
    }
}
