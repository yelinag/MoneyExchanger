package entity;

import java.sql.Timestamp;

public class TransactionEntity{
    private String basedCurrecny;
    private String wantedCurrency;
    private double amount;
    private EnumClienType clienType;
    private Timestamp transactionTime;

    public TransactionEntity(String basedCurrecny, String wantedCurrency, float amount,
                             EnumClienType clienType, Timestamp transactionTime) {
        this.basedCurrecny = basedCurrecny;
        this.wantedCurrency = wantedCurrency;
        this.amount = amount;
        this.clienType = clienType;
        this.transactionTime = transactionTime;
    }

    public String getBasedCurrecny() {
        return basedCurrecny;
    }

    public void setBasedCurrecny(String basedCurrecny) {
        this.basedCurrecny = basedCurrecny;
    }

    public String getWantedCurrency() {
        return wantedCurrency;
    }

    public void setWantedCurrency(String wantedCurrency) {
        this.wantedCurrency = wantedCurrency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public EnumClienType getClienType() {
        return clienType;
    }

    public void setClienType(EnumClienType clienType) {
        this.clienType = clienType;
    }

    public Timestamp getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Timestamp transactionTime) {
        this.transactionTime = transactionTime;
    }
}
