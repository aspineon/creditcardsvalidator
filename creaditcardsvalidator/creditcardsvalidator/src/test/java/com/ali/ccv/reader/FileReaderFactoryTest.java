package com.ali.ccv.reader;

import junit.framework.Assert;

import org.junit.Test;

import com.ali.ccv.error.ContingencyException;

public class FileReaderFactoryTest {

    private static final String EMPTY_FILE_PATH = "./src/test/resources/emptyFile.txt";

    @Test
    public void testGetCSVFileReader() {
        assertFileReader(FileFormat.CSV);
    }

    @Test
    public void testGetPipeFileReader() {
        assertFileReader(FileFormat.PIPE);
    }

    @Test
    public void testGetTabFileReader() {
        assertFileReader(FileFormat.TAB);
    }

    private void assertFileReader(FileFormat fileFormat) {
        try {
            FileReader fileReaderImpl = FileReaderFactory.getInstance().getFileReaderImpl(EMPTY_FILE_PATH, fileFormat.name());
            Assert.assertEquals(fileFormat.getSeparator(), fileReaderImpl.separator);
        } catch (ContingencyException e) {
            Assert.fail();
        }
    }

    @Test
    public void testNonExistingFile() {
        try {
            FileReaderFactory.getInstance().getFileReaderImpl("", FileFormat.CSV.name());
            Assert.fail();
        } catch (ContingencyException e) {
        }
    }

    @Test
    public void testNonExistingFormat() {
        try {
            FileReaderFactory.getInstance().getFileReaderImpl(EMPTY_FILE_PATH, "");
            Assert.fail();
        } catch (ContingencyException e) {
        }
    }

}
