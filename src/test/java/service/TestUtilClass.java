package service;

import entity.EnumClienType;
import entity.RateEntity;
import entity.TransactionEntity;
import util.TimeStampUtil;

import java.util.ArrayList;
import java.util.List;

public class TestUtilClass {

    public static List<RateEntity> getRates(){
        List<RateEntity> rates = new ArrayList<>();
        rates.add(new RateEntity("CNY", "SGD", 0.2012, TimeStampUtil.convertStringToTimeStamp("9:00")));
        rates.add(new RateEntity("CNY", "USD", 0.161, TimeStampUtil.convertStringToTimeStamp("9:00")));
        rates.add(new RateEntity("CNY", "SGD", 0.2013, TimeStampUtil.convertStringToTimeStamp("11:00")));
        rates.add(new RateEntity("SGD", "USD", 0.75, TimeStampUtil.convertStringToTimeStamp("9:00")));
        return rates;
    }

    public static TransactionEntity mockTransaction(){
        return new TransactionEntity("CNY", "SGD",
                40000, EnumClienType.INDIVIDUAL, TimeStampUtil.convertStringToTimeStamp("9:00"));
    }

}
