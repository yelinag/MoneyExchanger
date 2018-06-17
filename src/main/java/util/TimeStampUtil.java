package util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStampUtil {

    public static Timestamp convertStringToTimeStamp(String time){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
            Date parsedDate = dateFormat.parse(time);
            Timestamp timestamp = new Timestamp(parsedDate.getTime());
            return timestamp;
        } catch(Exception e) {
            throw new IllegalArgumentException("Invalid Inputs", e);
        }
    }
}
