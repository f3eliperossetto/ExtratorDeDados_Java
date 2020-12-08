package abstractions;

import fcuntionalInterfaces.Action;
import fcuntionalInterfaces.Predicate;
import fcuntionalInterfaces.Func;
import enums.InstanceRegistryHandler;

import java.util.Collection;
import java.util.HashSet;

public abstract class AbstractCommandHandler<T> implements CommandHandler<T> {
    protected T registry;
    private Collection<T> registries;
    private final Collection<models.CommandHandler> commands;

    @Override
    public Collection<T> getAll() {
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

    protected AbstractCommandHandler() {
        registries = new HashSet<>();
        commands = new HashSet<>();
        buildCommands();
    }

    @Override
    public void add() {
        registries.add(registry);
    }

    @Override
    public void dispose() {
        registries = new HashSet<>();
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
