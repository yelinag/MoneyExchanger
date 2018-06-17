package entity;

public class MarkupEntity {

    private double amount;
    private int markup;

    public MarkupEntity(double amount, int markup) {
        this.amount = amount;
        this.markup = markup;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getMarkup() {
        return markup;
    }

    public void setMarkup(int markup) {
        this.markup = markup;
    }
}
