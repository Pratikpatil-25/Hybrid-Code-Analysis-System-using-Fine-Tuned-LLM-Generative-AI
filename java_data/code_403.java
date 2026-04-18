package com.google.cloud.sql.core;

import java.time.Duration;
import java.time.Instant;


class RefreshCalculator {

        static final Duration DEFAULT_REFRESH_BUFFER = Duration.ofMinutes(4);

      @SuppressWarnings("JavaDurationGetSecondsToToSeconds")
  long calculateSecondsUntilNextRefresh(Instant now, Instant expiration) {
    Duration timeUntilExp = Duration.between(now, expiration);

    if (timeUntilExp.compareTo(Duration.ofHours(1)) < 0) {
      if (timeUntilExp.compareTo(DEFAULT_REFRESH_BUFFER) < 0) {
                        return 0;
      }
            return timeUntilExp.minus(DEFAULT_REFRESH_BUFFER).getSeconds();
    }

        return timeUntilExp.dividedBy(2).getSeconds();
  }
}