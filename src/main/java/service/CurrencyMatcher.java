package service;

import entity.RateEntity;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

public class CurrencyMatcher {

    private static CurrencyMatcher singleton;

    private List<RateEntity> rates;

    private CurrencyMatcher(List<RateEntity> rates){
        this.rates = rates;
    }

    public static CurrencyMatcher getInstance(List<RateEntity> rates){
        if(singleton==null){
            singleton = new CurrencyMatcher(rates);
        }
        return singleton;
    }

    public double getCurrencyActualRate(String basedCcy, String wantedCcy, Timestamp timestamp){
        if(basedCcy.equals(wantedCcy)) return 1;
        Iterator<RateEntity> iterator = rates.iterator();
        while(iterator.hasNext()){
            RateEntity rateEntity = iterator.next();
            if(rateEntity.getBasedCcy().equals(basedCcy) &&
                    rateEntity.getWatnedCcy().equals(wantedCcy) &&
                    (timestamp.before(rateEntity.getValidUntil()) ||
                            timestamp.equals(rateEntity.getValidUntil())))
                return rateEntity.getRate();
        }
        throw new IllegalArgumentException("Currency not found in rates list");
    }
}
