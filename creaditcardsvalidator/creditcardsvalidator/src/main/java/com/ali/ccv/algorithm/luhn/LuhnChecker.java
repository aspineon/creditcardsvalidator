package com.ali.ccv.algorithm.luhn;

import com.ali.ccv.algorithm.IChecker;

public final class LuhnChecker implements IChecker {

    @Override
    public boolean validate(final String number) {
        if (!this.validateLength(number)) {
            return false;
        }

        String[] duplicateEvens = this.duplicateEvens(number);
        int sum = this.sumDigits(duplicateEvens);

        return isModulues10(sum);
    }

    private boolean isModulues10(final int sum) {
        return sum % 10 == 0;
    }

    private boolean validateLength(final String number) {
        return number != null && number.length() == 11;
    }

    private String[] duplicateEvens(final String number) {
        String[] evensDuplicated = new String[number.length()];

        for (int i = 0; i < number.length(); i++) {
            if (isOdd(i)) {
                evensDuplicated[i] = this.duplicateDigit(number.charAt(i));
            } else {
                evensDuplicated[i] = String.valueOf(number.charAt(i));
            }
        }

        return evensDuplicated;
    }

    private boolean isOdd(final int index) {
        return index % 2 != 0;
    }

    private String duplicateDigit(final char digit) {
        return Integer.toString(Character.getNumericValue(digit) * 2);
    }

    private int sumDigits(final String[] duplicateEvens) {
        int sum = 0;

        for (int i = 0; i < duplicateEvens.length; i++) {
            sum += this.getSumOfDigits(duplicateEvens[i]);
        }

        return sum;
    }

    private int getSumOfDigits(final String value) {
        int sum = 0;
        for (int i = 0; i < value.length(); i++) {
            sum += Character.getNumericValue(value.charAt(i));
        }
        return sum;
    }

}
