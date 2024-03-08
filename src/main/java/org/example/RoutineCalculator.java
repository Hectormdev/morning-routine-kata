package org.example;

import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.time.temporal.ValueRange;
import java.util.List;

import org.example.time.InstantRange;
import org.example.time.TimeService;

public class RoutineCalculator implements MorningRoutine {

  private final TimeService timeService;

  private final List<Event> routine;

  public RoutineCalculator(TimeService timeService) {
    this.timeService = timeService;
    this.routine = setUpRoutine(timeService.now());
  }

  private List<Event> setUpRoutine(Instant now) {
    Instant sixAm = now.atZone(timeService.getZone()).withHour(6).truncatedTo(ChronoUnit.HOURS).toInstant();
    Instant sevenAm = now.atZone(timeService.getZone()).withHour(7).truncatedTo(ChronoUnit.HOURS).toInstant();
    Instant nineAm = now.atZone(timeService.getZone()).withHour(9).truncatedTo(ChronoUnit.HOURS).toInstant();
    Instant eightAm = now.atZone(timeService.getZone()).withHour(8).truncatedTo(ChronoUnit.HOURS).toInstant();
    Event doExercise = new Event(new InstantRange(sixAm, sevenAm), "Do exercise");
    Event readAndStudy = new Event(new InstantRange(sevenAm, eightAm), "Read and study");
    Event haveBreakfast = new Event(new InstantRange(eightAm, nineAm), "Have breakfast");
    List<Event> agenda = List.of(doExercise, readAndStudy, haveBreakfast);
    return agenda;
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
