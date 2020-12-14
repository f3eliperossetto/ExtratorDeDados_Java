package repository;

import java.io.IOException;
import java.util.Collection;

public interface Repository {
    Collection<String> readAllLines(String filePath) throws IOException;
}
