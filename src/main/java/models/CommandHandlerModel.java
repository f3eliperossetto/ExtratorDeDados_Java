package models;

import function.Action;
import function.Predicate;
import enums.InstanceRegistryHandler;


public class CommandHandlerModel {

    public CommandHandlerModel(Predicate<String> checkLineData, Action<String> fillObject, InstanceRegistryHandler instanceRegistryHandler) {
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
}
