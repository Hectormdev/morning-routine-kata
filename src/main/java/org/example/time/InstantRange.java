package org.example.time;

import java.time.Instant;

public class InstantRange {

  private final Instant start;
  private final Instant finish;

  public InstantRange(Instant start, Instant finish) {
    this.start = start;
    this.finish = finish;
  }

  public boolean contains(Instant instant) {
    return (instant.isAfter(start) || instant.equals(start)) && instant.isBefore(finish);
  }

  public Instant getStart() {
    return start;
  }

  public Instant getFinish() {
    return finish;
  }

  public boolean isBefore(Instant instant) {
    return finish.isBefore(instant);
  }

  public boolean isAfter(Instant instant) {
    return start.isAfter(instant);
  }

  public boolean isAfter(InstantRange range) {
    return start.isAfter(range.getFinish());
  }

  public boolean isBefore(InstantRange range) {
    return finish.isBefore(range.getStart());
  }


}
