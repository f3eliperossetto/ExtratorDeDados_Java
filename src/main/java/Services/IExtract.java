package Services;

import Models.CommandResult;

public interface IExtract<T> {
    CommandResult<T> loadDataFromFile(String path);
}
