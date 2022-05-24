package file;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;

public interface FileHandle {
    Optional<Set<String>> readFileIntoSet(String inputDir) throws IOException;
}
