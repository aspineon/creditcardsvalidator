package com.ali.ccv.core;

import junit.framework.Assert;

import org.junit.Test;

import com.ali.ccv.error.ContingencyException;
import com.ali.ccv.reader.LineStream;

public class OutputModelTest {

    private static final String CREDIT_CARD = "123456789";
    private static final String ALGORITHM_NAME = "Algo";

    private static final String DELIMITER = "|";

    @Test
    public void testAcceptedOutputFormat() throws ContingencyException {
        String[] lineArgs = new String[]{CREDIT_CARD, ALGORITHM_NAME};
        LineStream line = new LineStream(lineArgs);

        OutputModel output = new OutputModel(line, true);
        Assert.assertEquals(CREDIT_CARD + DELIMITER + ALGORITHM_NAME + DELIMITER + "PASS", output.getPrettyResult());
    }

    @Test
    public void testRefusedOutputFormat() throws ContingencyException {
        String[] lineArgs = new String[]{CREDIT_CARD, ALGORITHM_NAME};
        LineStream line = new LineStream(lineArgs);

        OutputModel output = new OutputModel(line, false);
        Assert.assertEquals(CREDIT_CARD + DELIMITER + ALGORITHM_NAME + DELIMITER + "FAIL", output.getPrettyResult());
    }

}
