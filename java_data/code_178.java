package org.opentcs.components.kernel.routing;

import javax.annotation.Nonnull;
import org.opentcs.data.model.Vehicle;
import org.opentcs.util.annotations.ScheduledApiChange;


public interface EdgeEvaluator {

  
  @ScheduledApiChange(details = "Default implementation will be removed.", when = "6.0")
  default void onGraphComputationStart(@Nonnull Vehicle vehicle) {
  }

  
  @ScheduledApiChange(details = "Default implementation will be removed.", when = "6.0")
  default void onGraphComputationEnd(@Nonnull Vehicle vehicle) {
  }

  
  double computeWeight(@Nonnull Edge edge, @Nonnull Vehicle vehicle);
}