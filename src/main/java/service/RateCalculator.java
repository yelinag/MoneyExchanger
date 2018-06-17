package service;

import entity.RateEntity;
import entity.TransactionEntity;

import java.util.List;

public class RateCalculator {

    private static RateCalculator singleton;

    private List<RateEntity> rates;
    private String defaultCcy;

    public static RateCalculator getInstance(List<RateEntity> rates, String defaultCcy){
        if(singleton==null){
            singleton = new RateCalculator(rates, defaultCcy);
        }
        return singleton;
    }

    private RateCalculator(List<RateEntity> rates, String defaultCcy) {
        this.rates = rates;
        this.defaultCcy = defaultCcy;
    }

    public double getCurrencyFinalRate(TransactionEntity transactionEntity){
        int markup = MarkupService.getInstance().getMarkUp(transactionEntity.getClienType(),
                getMoneyWithDefaultCcy(transactionEntity));
        double actualRate = CurrencyMatcher.getInstance(rates).getCurrencyActualRate(transactionEntity.getBasedCurrecny(),
                transactionEntity.getWantedCurrency(), transactionEntity.getTransactionTime());
        return actualRate * (1 - 0.0001 * markup);
    }

    private double getMoneyWithDefaultCcy(TransactionEntity transactionEntity){
        double defaultCcyRate = CurrencyMatcher.getInstance(rates).getCurrencyActualRate(transactionEntity.getBasedCurrecny(),
                defaultCcy, transactionEntity.getTransactionTime());
        return defaultCcyRate * transactionEntity.getAmount();
    }





}
