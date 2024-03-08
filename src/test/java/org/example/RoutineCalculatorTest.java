package org.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

public class RoutineCalculatorTest {


  @Test
  void displaysDoExerciseBetween0600And0659(){
    RoutineCalculator routineCalculator = new RoutineCalculator();

    String result = routineCalculator.whatShouldIDoNow();
    assertThat(result).isEqualTo("Do exercise");
  }
}
