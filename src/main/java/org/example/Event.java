package org.example;

import java.time.Instant;

import org.example.time.InstantRange;

public class Event {

  InstantRange instantRange;

  String task;

  public Event(InstantRange instantRange, String task) {
    this.instantRange = instantRange;
    this.task = task;
  }
  public boolean isHappening(Instant instant) {
    return instantRange.contains(instant);
  }

  public String getTask() {
    return task;
  }
}
