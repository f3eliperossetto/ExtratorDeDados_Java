package Abstractions;

import Models.CommandHandler;

import java.util.Collection;
import java.util.List;

public interface IHandler<TFileRegistry> {
    void setCurrentRegistry(TFileRegistry currentRegistry);

    List<TFileRegistry> getRegistry();

    Collection<CommandHandler> getCommands();

    void setBuildingFile();

    TFileRegistry newInstance();
}
