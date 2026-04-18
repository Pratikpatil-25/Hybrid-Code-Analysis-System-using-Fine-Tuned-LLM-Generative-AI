package com.google.api.services.displayvideo.v4.model;


@SuppressWarnings("javadoc")
public final class AlgorithmRules extends com.google.api.client.json.GenericJson {

  
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long attributionModelId;

  
  @com.google.api.client.util.Key
  private AlgorithmRulesRuleset impressionSignalRuleset;

  
  @com.google.api.client.util.Key
  private AlgorithmRulesRuleset postImpressionSignalRuleset;

  
  public java.lang.Long getAttributionModelId() {
    return attributionModelId;
  }

  
  public AlgorithmRules setAttributionModelId(java.lang.Long attributionModelId) {
    this.attributionModelId = attributionModelId;
    return this;
  }

  
  public AlgorithmRulesRuleset getImpressionSignalRuleset() {
    return impressionSignalRuleset;
  }

  
  public AlgorithmRules setImpressionSignalRuleset(AlgorithmRulesRuleset impressionSignalRuleset) {
    this.impressionSignalRuleset = impressionSignalRuleset;
    return this;
  }

  
  public AlgorithmRulesRuleset getPostImpressionSignalRuleset() {
    return postImpressionSignalRuleset;
  }

  
  public AlgorithmRules setPostImpressionSignalRuleset(AlgorithmRulesRuleset postImpressionSignalRuleset) {
    this.postImpressionSignalRuleset = postImpressionSignalRuleset;
    return this;
  }

  @Override
  public AlgorithmRules set(String fieldName, Object value) {
    return (AlgorithmRules) super.set(fieldName, value);
  }

  @Override
  public AlgorithmRules clone() {
    return (AlgorithmRules) super.clone();
  }

}