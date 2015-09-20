package com.ali.ccv.algorithm.simple;

import com.ali.ccv.algorithm.IChecker;

public class SimpleChecker implements IChecker {

    @Override
    public boolean validate(String number) {
        return this.validateLength(number);
    }

    private boolean validateLength(final String number) {
        return number != null && number.length() == 11;
    }

}
