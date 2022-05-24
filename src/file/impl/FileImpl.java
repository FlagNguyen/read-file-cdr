package file.impl;

import constant.Constant;
import file.FileHandle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class FileImpl implements FileHandle {

    int fileTypeInPath = 3;

    @Override
    public Optional<Set<String>> readFileIntoSet(String inputDir) throws IOException {
        Set<String> phoneNumberSet = new HashSet<>();
        File dir = new File(inputDir);
        String[] fileNames = dir.list();

        for (String fileName : fileNames) {
            if ((fileName.matches(Constant.INPUT_FILE_NAME_REGEX) && inputDir.split("\\\\")[fileTypeInPath]
                    .equals(Constant.INPUT_FLE)) ||
                    (fileName.matches(Constant.OUTPUT_FILE_NAME_REGEX) && inputDir.split("\\\\")[fileTypeInPath]
                            .equals(Constant.OUTPUT_FILE))) {
//                System.out.println("Reading from " + inputDir + "\\" + fileName);

                // create instance of file from Name of
                // the file stored in string Array
                File f = new File(dir, fileName);
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line = br.readLine();

                while (line != null) {
                    if (!line.trim().matches(Constant.PHONE_NUMBER_FORMAT)) {
                        line = br.readLine();
                    } else {
                        phoneNumberSet.add(line);
                        line = br.readLine();
                    }
                }
            }
        }

//        System.out.println("Reading from all files" + " in directory " + dir.getName() + " Completed\n");
        return Optional.ofNullable(phoneNumberSet);
    }
}

