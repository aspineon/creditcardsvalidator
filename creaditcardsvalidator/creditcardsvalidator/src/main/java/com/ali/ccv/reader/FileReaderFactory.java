package com.ali.ccv.reader;

import java.io.IOException;

import com.ali.ccv.error.ContingencyException;

public final class FileReaderFactory {

    private static FileReaderFactory instance;

    private FileReaderFactory() {}

    public static FileReaderFactory getInstance() {
        if (instance == null) {
            instance = new FileReaderFactory();
        }

        return instance;
    }

    public FileReader getFileReaderImpl(final String filePath, final String fileFormatName) throws ContingencyException {
        for (FileFormat format : FileFormat.values()) {
            if (format.name().equalsIgnoreCase(fileFormatName)) {
                try {
                    return new FileReader(format.getSeparator(), filePath);
                } catch (IOException e) {
                    throw new ContingencyException("Unable to open file at " + filePath);
                }
            }
        }

        throw new ContingencyException("Unsupported file format: " + fileFormatName);
    }
}
