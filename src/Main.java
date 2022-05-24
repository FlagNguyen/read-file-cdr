import constant.Constant;
import file.FileHandle;
import file.impl.FileImpl;
import service.Service;
import service.impl.ServiceImpl;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class Main {

    protected static final FileHandle fileHandle = new FileImpl();
    protected static final Service service = new ServiceImpl();

    public static void main(String[] args) throws IOException {
        File parentInputDir = new File(Constant.INPUT_DIR_PATH);
        File parentOutputDir = new File(Constant.OUTPUT_DIR_PATH);
        for (String inputChild : parentInputDir.list()) {
            for (String outputChild : parentOutputDir.list()) {
                if (inputChild.equals(outputChild)) {
                    Set<String> phoneInputSet = fileHandle.readFileIntoSet(Constant.INPUT_DIR_PATH
                            + inputChild).get();
                    Set<String> phoneOutputSet = fileHandle.readFileIntoSet(Constant.OUTPUT_DIR_PATH
                            + outputChild).get();

                    service.checkDuplicateAndSave(phoneInputSet, phoneOutputSet, inputChild);

                    System.out.println("Input directory: " + inputChild);
                    System.out.println(phoneInputSet);
                    System.out.println("Output directory: " + outputChild);
                    System.out.println(phoneOutputSet);
                    System.out.println("--------------------------------------------------");
                }
            }
        }
    }
}
