package com.ali.ccv.algorithm;

import com.ali.ccv.error.ContingencyException;

public final class AlgorithmFactory {

    private static AlgorithmFactory instance;

    private AlgorithmFactory() {}

    public static AlgorithmFactory getInstance() {
        if (instance == null) {
            instance = new AlgorithmFactory();
        }

        return instance;
    }

    public IChecker getAlgorithmChecker(final String name) throws ContingencyException {
        for (AlgorithmSelector algorithmSelector : AlgorithmSelector.values()) {
            if (algorithmSelector.getName().equals(name)) {
                return algorithmSelector.getChecker();
            }
        }

        throw new ContingencyException("Unsupported algorithm: " + name);
    }

}
