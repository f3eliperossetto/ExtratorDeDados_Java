package abstractions;

import enums.InstanceRegistryHandler;
import function.Action;
import function.Func;
import function.Predicate;
import models.CommandHandlerModel;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Handler<T> implements CommandHandler<T> {

    protected Handler() {
        registries = new ArrayList<>();
        commands  = new ArrayList<>();
        buildCommands();
    }

    protected Collection<CommandHandlerModel> commands;
    protected T registry;
    private Collection<T> registries;

    @Override
    public Collection<T> getAll() {
        return registries;
    }

    @Override
    public void set(Func<T> func){
       this.registry = func.invoke();
    }

    @Override
    public void add() {
        registries.add(registry);
    }

    @Override
    public void close(){
        this.registry = null;
        registries = new ArrayList<>();
    }

    @Override
    public Collection<CommandHandlerModel> getCommands() {
        return commands;
    }

    @Override
    public void addCommand(Predicate<String> checkLineData, Action<String> getRecordsFromLine, InstanceRegistryHandler instanceRegistryHandler) {
        commands.add(new CommandHandlerModel(checkLineData, getRecordsFromLine, instanceRegistryHandler));
    }

    @Override
    public void addCommand(Predicate<String> checkKineData, Action<String> getRecordsFromLine) {
        commands.add(new CommandHandlerModel(checkKineData, getRecordsFromLine, InstanceRegistryHandler.DO_NOT_CREATE_INSTANCE));
    }

}
