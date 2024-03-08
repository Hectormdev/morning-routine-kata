package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.time.ZoneId;

import org.example.time.TimeServiceFake;
import org.junit.jupiter.api.Test;

public class RoutineCalculatorTest {

  private final TimeServiceFake timeService = new TimeServiceFake();

  @Test
  void displaysDoExerciseBetween0600And0659() {
    Instant sixThirtyAm = Instant.ofEpochSecond(0).atZone(ZoneId.of("Europe/Madrid")).withHour(6).withMinute(30).toInstant();
    timeService.setTime(sixThirtyAm);
    RoutineCalculator routineCalculator = new RoutineCalculator(timeService);

    String result = routineCalculator.whatShouldIDoNow();

    assertThat(result).isEqualTo("Do exercise");
  }

  @Test
  void displaysReadAndStudyDoExerciseBetween0700And0759() {
    Instant sevenThirtyAm = Instant.ofEpochSecond(0).atZone(ZoneId.of("Europe/Madrid")).withHour(7).withMinute(30).toInstant();
    timeService.setTime(sevenThirtyAm);
    RoutineCalculator routineCalculator = new RoutineCalculator(timeService);

    String result = routineCalculator.whatShouldIDoNow();

    assertThat(result).isEqualTo("Read and study");
  }

  @Test
  void displaysReadAndStudyDoExerciseBetween0800And0859() {
    Instant eightThirtyAm = Instant.ofEpochSecond(0).atZone(ZoneId.of("Europe/Madrid")).withHour(8).withMinute(30).toInstant();
    timeService.setTime(eightThirtyAm);
    RoutineCalculator routineCalculator = new RoutineCalculator(timeService);

    String result = routineCalculator.whatShouldIDoNow();

    assertThat(result).isEqualTo("Have breakfast");
  }

  @Test
  void displaysReadAndStudyDoExerciseBetween0900And559() {
    RoutineCalculator routineCalculator = new RoutineCalculator(timeService);
    Instant eightThirtyAm = Instant.ofEpochSecond(0).atZone(ZoneId.of("Europe/Madrid")).withHour(22).withMinute(30).toInstant();
    timeService.setTime(eightThirtyAm);

    String result = routineCalculator.whatShouldIDoNow();

    assertThat(result).isEqualTo("No activity");
  }
}
