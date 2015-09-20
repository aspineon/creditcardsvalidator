package com.ali.ccv.algorithms;

import junit.framework.Assert;

import org.junit.Test;

import com.ali.ccv.algorithm.AlgorithmFactory;
import com.ali.ccv.algorithm.AlgorithmSelector;
import com.ali.ccv.algorithm.IChecker;
import com.ali.ccv.algorithm.luhn.LuhnChecker;
import com.ali.ccv.error.ContingencyException;

public class AlgoritmFactoryTest {

    @Test
    public void testGetLuhnChecker() {
        try {
            IChecker checker = AlgorithmFactory.getInstance().getAlgorithmChecker(AlgorithmSelector.LUHN.getName());
            Assert.assertEquals(LuhnChecker.class, checker.getClass());
        } catch (ContingencyException e) {
            Assert.fail();
        }
    }

    @Test
    public void testInvalidAlgorithm() {
        try {
            AlgorithmFactory.getInstance().getAlgorithmChecker("invalid");
            Assert.fail();
        } catch (ContingencyException e) {
        }
    }

}
