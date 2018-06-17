package entity;

public class ProfitEntity {

    private String basedCcy;
    private String wantedCcy;
    private double amountInBaseCcy;
    private double standardRate;
    private double finalRate;
    private double profitInWantedCcy;
    private double profitInShopBasedCcy;

    public ProfitEntity(String basedCcy, String wantedCcy, double amountInBaseCcy,
                        double standardRate, double finalRate, double profitInWantedCcy,
                        double profitInShopBasedCcy) {
        this.basedCcy = basedCcy;
        this.wantedCcy = wantedCcy;
        this.amountInBaseCcy = amountInBaseCcy;
        this.standardRate = standardRate;
        this.finalRate = finalRate;
        this.profitInWantedCcy = profitInWantedCcy;
        this.profitInShopBasedCcy = profitInShopBasedCcy;
    }

    public String getBasedCcy() {
        return basedCcy;
    }

    public void setBasedCcy(String basedCcy) {
        this.basedCcy = basedCcy;
    }

    public String getWantedCcy() {
        return wantedCcy;
    }

    public void setWantedCcy(String wantedCcy) {
        this.wantedCcy = wantedCcy;
    }

    public double getAmountInBaseCcy() {
        return amountInBaseCcy;
    }

    public void setAmountInBaseCcy(double amountInBaseCcy) {
        this.amountInBaseCcy = amountInBaseCcy;
    }

    public double getStandardRate() {
        return standardRate;
    }

    public void setStandardRate(float standardRate) {
        this.standardRate = standardRate;
    }

    public double getFinalRate() {
        return finalRate;
    }

    public void setFinalRate(float finalRate) {
        this.finalRate = finalRate;
    }

    public double getProfitInWantedCcy() {
        return profitInWantedCcy;
    }

    public void setProfitInWantedCcy(double profitInWantedCcy) {
        this.profitInWantedCcy = profitInWantedCcy;
    }

    public double getProfitInShopBasedCcy() {
        return profitInShopBasedCcy;
    }

    public void setProfitInShopBasedCcy(double profitInShopBasedCcy) {
        this.profitInShopBasedCcy = profitInShopBasedCcy;
    }
}
