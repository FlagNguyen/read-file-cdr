package service;

import java.io.IOException;
import java.util.Set;

public interface Service {
    void checkDuplicateAndSave(Set<String> inputSet, Set<String> outputSet, String inputChild) throws IOException;
}
