package com.ali.ccv.algorithms.luhn;

import junit.framework.Assert;

import org.junit.Test;

import com.ali.ccv.algorithm.IChecker;
import com.ali.ccv.algorithm.luhn.LuhnChecker;

public class LuhnCheckerTest {

    private static final IChecker CHECKER = new LuhnChecker();

    private static final String VALID_CREDIT_CARD = "49927398716";
    private static final String INVALID_CREDIT_CARD = "49927398717";

    @Test
    public void testNullCreditCard() {
        Assert.assertFalse(CHECKER.validate(null));
    }

    @Test
    public void testInvalidLengthCreditCard() {
        Assert.assertFalse(CHECKER.validate("0"));
    }

    @Test
    public void testValidateCorrectCreditCard() {
        Assert.assertTrue(CHECKER.validate(VALID_CREDIT_CARD));
    }

    @Test
    public void testValidateIncorrectCreditCard() {
        Assert.assertFalse(CHECKER.validate(INVALID_CREDIT_CARD));
    }

}
