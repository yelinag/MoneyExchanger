package util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathUtil {

    public static int RATE_DECIMAL_PLACE = 4;
    public static int AMOUNT_DECIMAL_PLACE = 2;

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static double roundRate(double value){
        return round(value, RATE_DECIMAL_PLACE);
    }

    public static double roundAmount(double value){
        return round(value, AMOUNT_DECIMAL_PLACE);
    }

}
