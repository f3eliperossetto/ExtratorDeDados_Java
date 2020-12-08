package models;

import fcuntionalInterfaces.Action;
import fcuntionalInterfaces.Predicate;
import enums.InstanceRegistryHandler;

import java.util.Objects;


public class CommandHandler {

    public CommandHandler(Predicate<String> checkLineData, Action<String> fillObject, InstanceRegistryHandler instanceRegistryHandler) {
        this.checkLineData = checkLineData;
        this.fillObject = fillObject;
        this.instanceRegistryHandler = instanceRegistryHandler;
    }


    private final Predicate<String> checkLineData;
    private final Action<String> fillObject;
    private final InstanceRegistryHandler instanceRegistryHandler;

    public Predicate<String> getCheckLineData() {
        return checkLineData;
    }

    public Action<String> getFillObject() {
        return fillObject;
    }

    public InstanceRegistryHandler getInstanceRegistryHandler() {
        return instanceRegistryHandler;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommandHandler)) return false;
        CommandHandler that = (CommandHandler) o;
        return checkLineData.equals(that.checkLineData) && fillObject.equals(that.fillObject) && instanceRegistryHandler == that.instanceRegistryHandler;
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkLineData, fillObject, instanceRegistryHandler);
    }
}
