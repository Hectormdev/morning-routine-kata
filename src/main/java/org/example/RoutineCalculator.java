package org.example;

import java.time.Instant;
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
    Instant sixAm = now.atZone(timeService.getZone()).withHour(6).truncatedTo(ChronoUnit.HOURS).toInstant();
    Instant sevenAm = now.atZone(timeService.getZone()).withHour(7).truncatedTo(ChronoUnit.HOURS).toInstant();
    Instant eightAm = now.atZone(timeService.getZone()).withHour(8).truncatedTo(ChronoUnit.HOURS).toInstant();
    Instant nineAm = now.atZone(timeService.getZone()).withHour(9).truncatedTo(ChronoUnit.HOURS).toInstant();
    if (timeService.isBetween(sixAm, sevenAm)) {
      return "Do exercise";
    }
    if (timeService.isBetween(sevenAm, eightAm)) {
      return "Read and study";
    }
    if (timeService.isBetween(eightAm, nineAm)) {
      return "Have breakfast";
    }
    return "No activity";
  }
}
