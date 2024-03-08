package org.example.time;

import java.time.Instant;

public class TimeServiceFake implements TimeService {

  @Override
  public Instant now() {
    return Instant.now();
  }
}
