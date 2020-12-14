package services;

import models.CommandResult;

import java.io.IOException;

public interface Extractable<T> {
    CommandResult<T> loadDataFromFile(String filePath) throws IOException;
}
