package org.example;

import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import org.example.time.TimeService;

public class RoutineCalculator implements MorningRoutine {

  private final TimeService timeService;

  public RoutineCalculator(TimeService timeService) {
    this.timeService = timeService;
  }

  @Override
  public String whatShouldIDoNow() {
    Instant now = timeService.now();
    ZoneId zone = ZoneId.of("Europe/Madrid");
    Instant sixAm = now.atZone(zone).withHour(6).truncatedTo(ChronoUnit.HOURS).toInstant();
    Instant sevenAm = now.atZone(zone).withHour(7).truncatedTo(ChronoUnit.HOURS).toInstant();
    if (now.isAfter(sixAm) && now.isBefore(sevenAm)) {
      return "Do exercise";
    }

    return "Read and study";
  }
}
