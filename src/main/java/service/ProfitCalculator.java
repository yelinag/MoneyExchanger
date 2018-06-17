package service;

import entity.ProfitEntity;
import entity.RateEntity;
import entity.TransactionEntity;

import java.util.List;

public class ProfitCalculator {

    private static ProfitCalculator singleton;

    private List<RateEntity> rates;
    private String shopBasedCcy;

    private ProfitCalculator(List<RateEntity> rates, String shopBasedCcy){
        this.rates = rates;
        this.shopBasedCcy = shopBasedCcy;
    }

    public static ProfitCalculator getInstance(List<RateEntity> rates, String basedCcy) {
        if(singleton==null){
            singleton = new ProfitCalculator(rates, basedCcy);
        }
        return singleton;
    }

    public ProfitEntity buildProfitEntity(TransactionEntity transactionEntity, double actualRate, double finalRate){
        double profitInWantedCcy = calculateProfitInWantedCcy(transactionEntity, actualRate, finalRate);
        double profitInShopBasedCcy = calculateProfitInShopBasedCcy(transactionEntity, profitInWantedCcy);
        return new ProfitEntity(
                transactionEntity.getBasedCurrecny(), transactionEntity.getWantedCurrency(),
                transactionEntity.getAmount(), actualRate, finalRate,
                profitInWantedCcy, profitInShopBasedCcy
        );
    }

    private double calculateProfitInWantedCcy(TransactionEntity transactionEntity, double actualRate, double finalRate){
        return (actualRate - finalRate) * transactionEntity.getAmount();
    }

    private double calculateProfitInShopBasedCcy(TransactionEntity transactionEntity, double profitInWantedCcy){
        if(transactionEntity.getWantedCurrency().equals(shopBasedCcy))
            return profitInWantedCcy;
        double basedCcyRate = CurrencyMatcher.getInstance(rates).getCurrencyActualRate(
                transactionEntity.getBasedCurrecny(),
                shopBasedCcy, transactionEntity.getTransactionTime());
        return profitInWantedCcy * basedCcyRate;
    }
}
