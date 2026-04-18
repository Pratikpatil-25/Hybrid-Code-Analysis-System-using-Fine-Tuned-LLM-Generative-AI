package io.vertx.ext.consul;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.json.annotations.JsonGen;
import io.vertx.core.json.JsonObject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@DataObject
@JsonGen(publicConverter = false)
public class CoordinateList {

  private long index;
  private List<Coordinate> list;

  
  public CoordinateList() {}

  
  public CoordinateList(CoordinateList other) {
    this.index = other.index;
    this.list = other.list;
  }

  
  public CoordinateList(JsonObject json) {
    CoordinateListConverter.fromJson(json, this);
  }

  
  public JsonObject toJson() {
    JsonObject jsonObject = new JsonObject();
    CoordinateListConverter.toJson(this, jsonObject);
    return jsonObject;
  }

  
  public long getIndex() {
    return index;
  }

  
  public List<Coordinate> getList() {
    return list;
  }

  
  public CoordinateList setIndex(long index) {
    this.index = index;
    return this;
  }

  
  public CoordinateList setList(List<Coordinate> list) {
    this.list = list;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CoordinateList that = (CoordinateList) o;

    if (index != that.index) return false;
    return list != null ? sorted().equals(that.sorted()) : that.list == null;
  }

  @Override
  public int hashCode() {
    int result = (int) (index ^ (index >>> 32));
    result = 31 * result + (list != null ? sorted().hashCode() : 0);
    return result;
  }

  private List<Coordinate> sorted() {
    List<Coordinate> sorted = null;
    if (list != null) {
      sorted = new ArrayList<>(list);
      sorted.sort(Comparator.comparing(Coordinate::getNode));
    }
    return sorted;
  }
}