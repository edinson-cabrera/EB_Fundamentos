package upc.edu.examenfinal.common.domain;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateTime {
    LocalDateTime dateTime;

    private DateTime(final LocalDateTime referencedDateTime) {
        this.dateTime = referencedDateTime;
    }

    public static DateTime fromString(final String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, formatter);
        return new DateTime(localDateTime);
    }

    public static DateTime nowUtc() {
        LocalDateTime utcNow = LocalDateTime.now(ZoneOffset.UTC);
        return new DateTime(utcNow);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
