package service.impl;

import constant.Constant;
import service.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class ServiceImpl implements Service {

    @Override
    public void checkDuplicateAndSave(Set<String> inputSet, Set<String> outputSet, String inputChild) throws IOException {

        //Create File Writer & BufferedWriter for both files
        FileWriter inputFileFileWriter = new FileWriter(Constant.INPUT_CO, true);
        BufferedWriter inputBufferedWriter = new BufferedWriter(inputFileFileWriter);
        FileWriter outputFileFileWriter = new FileWriter(Constant.OUTPUT_CO, true);
        BufferedWriter outputBufferedWriter = new BufferedWriter(outputFileFileWriter);

        //Create temp set
        Set<String> inputResultSet = inputSet;
        Set<String> outputResultSet = outputSet;

        //Execute
        inputResultSet.removeAll(outputSet);
        outputResultSet.removeAll(inputSet);

        //For test, uncomment 2 line below
//        System.out.println("Element in inputSet but not in outputSet :"+inputResultSet);
//        System.out.println("Element in outputSet but not in inputSet :"+outputResultSet);

        //Write into both files
        inputBufferedWriter.write("Reading in both dir: " + inputChild + "\n");
        outputBufferedWriter.write("Reading in both dir: " + inputChild + "\n");
        inputBufferedWriter.write("Element in inputSet but not in outputSet :" + inputResultSet + "\n");
        outputBufferedWriter.write("Element in outputSet but not in inputSet :" + outputResultSet + "\n");
        inputBufferedWriter.write("-------------------------------------------------------------------\n");
        outputBufferedWriter.write("-------------------------------------------------------------------\n");

        //Flush buffered writer
        inputBufferedWriter.flush();
        outputBufferedWriter.flush();
        System.out.println("\n");
    }

}
