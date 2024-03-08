package org.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.time.ZoneId;

import org.example.time.TimeService;
import org.example.time.TimeServiceFake;
import org.junit.jupiter.api.Test;

public class RoutineCalculatorTest {

  private TimeServiceFake timeService = new TimeServiceFake();


  @Test
  void displaysDoExerciseBetween0600And0659(){
    //define an Instant variable of today at Time at 6:30 AM
    Instant sixThirtyAm = Instant.ofEpochSecond(0).atZone(ZoneId.of("Europe/Madrid")).withHour(6).withMinute(30).toInstant();
    timeService.setTime(sixThirtyAm);
    RoutineCalculator routineCalculator = new RoutineCalculator(timeService);

    String result = routineCalculator.whatShouldIDoNow();
    assertThat(result).isEqualTo("Do exercise");
  }

  @Test
  void displaysReadAndStudyDoExerciseBetween0700And0759(){
    RoutineCalculator routineCalculator = new RoutineCalculator(timeService);

    String result = routineCalculator.whatShouldIDoNow();
    assertThat(result).isEqualTo("Read and study");
  }
}
