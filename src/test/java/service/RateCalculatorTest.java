package service;

import entity.TransactionEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RateCalculatorTest {

    RateCalculator sut;

    @Before
    public void initialize(){
        sut = RateCalculator.getInstance(TestUtilClass.getRates(), "USD");
    }

    @Test
    public void testGetCurrencyFinalRate(){
        TransactionEntity entity = TestUtilClass.mockTransaction();
        double finalRate = sut.getCurrencyFinalRate(entity);

        Assert.assertEquals(0.2004, finalRate, 0.00001);
    }
}
