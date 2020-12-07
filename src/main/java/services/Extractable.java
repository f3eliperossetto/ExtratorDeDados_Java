package services;

import models.CommandResult;

import java.util.concurrent.Future;

public interface Extractable<T> {
    CommandResult<T> loadDataFromFile(String path);
    Future<CommandResult<T>> loadDataFromFileAsync(String path);
}
