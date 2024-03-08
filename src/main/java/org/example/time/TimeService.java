package org.example.time;

import java.time.Instant;
import java.time.ZoneId;

public interface TimeService {

  Instant now();

  ZoneId getZone();

  default boolean isBetween(Instant start, Instant finish) {
    return (now().isAfter(start) || now().equals(start)) && now().isBefore(finish);
  }

}
