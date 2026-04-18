package com.blacklocus.jres.model.search;

import com.blacklocus.jres.strings.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.MoreObjects;

public class Hit {

    @JsonProperty("_index")
    private String index;

    @JsonProperty("_type")
    private String type;

    @JsonProperty("_id")
    private String id;

    @JsonProperty("_score")
    private Double score;

    @JsonProperty("_source")
    private JsonNode source;


    public String getIndex() {
        return index;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public Double getScore() {
        return score;
    }

    public JsonNode getSource() {
        return source;
    }

    
    public <T> T getSourceAsType(Class<T> klass) {
        return source == null ? null : ObjectMappers.fromJson(source, klass);
    }

    
    public <T> T getSourceAsType(TypeReference<T> typeReference) {
        return source == null ? null : ObjectMappers.fromJson(source, typeReference);
    }


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("index", index)
                .add("type", type)
                .add("id", id)
                .add("score", score)
                .add("source", ObjectMappers.toJsonPretty(source))
                .toString();
    }
}