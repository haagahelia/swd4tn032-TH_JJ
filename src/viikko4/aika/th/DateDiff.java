package viikko4.aika.th;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateDiff {

    public static void main(String[] args) {
        String start = args[0];
        String end = args[1];

        DateTimeFormatter format = DateTimeFormatter.ofPattern("d.M.yyyy");

        LocalDate startDate = LocalDate.parse(start, format);
        LocalDate endDate = LocalDate.parse(end, format);

        long days = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("Days between: " + days);
    }
}
