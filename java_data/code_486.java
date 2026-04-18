package com.google.cloud.retail.v2beta.stub.samples;

import com.google.api.gax.longrunning.OperationalTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.TimedRetryAlgorithm;
import com.google.cloud.retail.v2beta.stub.UserEventServiceStubSettings;
import java.time.Duration;

public class SyncPurgeUserEvents {

  public static void main(String[] args) throws Exception {
    syncPurgeUserEvents();
  }

  public static void syncPurgeUserEvents() throws Exception {
                        UserEventServiceStubSettings.Builder userEventServiceSettingsBuilder =
        UserEventServiceStubSettings.newBuilder();
    TimedRetryAlgorithm timedRetryAlgorithm =
        OperationalTimedPollAlgorithm.create(
            RetrySettings.newBuilder()
                .setInitialRetryDelayDuration(Duration.ofMillis(500))
                .setRetryDelayMultiplier(1.5)
                .setMaxRetryDelayDuration(Duration.ofMillis(5000))
                .setTotalTimeoutDuration(Duration.ofHours(24))
                .build());
    userEventServiceSettingsBuilder
        .createClusterOperationSettings()
        .setPollingAlgorithm(timedRetryAlgorithm)
        .build();
  }
}