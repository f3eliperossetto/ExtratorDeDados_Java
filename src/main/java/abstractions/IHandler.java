package abstractions;

import delegators.Func;
import models.CommandHandler;

import java.util.Collection;
import java.util.List;

public interface IHandler<T> {
    void setRegistry(Func<T> func);

    List<T> getRegistries();

    Collection<CommandHandler> getCommands();

    void setBuildingFile();

    /**
     * Creates a new instance of type T
     * @return T
     */
    T newInstance();
}
