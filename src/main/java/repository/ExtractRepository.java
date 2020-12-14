package repository;

import java.io.*;
import java.util.Collection;
import java.util.stream.Collectors;

public class ExtractRepository  implements Repository {

    @Override
    public Collection<String> readAllLines(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines().collect(Collectors.toList());
        }
    }
}
