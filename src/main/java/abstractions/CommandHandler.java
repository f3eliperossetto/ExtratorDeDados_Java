package abstractions;

import enums.InstanceRegistryHandler;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface CommandHandler {
    Collection<models.CommandHandler> getCommands();
    void addCommand(Predicate<String> checkLineData, Consumer<String> getRecordsFromLine, InstanceRegistryHandler instanceRegistryHandler);
    void addCommand(Predicate<String> checkKineData, Consumer<String> getRecordsFromLine);
}
