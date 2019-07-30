package commons;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeMachine {

    public static String getFutureDateFromToday(long numberOfDays, String pattern){
        LocalDateTime currentDate = LocalDateTime.now().plusDays(numberOfDays);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return currentDate.format(dateTimeFormatter);
    }
}
