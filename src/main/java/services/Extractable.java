package services;

import models.CommandResult;

public interface Extractable<T> {
    CommandResult<T> loadDataFromFile(String path);
}
