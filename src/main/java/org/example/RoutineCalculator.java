package org.example;

import java.time.Instant;
import java.util.List;

import org.example.time.InstantRange;
import org.example.time.TimeService;

public class RoutineCalculator implements MorningRoutine {

  private final TimeService timeService;

  private final List<Event> routine;

  public RoutineCalculator(TimeService timeService) {
    this.timeService = timeService;
    this.routine = setUpRoutine();
  }

  private List<Event> setUpRoutine() {
    Instant sixAm = timeService.at(6, 0);
    Instant sevenAm = timeService.at(7, 0);
    Instant nineAm = timeService.at(9, 0);
    Instant eightAm = timeService.at(8, 0);

    Event doExercise = new Event(new InstantRange(sixAm, sevenAm), "Do exercise");
    Event readAndStudy = new Event(new InstantRange(sevenAm, eightAm), "Read and study");
    Event haveBreakfast = new Event(new InstantRange(eightAm, nineAm), "Have breakfast");

    return List.of(doExercise, readAndStudy, haveBreakfast);
  }

  @Override
  public String whatShouldIDoNow() {
    Instant now = timeService.now();
    return routine.stream()
        .filter(event -> event.isHappening(now))
        .findFirst()
        .map(Event::getTask)
        .orElse("No activity");
  }

}
