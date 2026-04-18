package org.opentripplanner.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.opentripplanner.transit.model.timetable.Trip;


public class TripStopTimes {

  private static final List<StopTime> EMPTY_LIST = Collections.emptyList();

  private final Map<Trip, List<StopTime>> map = new HashMap<>();

  
  public List<StopTime> get(Trip key) {
    List<StopTime> list = map.get(key);
    return list == null ? EMPTY_LIST : Collections.unmodifiableList(list);
  }

  public void addAll(Collection<StopTime> values) {
    Set<Trip> keysUpdated = new HashSet<>();
    for (StopTime value : values) {
      Trip key = value.getTrip();
      keysUpdated.add(key);
      map.computeIfAbsent(key, trip -> new ArrayList<>()).add(value);
    }
        for (Trip key : keysUpdated) {
      Collections.sort(map.get(key));
    }
  }

  public void replace(Trip key, Collection<StopTime> list) {
    map.replace(key, sort(list));
  }

  public void put(Trip key, Collection<StopTime> list) {
    map.put(key, sort(list));
  }

  public void removeIf(Predicate<Trip> test) {
    List<Trip> removeKeys = map.keySet().stream().filter(test).collect(Collectors.toList());
    for (Trip removeKey : removeKeys) {
      map.remove(removeKey);
    }
  }

  
  public Map<Trip, List<StopTime>> asImmutableMap() {
    return Map.copyOf(map);
  }

  public int size() {
    return map.size();
  }

  
  public Iterable<Trip> keys() {
    return map.keySet();
  }

  

  private static List<StopTime> sort(Collection<StopTime> list) {
    List<StopTime> values = new ArrayList<>(list);
    Collections.sort(values);
    return values;
  }
}