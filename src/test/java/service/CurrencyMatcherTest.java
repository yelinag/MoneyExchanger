package service;

import entity.RateEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import util.TimeStampUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class CurrencyMatcherTest {

    CurrencyMatcher sut;

    @Before
    public void setup(){
        sut = CurrencyMatcher.getInstance(TestUtilClass.getRates());
    }

    @Test
    public void testGetCurrencyActualRate(){
        double nineOclockrate = sut.getCurrencyActualRate("CNY", "SGD", TimeStampUtil.convertStringToTimeStamp("9:00"));
        double nine1Rate = sut.getCurrencyActualRate("CNY", "SGD", TimeStampUtil.convertStringToTimeStamp("9:01"));
        assertEquals(0.2012, nineOclockrate, 0.00001);
        assertEquals(0.2013, nine1Rate, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCurrencyActualRateWithException(){
        double nineOclockrate = sut.getCurrencyActualRate("USD", "SGD", TimeStampUtil.convertStringToTimeStamp("9:00"));
    }



}
