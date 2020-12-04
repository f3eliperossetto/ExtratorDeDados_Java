package models;

import delegators.Action;
import delegators.Predicate;
import enums.InstanceRegistryHandler;


public class CommandHandler {

    public CommandHandler(Predicate<String> checkLineData, Action<String> fillObject, InstanceRegistryHandler registryType) {
        this.checkLineData = checkLineData;
        this.fillObject = fillObject;
        this.registryType = registryType;
    }


    private final Predicate<String> checkLineData;
    private final Action<String> fillObject;
    private final InstanceRegistryHandler registryType;

    public Predicate<String> getCheckLineData() {
        return checkLineData;
    }

    public Action<String> getFillObject() {
        return fillObject;
    }

    public InstanceRegistryHandler getRegistryType() {
        return registryType;
    }

}
