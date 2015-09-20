package com.ali.ccv.reader;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

import com.ali.ccv.error.ContingencyException;

public class FileReaderTest {

    @Test
    public void testReadCSVSingleLine() {
        this.assertReadSingleLine(FileFormat.CSV, "./src/test/resources/csv/creditcards.csv");
    }

    @Test
    public void testReadPipeSingleLine() {
        this.assertReadSingleLine(FileFormat.PIPE, "./src/test/resources/pipe/creditcards.csv");
    }

    @Test
    public void testReadTabSingleLine() {
        this.assertReadSingleLine(FileFormat.TAB, "./src/test/resources/tab/creditcards.csv");
    }

    private void assertReadSingleLine(final FileFormat fileFormat, final String path) {
        try (FileReader fileReader = FileReaderFactory.getInstance().getFileReaderImpl(path, fileFormat.name());) {
            LineStream line = fileReader.nextLine();
            Assert.assertEquals("49927398716", line.getCreditCard());
            Assert.assertEquals("LUHN", line.getAlgorithmName());
        } catch (ContingencyException | IOException e) {
            Assert.fail();
        }
    }

    @Test
    public void testReadCSVMultipleLines() {
        this.assertReadMultipleLines(FileFormat.CSV, "./src/test/resources/csv/creditcards.csv");
    }

    @Test
    public void testReadPipeMultipleLines() {
        this.assertReadMultipleLines(FileFormat.PIPE, "./src/test/resources/pipe/creditcards.csv");
    }

    @Test
    public void testReadTabMultipleLines() {
        this.assertReadMultipleLines(FileFormat.TAB, "./src/test/resources/tab/creditcards.csv");
    }

    private void assertReadMultipleLines(final FileFormat fileFormat, final String path) {
        try (FileReader fileReader = FileReaderFactory.getInstance().getFileReaderImpl(path, fileFormat.name());) {

            LineStream line = fileReader.nextLine();
            Assert.assertEquals("49927398716", line.getCreditCard());
            Assert.assertEquals("LUHN", line.getAlgorithmName());

            line = fileReader.nextLine();
            Assert.assertEquals("49927398717", line.getCreditCard());
            Assert.assertEquals("SIMPLE", line.getAlgorithmName());

        } catch (ContingencyException | IOException e) {
            Assert.fail();
        }
    }

}
