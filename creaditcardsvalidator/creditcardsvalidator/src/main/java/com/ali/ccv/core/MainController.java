package com.ali.ccv.core;

import java.io.IOException;

import com.ali.ccv.algorithm.AlgorithmFactory;
import com.ali.ccv.algorithm.IChecker;
import com.ali.ccv.error.ContingencyException;
import com.ali.ccv.reader.FileReader;
import com.ali.ccv.reader.FileReaderFactory;
import com.ali.ccv.reader.LineStream;

public final class MainController {

    private final String filePath;
    private final String fileFormat;

    public MainController(final String filePath, final String fileFormatName) {
        this.fileFormat = fileFormatName;
        this.filePath = filePath;
    }

    public void read() throws ContingencyException {
        try (FileReader fileReaderImpl = FileReaderFactory.getInstance().getFileReaderImpl(this.filePath, this.fileFormat);) {
            while (fileReaderImpl.hasNext()) {
                final LineStream line = fileReaderImpl.nextLine();
                final IChecker algorithmChecker = AlgorithmFactory.getInstance().getAlgorithmChecker(line.getAlgorithmName());
                final boolean validationResult = algorithmChecker.validate(line.getCreditCard());

                final OutputModel output = new OutputModel(line, validationResult);
                System.out.println(output.getPrettyResult());
            }
        } catch (ContingencyException | IOException e) {
            e.printStackTrace();
            throw new ContingencyException("Error while reading file");
        }
    }

    public void printSingleResult(final OutputModel output, final boolean isError) {
        if (isError) {
            System.err.println(output.getPrettyResult());
        } else {
          System.out.println(output.getPrettyResult());
        }
    }

    public static boolean validateFormat(String[] args) {
        return args.length == 2;
    }

    public static void printHelp() {
        System.out.print("Input format is: <filePath> <fileFormat>");
    }

    public static void main(String[] args) throws Exception {
        if (!MainController.validateFormat(args)) {
            MainController.printHelp()  ;
        } else {
            MainController main = new MainController(args[0], args[1]);
            main.read();
        }
    }
}
