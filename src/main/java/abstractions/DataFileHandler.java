package abstractions;

public interface DataFileHandler<T> extends RegistryHandler<T>, CommandHandler {
    void setBuildingFile();
}
