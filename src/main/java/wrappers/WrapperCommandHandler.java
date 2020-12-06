package wrappers;

import functionals.Action;
import functionals.Predicate;
import abstractions.CommandHandler;
import functionals.Func;
import enums.InstanceRegistryHandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class WrapperCommandHandler<T> implements CommandHandler<T> {
    protected T registry;
    private List<T> registries;
    private final List<models.CommandHandler> commands;

    @Override
    public List<T> getAll() {
        return registries;
    }

    @Override
    public Collection<models.CommandHandler> getCommands() {
        return commands;
    }

    @Override
    public void set(Func<T> func) {
        this.registry = func.invoke();
    }

    protected WrapperCommandHandler() {
        registries = new ArrayList<>();
        commands = new ArrayList<>();
        buildCommands();
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
        commands.add(new models.CommandHandler(checkLineData, getRecordsFromLine, instanceRegistryHandler));
    }

    @Override
    public void addCommand(Predicate<String> checkKineData, Action<String> getRecordsFromLine) {
        commands.add(new models.CommandHandler(checkKineData, getRecordsFromLine, InstanceRegistryHandler.DO_NOT_CREATE_INSTANCE));
    }
}
