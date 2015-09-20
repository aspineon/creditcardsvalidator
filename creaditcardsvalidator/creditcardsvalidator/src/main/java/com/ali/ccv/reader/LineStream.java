package com.ali.ccv.reader;

import com.ali.ccv.error.ContingencyException;

public final class LineStream {

    private final String creditCard;
    private final String algorithmName;

    public LineStream(String[] lineElements) throws ContingencyException {
        try {
            this.creditCard = lineElements[0];
            this.algorithmName = lineElements[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ContingencyException("File has an invalid format");
        }
    }

    public String getCreditCard() {
        return creditCard;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

}
