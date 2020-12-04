package abstractions;

import delegators.Func;
import enums.ERegistryType;
import models.CommandHandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public abstract class Handler<T> implements IHandler<T> {

    protected T registry;
    private List<T> registries;
    private final List<CommandHandler> commands;

    @Override
    public List<T> getRegistries() {
        return registries;
    }

    @Override
    public Collection<CommandHandler> getCommands() {
        return commands;
    }

    @Override
    public void setRegistry(Func<T> func) {
        this.registry = func.invoke();
    }

    protected Handler() {
        registries = new ArrayList<>();
        commands = new ArrayList<>();
        setBuildingFile();
    }

    public void addRecord() {
        registries.add(registry);
    }

    public void resetRecords() {
        registries = new ArrayList<>();
    }

    public void addCommand(Predicate<String> checkLineData, Consumer<String> getRecordsFromLine, ERegistryType newInstance) {
        commands.add(new CommandHandler(checkLineData, getRecordsFromLine, newInstance));
    }

    public void addCommand(Predicate<String> checkKineData, Consumer<String> getRecordsFromLine) {
        commands.add(new CommandHandler(checkKineData, getRecordsFromLine, ERegistryType.RECORD));
    }
}
