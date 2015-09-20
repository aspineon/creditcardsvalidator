package com.ali.ccv.core;

import junit.framework.Assert;

import org.junit.Test;

public class MainControllerTest {

    @Test
    public void testReadWholeCSVFile() {
        this.assertReadFile("./src/test/resources/csv/creditcards.csv", "CSV");
    }

    @Test
    public void testReadWholeTabFile() {
        this.assertReadFile("./src/test/resources/pipe/creditcards.csv", "Pipe");
    }

    @Test
    public void testReadWholePipeFile() {
        this.assertReadFile("./src/test/resources/tab/creditcards.csv", "Tab");
    }

    @Test
    public void testIncorrectFormat() {
        try {
            MainController main = new MainController("./src/test/resources/csv/creditcards.csv", "Tab");
            main.read();
            Assert.fail();
        } catch (Exception e) {
        }
    }

    private void assertReadFile(final String filePath, final String formatName) {
        try {
            MainController main = new MainController(filePath, formatName);
            main.read();
        } catch (Exception e) {
            Assert.fail();
        }
    }

}
