package abstractions;

import enums.InstanceRegistryHandler;
import fcuntionalInterfaces.Action;
import fcuntionalInterfaces.Predicate;
import models.CommandHandlerModel;

import java.util.Collection;

public interface CommandHandler<T> extends RegistryHandler<T> {

     void buildCommands();

     Collection<CommandHandlerModel> getCommands();

     void addCommand(Predicate<String> checkLineData, Action<String> getRecordsFromLine, InstanceRegistryHandler instanceRegistryHandler);

     void addCommand(Predicate<String> checkKineData, Action<String> getRecordsFromLine);
}
