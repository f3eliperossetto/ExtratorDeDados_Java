package abstractions;

import delegators.Action;
import delegators.Predicate;
import enums.InstanceRegistryHandler;

import java.util.Collection;

public interface CommandHandler<T> extends RegistryHandler<T> {
    void buildCommands();
    Collection<models.CommandHandler> getCommands();

    void addCommand(Predicate<String> checkLineData, Action<String> getRecordsFromLine, InstanceRegistryHandler instanceRegistryHandler);

    void addCommand(Predicate<String> checkKineData, Action<String> getRecordsFromLine);
}
