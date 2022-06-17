package file.impl

import constant.Constant
import file.FileHandle
import org.apache.commons.io.*

class FileImpl implements FileHandle {

    int fileTypeInPath = 6

    @Override
    Set<String> readFileIntoSet(String inputPhoneNumberFolderPath) throws IOException {
        Set<String> distinctPhoneNumbers = new HashSet<>()

        File inputPhoneNumberFolder = new File(inputPhoneNumberFolderPath)
        String[] childNumberFolders = inputPhoneNumberFolder.list()

        //Read all phone number folder file by file
        for (String fileNumberName : childNumberFolders) {

            /*Check this folder whether input or output
            and name format is right or not */
            if ((fileNumberName.matches(Constant.INPUT_FILE_NAME_REGEX) && inputPhoneNumberFolderPath.split("/")[fileTypeInPath]
                    .equals(Constant.INPUT_FLE)) ||
                    (fileNumberName.matches(Constant.OUTPUT_FILE_NAME_REGEX) && inputPhoneNumberFolderPath.split("/")[fileTypeInPath]
                            .equals(Constant.OUTPUT_FILE))) {

                File phoneNumberFile = new File(inputPhoneNumberFolder, fileNumberName)
                distinctPhoneNumbers.add(FileUtils.readLines(phoneNumberFile,"UTF-8"))

            }
        }
        return distinctPhoneNumbers
    }
}

