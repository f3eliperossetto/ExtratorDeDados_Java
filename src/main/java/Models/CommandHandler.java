package Models;

import Enums.ERegistryType;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CommandHandler {

    public CommandHandler(Predicate<String> checkLineData, Consumer<String> fillObject, ERegistryType registryType) {
        this.checkLineData = checkLineData;
        this.fillObject = fillObject;
        this.registryType = registryType;
    }

    private Predicate<String> checkLineData;
    private Consumer<String> fillObject;
    private ERegistryType registryType;

    public Predicate<String> getCheckLineData() {
        return checkLineData;
    }

    public Consumer<String> getFillObject() {
        return fillObject;
    }

    public ERegistryType getRegistryType() {
        return registryType;
    }

}
