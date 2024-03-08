package org.example.time;

import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public interface TimeService {

  Instant now();

  ZoneId getZone();

  default boolean isBetween(Instant start, Instant finish) {
    return (now().isAfter(start) || now().equals(start)) && now().isBefore(finish);
  }

  default Instant at(int hour, int minute) {
    return now().atZone(getZone()).withHour(hour).withMinute(minute).truncatedTo(ChronoUnit.MINUTES).toInstant();
  }
}
