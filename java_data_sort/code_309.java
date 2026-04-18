package io.stargate.sgv2.jsonapi.service.operation.tables;

import com.datastax.oss.driver.api.querybuilder.select.Select;
import io.stargate.sgv2.jsonapi.service.operation.query.OrderByCqlClause;
import io.stargate.sgv2.jsonapi.service.schema.tables.ApiTypeName;
import io.stargate.sgv2.jsonapi.service.shredding.CqlNamedValueContainer;
import io.stargate.sgv2.jsonapi.service.shredding.CqlVectorNamedValue;
import io.stargate.sgv2.jsonapi.service.shredding.Deferred;
import java.util.List;
import java.util.Objects;


public class TableOrderByANNCqlClause implements OrderByCqlClause {

  private final CqlVectorNamedValue sortVector;
  private final Integer defaultLimit;

  public TableOrderByANNCqlClause(CqlVectorNamedValue sortVector, Integer defaultLimit) {

    this.sortVector = Objects.requireNonNull(sortVector, "sortVector must not be null");
    this.defaultLimit = Objects.requireNonNull(defaultLimit, "defaultLimit must not be null");

        if (sortVector.apiColumnDef().type().typeName() != ApiTypeName.VECTOR) {
      throw new IllegalArgumentException(
          "Sort vector column is not a vector, got: %s"
              .formatted(sortVector.apiColumnDef().name().asCql(true)));
    }
  }

  @Override
  public Select apply(Select select) {
    return select.orderByAnnOf(sortVector.name(), sortVector.cqlVector());
  }

  @Override
  public boolean fullyCoversCommand() {
    return true;
  }

  @Override
  public Integer getDefaultLimit() {
    return defaultLimit;
  }

  @Override
  public List<? extends Deferred> deferred() {
    return new CqlNamedValueContainer(List.of(sortVector)).deferredValues();
  }
}