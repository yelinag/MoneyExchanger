package service;

import entity.EnumClienType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MarkupServiceTest {

    MarkupService sut;

    @Before
    public void initialize(){
        sut = MarkupService.getInstance();
    }

    @Test
    public void testGetMarkup(){
        int indiMarkup = sut.getMarkUp(EnumClienType.INDIVIDUAL, 8000);
        int coorporateMarkup = sut.getMarkUp(EnumClienType.CORPORATE, 1000000);
        Assert.assertEquals(40, indiMarkup);
        Assert.assertEquals(15, coorporateMarkup);
    }

}
