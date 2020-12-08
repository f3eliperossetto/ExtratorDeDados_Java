package abstractions;

import fcuntionalInterfaces.Action;
import fcuntionalInterfaces.Predicate;
import enums.InstanceRegistryHandler;

import java.util.Collection;

public interface CommandHandler<T> extends RegistryHandler<T> {
    void buildCommands();
    Collection<models.CommandHandler> getCommands();

    void addCommand(Predicate<String> checkLineData, Action<String> getRecordsFromLine, InstanceRegistryHandler instanceRegistryHandler);

    void addCommand(Predicate<String> checkKineData, Action<String> getRecordsFromLine);
}
