package com.ali.ccv.algorithm;

import com.ali.ccv.algorithm.luhn.LuhnChecker;
import com.ali.ccv.algorithm.simple.SimpleChecker;

public enum AlgorithmSelector {

    LUHN("LUHN", new LuhnChecker()),
    SIMPLE("SIMPLE", new SimpleChecker());

    private final String name;
    private final IChecker checker;

    private AlgorithmSelector(final String name, final IChecker checker) {
        this.name = name;
        this.checker = checker;
    }

    public String getName() {
        return this.name;
    }

    public IChecker getChecker() {
        return this.checker;
    }

}
