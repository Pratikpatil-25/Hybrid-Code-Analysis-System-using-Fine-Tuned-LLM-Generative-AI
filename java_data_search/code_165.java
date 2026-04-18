package com.orientechnologies.spatial.strategy;

import com.orientechnologies.spatial.engine.OLuceneSpatialIndexContainer;
import com.orientechnologies.spatial.query.OSpatialQueryContext;
import com.orientechnologies.spatial.shape.OShapeBuilder;
import java.util.Map;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.spatial.SpatialStrategy;
import org.apache.lucene.spatial.query.SpatialArgs;
import org.apache.lucene.spatial.query.SpatialOperation;
import org.locationtech.spatial4j.shape.Shape;


public class SpatialQueryBuilderContains extends SpatialQueryBuilderAbstract {

  public static final String NAME = "contains";

  public SpatialQueryBuilderContains(OLuceneSpatialIndexContainer manager, OShapeBuilder factory) {
    super(manager, factory);
  }

  @Override
  public OSpatialQueryContext build(Map<String, Object> query) throws Exception {
    Shape shape = parseShape(query);
    SpatialStrategy strategy = manager.strategy();

    if (isOnlyBB(strategy)) {
      shape = shape.getBoundingBox();
    }
    SpatialArgs args = new SpatialArgs(SpatialOperation.Intersects, shape);

    Query filterQuery = strategy.makeQuery(args);

    BooleanQuery q =
        new BooleanQuery.Builder()
            .add(filterQuery, BooleanClause.Occur.MUST)
            .add(new MatchAllDocsQuery(), BooleanClause.Occur.SHOULD)
            .build();

    return new OSpatialQueryContext(null, manager.searcher(), q);
  }

  @Override
  public String getName() {
    return NAME;
  }
}