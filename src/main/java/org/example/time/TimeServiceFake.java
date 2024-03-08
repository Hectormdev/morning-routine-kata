package org.example.time;

import java.time.Instant;

public class TimeServiceFake implements TimeService {

  private Instant now = Instant.now();

  @Override
  public Instant now() {
    return now;
  }

  public void setTime(Instant sixThirtyAm) {
    this.now = sixThirtyAm;
  }

}
