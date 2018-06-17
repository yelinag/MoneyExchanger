package service;

import entity.EnumClienType;
import entity.ProfitEntity;
import entity.TransactionEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.TimeStampUtil;

public class ProfitCalculatorTest {

    ProfitCalculator sut;

    @Before
    public void initialize(){
        sut = ProfitCalculator.getInstance(TestUtilClass.getRates(), "SGD");
    }

    @Test
    public void testCalculateProfitInWantedCcy(){
        ProfitEntity profit = sut.buildProfitEntity(TestUtilClass.mockTransaction(), 0.2012, 0.2004);
        Assert.assertEquals(32, profit.getProfitInWantedCcy(), 0.00001);
        Assert.assertEquals(32, profit.getProfitInShopBasedCcy(), 0.00001);
    }
}
