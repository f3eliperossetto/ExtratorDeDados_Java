package services;

import models.CommandResult;

public interface IExtract<T> {
    CommandResult<T> loadDataFromFile(String path);
}
