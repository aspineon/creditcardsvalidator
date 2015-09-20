package com.ali.ccv.core;

import com.ali.ccv.reader.LineStream;

public class OutputModel {

    private static final String DELIMITER = "|";

    private static final String ACCEPTED = "PASS";
    private static final String REFUSED = "FAIL";

    private final LineStream line;
    private final boolean algorithmResult;

    public OutputModel(LineStream line, boolean algorithmResult) {
        this.line = line;
        this.algorithmResult = algorithmResult;
    }

    public String getPrettyResult() {
        StringBuilder sb = new StringBuilder(this.line.getCreditCard())
            .append(DELIMITER)
            .append(this.line.getAlgorithmName())
            .append(DELIMITER)
            .append(this.getAlgorithmResult());
        return sb.toString();
    }

    private String getAlgorithmResult() {
        return this.algorithmResult ? ACCEPTED : REFUSED;
    }

}
