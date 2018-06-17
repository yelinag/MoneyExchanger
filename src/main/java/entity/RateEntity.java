package entity;

import java.sql.Timestamp;


public class RateEntity {

    private String basedCcy;
    private String watnedCcy;
    private double rate;
    private Timestamp validUntil;

    public RateEntity(String basedCcy, String watnedCcy, double rate, Timestamp validUntil) {
        this.basedCcy = basedCcy;
        this.watnedCcy = watnedCcy;
        this.rate = rate;
        this.validUntil = validUntil;
    }

    public String getWatnedCcy() {
        return watnedCcy;
    }

    public void setWatnedCcy(String watnedCcy) {
        this.watnedCcy = watnedCcy;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public Timestamp getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Timestamp validUntil) {
        this.validUntil = validUntil;
    }

    public String getBasedCcy() {
        return basedCcy;
    }

    public void setBasedCcy(String basedCcy) {
        this.basedCcy = basedCcy;
    }
}
