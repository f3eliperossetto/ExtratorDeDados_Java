package Abstractions;

import Enums.ERegistryType;
import Models.CommandHandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public abstract class Handler<TFileRegistry> implements IHandler<TFileRegistry> {

    protected TFileRegistry currentRegistry;
    private List<TFileRegistry> registry;
    private final List<CommandHandler> commands;

    @Override
    public List<TFileRegistry> getRegistry() {
        return registry;
    }

    @Override
    public Collection<CommandHandler> getCommands() {
        return commands;
    }

    @Override
    public void setCurrentRegistry(TFileRegistry currentRegistry) {
        this.currentRegistry = currentRegistry;
    }

    public Handler() {
        registry = new ArrayList<>();
        commands = new ArrayList<>();
        setBuildingFile();
    }

    public void addRecord() {
        registry.add(currentRegistry);
    }

    public void resetRecords() {
        registry = new ArrayList<>();
    }

    public void addCommand(Predicate<String> checkLineData, Consumer<String> getRecordsFromLine, ERegistryType newInstance) {
        commands.add(new CommandHandler(checkLineData, getRecordsFromLine, newInstance));
    }

    public void addCommand(Predicate<String> checkKineData, Consumer<String> getRecordsFromLine) {
        commands.add(new CommandHandler(checkKineData, getRecordsFromLine, ERegistryType.Record));
    }
}
