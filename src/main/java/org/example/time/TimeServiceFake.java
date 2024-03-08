package org.example.time;

import java.time.Instant;
import java.time.ZoneId;

public class TimeServiceFake implements TimeService {

  public static final ZoneId TIME_ZONE = ZoneId.of("Europe/Madrid");

  private Instant now = Instant.now().atZone(TIME_ZONE).toInstant();

  @Override
  public Instant now() {
    return now;
  }

  @Override
  public ZoneId getZone() {
    return TIME_ZONE;
  }

  @Override
  public boolean isBetween(Instant start, Instant finish) {
    return (now().isAfter(start) || now().equals(start)) && now().isBefore(finish);
  }

  public void setTime(Instant sixThirtyAm) {
    this.now = sixThirtyAm;
  }

}
