package abstractions;

import delegators.Action;
import enums.InstanceRegistryHandler;

import java.util.Collection;

import delegators.Predicate;

public interface CommandHandler {
    Collection<models.CommandHandler> getCommands();

    void addCommand(Predicate<String> checkLineData, Action<String> getRecordsFromLine, InstanceRegistryHandler instanceRegistryHandler);

    void addCommand(Predicate<String> checkKineData, Action<String> getRecordsFromLine);
}
